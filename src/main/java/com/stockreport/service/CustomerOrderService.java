package com.stockreport.service;

import com.stockreport.model.CustomerOrder;

import java.util.List;

/**
 * Created by Matty on 13/10/2016.
 */
public interface CustomerOrderService {

    void addCustomerOrder(CustomerOrder customerOrder);

    double getCustomerOrderTotal(int cartId);

    List<CustomerOrder> getAllCustomersWithOrders();

    List<CustomerOrder> getCustomerOrderById(int id);

    List<CustomerOrder> getMyOrderHistoryById(int cartId);

    List<CustomerOrder> getCustomerOrderHistoryById(int id);

    CustomerOrder findCustomerOrderByOrderId(int id);

    CustomerOrder getCustomerIdByOrderId(int id);

    void deleteCustomerOrder(CustomerOrder customerOrder);

    List<CustomerOrder> getAllCustomerOrderByStatus();
}
