package com.stockreport.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Matty on 08/10/2016.
 */

@Entity
public class CustomerOrder implements Serializable{

    private static final long serialVersionUID = 4180246798202471812L;

    @Id
    @GeneratedValue
    private int customerOrderId;

    private Timestamp currentTime;
    private Timestamp modifiedTime;
    private String status;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cartId")
    private Cart cart;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customerId")
    private Customer customer;
    
    @OneToOne
    @JoinColumn(name = "shippingAdd")
    private SAdd sAddress;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pId")
    private Product product;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customerOrderId")
    private Site site;

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    private int orderQuantity;

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCustomerOrderId() {
        return customerOrderId;
    }

    public void setCustomerOrderId(int customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public SAdd getsAddress() {
        return sAddress;
    }

    public void setsAddress(SAdd sAddress) {
        this.sAddress = sAddress;
    }

    public Timestamp getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Timestamp currentTime) {
        this.currentTime = currentTime;
    }

    public Timestamp getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Timestamp modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
