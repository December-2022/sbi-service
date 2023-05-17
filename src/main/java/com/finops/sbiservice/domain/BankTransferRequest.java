package com.finops.sbiservice.domain;

import java.util.Objects;

public class BankTransferRequest {

    private String fromAadharNumber;

    private String toAadharNumber;

    private String beneficiaryName;

    private String ifscCode;

    private double amountTobeTransferred;


    public String getFromAadharNumber() {
        return fromAadharNumber;
    }

    public void setFromAadharNumber(String fromAadharNumber) {
        this.fromAadharNumber = fromAadharNumber;
    }

    public String getToAadharNumber() {
        return toAadharNumber;
    }

    public void setToAadharNumber(String toAadharNumber) {
        this.toAadharNumber = toAadharNumber;
    }

    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    public void setBeneficiaryName(String beneficiaryName) {
        this.beneficiaryName = beneficiaryName;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public double getAmountTobeTransferred() {
        return amountTobeTransferred;
    }

    public void setAmountTobeTransferred(double amountTobeTransferred) {
        this.amountTobeTransferred = amountTobeTransferred;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankTransferRequest that = (BankTransferRequest) o;
        return Double.compare(that.amountTobeTransferred, amountTobeTransferred) == 0 && Objects.equals(fromAadharNumber, that.fromAadharNumber) && Objects.equals(toAadharNumber, that.toAadharNumber) && Objects.equals(beneficiaryName, that.beneficiaryName) && Objects.equals(ifscCode, that.ifscCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fromAadharNumber, toAadharNumber, beneficiaryName, ifscCode, amountTobeTransferred);
    }

    @Override
    public String toString() {
        return "BankTransferRequest{" +
                "fromAadharNumber='" + fromAadharNumber + '\'' +
                ", toAadharNumber='" + toAadharNumber + '\'' +
                ", beneficiaryName='" + beneficiaryName + '\'' +
                ", ifscCode='" + ifscCode + '\'' +
                ", amountTobeTransferred=" + amountTobeTransferred +
                '}';
    }
}
