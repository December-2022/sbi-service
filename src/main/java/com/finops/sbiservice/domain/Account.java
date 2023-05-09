package com.finops.sbiservice.domain;

import java.time.LocalDate;
import java.util.Objects;

public class Account {

    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;

    private String nationality;

    private String mobileNumber;

    private Gender gender;

    private String guardianName;

    private String emailId;

    private String aadharNumber;

    private String nominee;

    private AccountType accountType;

    private boolean isInternetBankingRequired;

    private String panCardNumber;

    private double openingBalance;

    private double closingBalance;

    private String branch;

    private boolean isSmsAlertsRequired;

    private String city;

    private String ifscCode;

    private boolean isChequeBookRequired;

    private Occupation occupation;

    private Address address;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public String getNominee() {
        return nominee;
    }

    public void setNominee(String nominee) {
        this.nominee = nominee;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public boolean isInternetBankingRequired() {
        return isInternetBankingRequired;
    }

    public void setInternetBankingRequired(boolean internetBankingRequired) {
        isInternetBankingRequired = internetBankingRequired;
    }

    public String getPanCardNumber() {
        return panCardNumber;
    }

    public void setPanCardNumber(String panCardNumber) {
        this.panCardNumber = panCardNumber;
    }

    public double getOpeningBalance() {
        return openingBalance;
    }

    public void setOpeningBalance(double openingBalance) {
        this.openingBalance = openingBalance;
    }

    public double getClosingBalance() {
        return closingBalance;
    }

    public void setClosingBalance(double closingBalance) {
        this.closingBalance = closingBalance;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public boolean isSmsAlertsRequired() {
        return isSmsAlertsRequired;
    }

    public void setSmsAlertsRequired(boolean smsAlertsRequired) {
        isSmsAlertsRequired = smsAlertsRequired;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public boolean isChequeBookRequired() {
        return isChequeBookRequired;
    }

    public void setChequeBookRequired(boolean chequeBookRequired) {
        isChequeBookRequired = chequeBookRequired;
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return isInternetBankingRequired == account.isInternetBankingRequired && Double.compare(account.openingBalance, openingBalance) == 0 && Double.compare(account.closingBalance, closingBalance) == 0 && isSmsAlertsRequired == account.isSmsAlertsRequired && isChequeBookRequired == account.isChequeBookRequired && Objects.equals(firstName, account.firstName) && Objects.equals(lastName, account.lastName) && Objects.equals(dateOfBirth, account.dateOfBirth) && Objects.equals(nationality, account.nationality) && Objects.equals(mobileNumber, account.mobileNumber) && gender == account.gender && Objects.equals(guardianName, account.guardianName) && Objects.equals(emailId, account.emailId) && Objects.equals(aadharNumber, account.aadharNumber) && Objects.equals(nominee, account.nominee) && accountType == account.accountType && Objects.equals(panCardNumber, account.panCardNumber) && Objects.equals(branch, account.branch) && Objects.equals(city, account.city) && Objects.equals(ifscCode, account.ifscCode) && occupation == account.occupation && Objects.equals(address, account.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, dateOfBirth, nationality, mobileNumber, gender, guardianName, emailId, aadharNumber, nominee, accountType, isInternetBankingRequired, panCardNumber, openingBalance, closingBalance, branch, isSmsAlertsRequired, city, ifscCode, isChequeBookRequired, occupation, address);
    }

    @Override
    public String toString() {
        return "Account{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", nationality='" + nationality + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", gender=" + gender +
                ", guardianName='" + guardianName + '\'' +
                ", emailId='" + emailId + '\'' +
                ", aadharNumber='" + aadharNumber + '\'' +
                ", nominee='" + nominee + '\'' +
                ", accountType=" + accountType +
                ", isInternetBankingRequired=" + isInternetBankingRequired +
                ", panCardNumber='" + panCardNumber + '\'' +
                ", openingBalance=" + openingBalance +
                ", closingBalance=" + closingBalance +
                ", branch='" + branch + '\'' +
                ", isSmsAlertsRequired=" + isSmsAlertsRequired +
                ", city='" + city + '\'' +
                ", ifscCode='" + ifscCode + '\'' +
                ", isChequeBookRequired=" + isChequeBookRequired +
                ", occupation=" + occupation +
                ", address=" + address +
                '}';
    }
}
