package com.stockreport.dao.impl;

import com.stockreport.dao.CustomerOrderDao;
import com.stockreport.model.CartItem;
import com.stockreport.model.CustomerOrder;
import com.stockreport.model.Product;
import com.stockreport.service.ProductService;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by Matty on 13/10/2016.
 */

@Repository
@Transactional
public class CustomerOrderDaoImpl implements CustomerOrderDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ProductService productService;

    public void addCustomerOrder(CustomerOrder customerOrder) {
        int updatedUnitcount = 0;
        int currentUniCount = 0;

        for(CartItem item : customerOrder.getCart().getCartItems()) {

            updatedUnitcount  = item.getQuantity();
            Product product = productService.getProductUnitCount(customerOrder.getProduct().getpId());

            currentUniCount = product.getUnitCount();
            product.setUnitCount(currentUniCount - updatedUnitcount);

            Session session = sessionFactory.getCurrentSession();
            session.saveOrUpdate(product);
            session.flush();

        }

        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(customerOrder);
        session.flush();
    }

    public List<CustomerOrder> getAllCustomersWithOrders() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from CustomerOrder where status = ?");
        query.setString(0, "active");
        List<CustomerOrder> customerOrderList = query.list();
        session.flush();

        Map<Integer, CustomerOrder> customerOrderMap = new LinkedHashMap<Integer, CustomerOrder>();

        for(CustomerOrder co : customerOrderList) {
            if(!customerOrderMap.containsKey(co.getCustomer().getCustomerId())) {
                customerOrderMap.put(co.getCustomer().getCustomerId(), co);
            }
        }

        customerOrderList.clear();
        customerOrderList.addAll(customerOrderMap.values());

        return customerOrderList;
    }

    public List<CustomerOrder> getCustomerOrderById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from CustomerOrder where customerId = ? and status = ?");
        query.setInteger(0, id);
        query.setString(1, "active");
        List<CustomerOrder> customerOrderList = query.list();
        session.flush();

        return customerOrderList;
    }

    public CustomerOrder findCustomerOrderByOrderId(int id) {
        Session session = sessionFactory.getCurrentSession();
        return (CustomerOrder) session.get(CustomerOrder.class, id);
    }

    public void deleteCustomerOrder(CustomerOrder customerOrder) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("update CustomerOrder set status = ? where customerOrderId = ?");
        query.setString(0, "inactive");
        query.setInteger(1, customerOrder.getCustomerOrderId());
        query.executeUpdate();
        session.flush();
    }

    public CustomerOrder getCustomerIdByOrderId(int customerOrderId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from CustomerOrder where customerOrderId = ?");
        query.setInteger(0, customerOrderId);
        return (CustomerOrder) query.uniqueResult();
    }

    public List<CustomerOrder> getAllCustomerOrderByStatus() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from CustomerOrder where status = ?");
        query.setString(0, "inactive");
        List<CustomerOrder> getOrderByStatus = query.list();
        session.flush();

        Map<Integer, CustomerOrder> customerOrderMap = new LinkedHashMap<Integer, CustomerOrder>();

        for(CustomerOrder co : getOrderByStatus) {
            if(!customerOrderMap.containsKey(co.getCustomer().getCustomerId())) {
                customerOrderMap.put(co.getCustomer().getCustomerId(), co);
            }
        }

        getOrderByStatus.clear();
        getOrderByStatus.addAll(customerOrderMap.values());

        return getOrderByStatus;
    }

    public List<CustomerOrder> getCustomerOrderHistoryById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from CustomerOrder where customerId = ? and status = ?");
        query.setInteger(0, id);
        query.setString(1, "inactive");
        List<CustomerOrder> agentOrderhistory = query.list();
        session.flush();

        return agentOrderhistory;
    }

    public List<CustomerOrder> getMyOrderHistoryById(int cartId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from CustomerOrder where cartId = ? and status = ?");
        query.setInteger(0, cartId);
        query.setString(1, "inactive");
        List<CustomerOrder> myHistoryList = query.list();
        session.flush();

        return myHistoryList;
    }
}
