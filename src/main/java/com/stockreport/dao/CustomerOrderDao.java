package com.stockreport.dao;

import com.stockreport.model.CustomerOrder;

import java.util.List;

/**
 * Created by Matty on 13/10/2016.
 */
public interface CustomerOrderDao {

    void addCustomerOrder(CustomerOrder customerOrder);

    List<CustomerOrder> getAllCustomersWithOrders();

    List<CustomerOrder> getCustomerOrderById(int id);

    List<CustomerOrder> getCustomerOrderHistoryById(int id);

    List<CustomerOrder> getMyOrderHistoryById(int cartId);

    CustomerOrder findCustomerOrderByOrderId(int id);

    CustomerOrder getCustomerIdByOrderId(int id);

    void deleteCustomerOrder(CustomerOrder customerOrder);

    List<CustomerOrder> getAllCustomerOrderByStatus();

}
