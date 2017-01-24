package com.stockreport.service.impl;

import com.stockreport.dao.CustomerDao;
import com.stockreport.model.Customer;
import com.stockreport.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Matty on 09/10/2016.
 */

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerDao customerDao;

    public void addCustomer(Customer customer) {
        customerDao.addCustomer(customer);
    }

    public Customer getCustomerById(int customerId) {

        return customerDao.getCustomerById(customerId);
    }
    
    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    public Customer getCustomerByUsername(String username) {
        return customerDao.getCustomerByUsername(username);
    }

    public void removeCustomer(Customer customer) {
        customerDao.removeCustomer(customer);
    }

    public void editCustomer(Customer customer) {
        customerDao.editCustomer(customer);
    }
}
