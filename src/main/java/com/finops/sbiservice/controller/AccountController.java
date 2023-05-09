package com.finops.sbiservice.controller;

import com.finops.sbiservice.domain.Account;
import com.finops.sbiservice.domain.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {


    @Autowired
    private MongoTemplate mongoTemplate;

    @PostMapping("/create-account")
    public Account createAccount(@RequestBody Account account){

        Account createdAccount = mongoTemplate.save(account, "Accounts");
        return createdAccount;

    }

    @PostMapping("/create-address")
    public String createAddress(@RequestBody Address address){


        return "createdAccount";

    }
}
