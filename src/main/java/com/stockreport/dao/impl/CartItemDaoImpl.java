package com.stockreport.dao.impl;

import com.stockreport.dao.CartItemDao;
import com.stockreport.model.Cart;
import com.stockreport.model.CartItem;
import com.stockreport.service.CartItemService;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Matty on 10/10/2016.
 */

@Repository
@Transactional
public class CartItemDaoImpl implements CartItemDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addCartItem(CartItem cartItem) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cartItem);
        session.flush();
    }

    public void removeCartItem(CartItem cartItem) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(cartItem);
        session.flush();
    }

    public void removeAllCartItems(Cart cart) {
        List<CartItem> cartItems = cart.getCartItems();

        for(CartItem item : cartItems) {
            removeCartItem(item);
        }
    }

    public CartItem getCartItemByProductId(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from CartItem where product = ?");
        query.setInteger(0, id);
        session.flush();

        return (CartItem) query.uniqueResult();

    }

    public List<CartItem> getCartItemByCartId(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("from CartItem where cartId = ?");
        query.setInteger(0, id);
        List cartItems = query.list();
        session.flush();
        return cartItems;
    }
}
