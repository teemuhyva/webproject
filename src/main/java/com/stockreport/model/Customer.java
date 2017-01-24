package com.stockreport.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Matty on 08/10/2016.
 */

@Entity
public class Customer implements Serializable{

    private static final long serialVersionUID = -5238786920759203526L;

    @Id
    @GeneratedValue
    private int customerId;

    private Timestamp creationDate;

    private Timestamp modificationDate;

    @NotEmpty(message = "The customer name cannot be empty")
    @Size(min = 4, max = 40)
    private String customerName;

    @NotEmpty(message = "The customer email cannot be empty, Example myemail@ie.ibm.com")
    @Email
    private String customerEmail;

    @NotEmpty(message = "Need to provide phonenumber. Example 1231234567")
    @Pattern(regexp = "\\d{10}")
    private String customerPhone;

    @NotEmpty(message = "The username cannot be empty")
    @Size(min = 5, max = 30)
    private String username;

    @NotEmpty(message = "The password cannot be empty")
    @Size(min = 6, max = 20)
    private String password;

    private boolean enabled;

    @OneToOne
    @JoinColumn(name = "sAdd")
    private SAdd sAdd;

    @OneToOne
    @JoinColumn(name = "cartId")
    @JsonIgnore
    private Cart cart;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public SAdd getSAdd() {
        return sAdd;
    }

    public void setSAdd(SAdd sAdd) {
        this.sAdd = sAdd;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public Timestamp getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Timestamp modificationDate) {
        this.modificationDate = modificationDate;
    }
}
