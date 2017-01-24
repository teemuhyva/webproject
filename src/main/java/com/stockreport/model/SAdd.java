package com.stockreport.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Matty on 08/10/2016.
 */

@Entity
public class SAdd implements Serializable{

    private static final long serialVersionUID = -8124883360622443845L;

    @Id
    @GeneratedValue
    private int sAdd;

    private String streetName;
    private String building;
    private String city;
    private String country;
    private String zipCode;

    @OneToOne
    private Customer customer;

    public int getsAdd() {
        return sAdd;
    }

    public void setsAdd(int sAdd) {
        this.sAdd = sAdd;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "ShippingAddress{" +
                "shippingAddress=" + sAdd +
                ", streetName='" + streetName + '\'' +
                ", building='" + building + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
