package com.stockreport.dao.impl;

import com.stockreport.dao.ProductDao;
import com.stockreport.model.*;
import com.stockreport.service.CartItemService;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Teemu on 14/09/2016.
 */

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private CartItemService cartItemService;

   public Product getProductById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Product product = (Product) session.get(Product.class, id);
        session.flush();

        return product;
   }

    public List<Product> getProductList() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product");
        List<Product> productList = query.list();
        session.flush();

        return productList;
    }

    public List<ProductCategory> getProductCategoryList() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from ProductCategory");
        List<ProductCategory> productCategoryList = query.list();
        session.flush();

        return productCategoryList;
    }

    public List<Product> getProductByCategory(String category) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product where productCategory = ?");
        query.setString(0, category);
        List<Product> categories = query.list();
        session.flush();

        return categories;
    }

    public void addProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }

    public void editProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }

    public void deleteProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(product);
        session.flush();
    }

    public Product getProductUnitCount(int id) {
        Session session = sessionFactory.getCurrentSession();
        Product product = (Product) session.get(Product.class, id);
        session.flush();

        return product;
    }
}
