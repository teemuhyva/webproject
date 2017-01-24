package com.stockreport.service.impl;

import com.stockreport.dao.CartItemDao;
import com.stockreport.model.Cart;
import com.stockreport.model.CartItem;
import com.stockreport.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Matty on 10/10/2016.
 */

@Service
public class CartItemServiceImpl implements CartItemService{

    @Autowired
    private CartItemDao cartItemDao;

    public void addCartItem(CartItem cartItem) {
        cartItemDao.addCartItem(cartItem);
    }

    public void removeCartItem(CartItem cartItem) {
        cartItemDao.removeCartItem(cartItem);
    }

    public void removeAllCartItems(Cart cart) {
        cartItemDao.removeAllCartItems(cart);

    }

    public CartItem getCartItemByProductId(int id) {
        return cartItemDao.getCartItemByProductId(id);
    }

    public List<CartItem> getCartItemByCartId(int id) {
        return this.cartItemDao.getCartItemByCartId(id);
    }
}
