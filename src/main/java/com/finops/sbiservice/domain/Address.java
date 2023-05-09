package com.finops.sbiservice.domain;

import java.util.Objects;

public class Address {

    private String flatNumber;
    private String streetName;
    private String landMark;
    private String city;

    private String district;
    private String pinCode;
    private String state;

    public String getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getLandMark() {
        return landMark;
    }

    public void setLandMark(String landMark) {
        this.landMark = landMark;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(flatNumber, address.flatNumber) && Objects.equals(streetName, address.streetName) && Objects.equals(landMark, address.landMark) && Objects.equals(city, address.city) && Objects.equals(district, address.district) && Objects.equals(pinCode, address.pinCode) && Objects.equals(state, address.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flatNumber, streetName, landMark, city, district, pinCode, state);
    }

    @Override
    public String toString() {
        return "Address{" +
                "flatNumber='" + flatNumber + '\'' +
                ", streetName='" + streetName + '\'' +
                ", landMark='" + landMark + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", pinCode='" + pinCode + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}

