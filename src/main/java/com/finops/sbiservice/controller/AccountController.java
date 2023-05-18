package com.finops.sbiservice.controller;

import com.finops.sbiservice.domain.Account;
import com.finops.sbiservice.domain.BankTransferRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {


    @Autowired
    private MongoTemplate mongoTemplate;

    @PostMapping("/create-account")
    public Account createAccount(@RequestBody Account account){

        Account createdAccount = mongoTemplate.save(account, "Accounts"); //Create operation
        return createdAccount;

    }

//    50100107290312


    @GetMapping("/getAccountByAadharNumber")
    public List<Account> getAccountByAadharNumber(@RequestParam String aadharNumber){

        Criteria criteria = Criteria.where("aadharNumber").is(aadharNumber);

        Query query = new Query(criteria);

        List<Account> accounts = mongoTemplate.find(query, Account.class, "Accounts"); //Read

        return accounts;
    }

    @GetMapping("/getOneAccountByAadharNumber")
    public Account getOneAccountByAadharNumber(@RequestParam String aadharNumber){
        Criteria criteria = Criteria.where("aadharNumber").is(aadharNumber);
        Query query = new Query(criteria);
        Account account = mongoTemplate.findOne(query, Account.class, "Accounts"); // Read
        return account;
    }

    @GetMapping("/getOneAccountByMobileNumber")
    public Account getOneAccountByMobileNumber(@RequestParam String mobileNumber){
        Criteria criteria = Criteria.where("mobileNumber").is(mobileNumber);
        Query query = new Query(criteria);
        Account account = mongoTemplate.findOne(query, Account.class, "Accounts"); // Read
        return account;
    }

    @GetMapping("/getClosingBalanceByAadharNumber")
    public double getClosingBalanceByAadharNumber(@RequestParam String aadharNumber){
        Criteria criteria = Criteria.where("aadharNumber").is(aadharNumber);
        Query query = new Query(criteria);
        Account account = mongoTemplate.findOne(query, Account.class, "Accounts"); // Read
        return account.getClosingBalance();

    }


    @GetMapping("/getClosingBalanceByMobileNumber")
    public double getClosingBalanceByMobileNumber(@RequestParam String mobileNumber){
        Criteria criteria = Criteria.where("mobileNumber").is(mobileNumber);
        Query query = new Query(criteria);
        Account account = mongoTemplate.findOne(query, Account.class, "Accounts"); // Read
        return account.getClosingBalance();

    }

    @PostMapping("/update-account")
    public Account updateMobileNumber(@RequestParam String aadharNumber, @RequestParam String mobileNumber){

        Criteria criteria = Criteria.where("aadharNumber").is(aadharNumber);
        Query query = new Query(criteria);
        query.fields().exclude("_id");

        Update update = new Update();
        update.set("mobileNumber", mobileNumber);

        Account updatedAccount = mongoTemplate.findAndModify(query,
                update,
                new FindAndModifyOptions().returnNew(true),
                Account.class,
                "Accounts");

        return updatedAccount;

    }


    @PostMapping("/update-all-account")
    public Account updateAccountInfo(@RequestParam String aadharNumber, @RequestBody Account account){

        Criteria criteria = Criteria.where("aadharNumber").is(aadharNumber);
        Query query = new Query(criteria);
        query.fields().exclude("_id");

        Update update = new Update();
        if(!account.getFirstName().isEmpty()){
            update.set("firstName", account.getFirstName());
        }
        if(!account.getLastName().isEmpty()){
            update.set("lastName", account.getLastName());
        }

        if(account.getDateOfBirth()!=null){
            update.set("dateOfBirth", account.getDateOfBirth());
        }
        if(!account.getNationality().isEmpty()){
            update.set("nationality", account.getNationality());
        }
        if(!account.getMobileNumber().isEmpty()){
            update.set("mobileNumber", account.getMobileNumber());
        }
        if(account.getGender()!=null){
            update.set("gender", account.getGender());
        }
        if(!account.getGuardianName().isEmpty()){
            update.set("guardianName", account.getGuardianName());
        }
        if(!account.getEmailId().isEmpty()){
            update.set("emailId", account.getEmailId());
        }
        if(!account.getAadharNumber().isEmpty()){
            update.set("aadharNumber", account.getAadharNumber());
        }
        if(!account.getNominee().isEmpty()){
            update.set("nominee", account.getNominee());
        }
        if(account.getAccountType()!=null){
            update.set("accountType", account.getAccountType());
        }
        if(account.isInternetBankingRequired()){
            update.set("isInternetBankingRequired", account.isInternetBankingRequired());
        }
        if(!account.getPanCardNumber().isEmpty()){
            update.set("panCardNumber", account.getPanCardNumber());
        }
        if(account.getOpeningBalance()!=0){
            update.set("openingBalance", account.getOpeningBalance());
        }
        if(account.getClosingBalance()!=0){
            update.set("closingBalance", account.getClosingBalance());
        }

        Account updatedAccount = mongoTemplate.findAndModify(query,
                update,
                new FindAndModifyOptions().returnNew(true),
                Account.class,
                "Accounts");

        return updatedAccount;

    }

    @PostMapping("/transfer")
    public String transferAmount(@RequestBody BankTransferRequest bankTransferRequest){

        if(bankTransferRequest.getFromAadharNumber().isEmpty()){
            return "From AccountNumber is mandatory";
        }

        if(bankTransferRequest.getToAadharNumber().isEmpty()){
            return "To account Number is mandatory";
        }

        if(bankTransferRequest.getAmountTobeTransferred()==0){
            return "amount should be more than zero";
        }

        if(bankTransferRequest.getBeneficiaryName().isEmpty()){
            return "beneficiary name is mandatory";
        }

        if(bankTransferRequest.getIfscCode().isEmpty()){
            return "IFSC Code is mandatory";
        }

        Criteria fromCriteria = Criteria.where("aadharNumber").is(bankTransferRequest.getFromAadharNumber());
        Query fromQuery = new Query(fromCriteria);

        Account fromAccount = mongoTemplate.findOne(fromQuery, Account.class, "Accounts");
        Update fromUpdate = new Update();
        fromUpdate.set("closingBalance", fromAccount.getClosingBalance() - bankTransferRequest.getAmountTobeTransferred());

        Account updatedFromAccount = mongoTemplate.findAndModify(fromQuery, fromUpdate,new FindAndModifyOptions().returnNew(true), Account.class, "Accounts");

        Criteria toCriteria = Criteria.where("aadharNumber").is(bankTransferRequest.getToAadharNumber());
        Query toQuery = new Query(toCriteria);
        Account toAccount = mongoTemplate.findOne(toQuery, Account.class, "Accounts");
        Update toUpdate = new Update();
        toUpdate.set("closingBalance", toAccount.getClosingBalance() + bankTransferRequest.getAmountTobeTransferred());

        Account updatedToAccount = mongoTemplate.findAndModify(toQuery, toUpdate, new FindAndModifyOptions().returnNew(true),Account.class, "Accounts");

        return "Amount "+bankTransferRequest.getAmountTobeTransferred()
                +" is succesfully transferred to "+updatedToAccount.getFirstName()
                + " and the available balance is "+updatedFromAccount.getClosingBalance();

    }
    @DeleteMapping("/delete-account")
    public Account deleteAccount(@RequestParam String aadharNumber){
        Criteria criteria = Criteria.where("aadharNumber").is(aadharNumber);
        Query query =new Query(criteria);
        query.fields().exclude("id");

        Account deletedAccount = mongoTemplate.findAndRemove(query, Account.class, "Accounts");

        return deletedAccount;

    }

//    CRUD
//    C--> Create
//    R --> Read
//    U--> Update
//    D--> Delete

    //Update Operation: 1. On what basis, we need to update,
    //                  2. Setting the update values.
    //                  3. Update Operation.

}

/*{
        "aadharNumber": "98765432190",
        "accountType": "CURRENT",
        "address": {
        "city": "Bangalore",
        "district": "Bangalore",
        "flatNumber": "608",
        "landMark": "Brigade road",
        "pinCode": "560038",
        "state": "Karnataka",
        "streetName": "MGROAD"
        },
        "branch": "MGROAD",
        "chequeBookRequired": false,
        "city": "Bangalore",
        "closingBalance": 200,
        "dateOfBirth": "2003-05-10",
        "emailId": "sum@gmail.com",
        "firstName": "Teja",
        "gender": "MALE",
        "guardianName": "Vinay",
        "ifscCode": "HDFC0098765",
        "internetBankingRequired": false,
        "lastName": "Prathap",
        "mobileNumber": "8907685432",
        "nationality": "INDIAN",
        "nominee": "Sid",
        "occupation": "SELFEMPLOYED",
        "openingBalance": 200,
        "panCardNumber": "HGVH9876D",
        "smsAlertsRequired": false
        }*/


/*
{
        "aadharNumber": "",
        "accountType": "CURRENT",
        "address": {
        "city": "",
        "district": "",
        "flatNumber": "",
        "landMark": "",
        "pinCode": "",
        "state": "",
        "streetName": ""
        },
        "branch": "",
        "chequeBookRequired": true,
        "city": "string",
        "closingBalance": 0,
        "dateOfBirth": "2001-05-11",
        "emailId": "",
        "firstName": "",
        "gender": "",
        "guardianName": "",
        "ifscCode": "",
        "internetBankingRequired": true,
        "lastName": "",
        "mobileNumber": "",
        "nationality": "",
        "nominee": "",
        "occupation": "GOVTEMPLOYEE",
        "openingBalance": 0,
        "panCardNumber": "",
        "smsAlertsRequired": true
        }*/

/*
{
        "amountTobeTransferred-1": 10,
        "beneficiaryName": "Teja",
        "fromAadharNumber": "987654321654",
        "ifscCode": "HDFC7t7887",
        "toAadharNumber": "98765432190"
        }*/






