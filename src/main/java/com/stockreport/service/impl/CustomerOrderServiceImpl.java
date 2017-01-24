package com.stockreport.service.impl;

import com.stockreport.dao.CustomerOrderDao;
import com.stockreport.model.Cart;
import com.stockreport.model.CartItem;
import com.stockreport.model.CustomerOrder;
import com.stockreport.service.CartService;
import com.stockreport.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Matty on 13/10/2016.
 */

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

    @Autowired
    private CustomerOrderDao customerOrderDao;

    @Autowired
    private CartService cartService;

    public void addCustomerOrder(CustomerOrder customerOrder) {
        customerOrderDao.addCustomerOrder(customerOrder);
    }

    public double getCustomerOrderTotal(int cartId) {
        double total = 0;
        Cart cart = cartService.getCartById(cartId);
        List<CartItem> cartItems = cart.getCartItems();

        for(CartItem item : cartItems) {
            total += item.getQuantity();
        }

        return total;
    }

    public List<CustomerOrder> getAllCustomersWithOrders() {
        return this.customerOrderDao.getAllCustomersWithOrders();
    }

    public CustomerOrder findCustomerOrderByOrderId(int id) {
        return customerOrderDao.findCustomerOrderByOrderId(id);
    }

    public CustomerOrder getCustomerIdByOrderId(int id) {
        return customerOrderDao.getCustomerIdByOrderId(id);
    }

    public List<CustomerOrder> getCustomerOrderHistoryById(int id) {
        return customerOrderDao.getCustomerOrderHistoryById(id);
    }

    public List<CustomerOrder> getMyOrderHistoryById(int cartId) {
        return customerOrderDao.getMyOrderHistoryById(cartId);
    }

    public List<CustomerOrder> getCustomerOrderById(int id) {
        return customerOrderDao.getCustomerOrderById(id);
    }

    public void deleteCustomerOrder(CustomerOrder customerOrder) {
        customerOrderDao.deleteCustomerOrder(customerOrder);
    }

    public List<CustomerOrder> getAllCustomerOrderByStatus() {
        return customerOrderDao.getAllCustomerOrderByStatus();
    }
}
