package Addresses;

import Addresses.Address;

public class HomeAddress implements Address {
    private String addressTitle;
    private String street;
    public String city;
    public String country;
    public String postalCode;

    public HomeAddress(String addressTitle, String street, String city, String country, String postalCode) {
        this.addressTitle = addressTitle;
        this.street = street;
        this.city = city;
        this.country = country;
        this.postalCode = postalCode;
    }

    public String getAddressTitle() {
        return this.addressTitle;
    }

    public void setAddressTitle(String addressTitle) {
        this.addressTitle = addressTitle;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
