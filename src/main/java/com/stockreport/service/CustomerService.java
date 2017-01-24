package com.stockreport.service;

import com.stockreport.model.Customer;

import java.util.List;

/**
 * Created by Matty on 09/10/2016.
 */
public interface CustomerService {

    void addCustomer(Customer customer);

    Customer getCustomerById(int customerId);

    List<Customer> getAllCustomers();

    Customer getCustomerByUsername(String username);

    void removeCustomer(Customer customer);

    void editCustomer(Customer customer);
}
