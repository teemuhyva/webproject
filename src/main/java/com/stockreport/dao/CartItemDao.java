package com.stockreport.dao;

import com.stockreport.model.Cart;
import com.stockreport.model.CartItem;

import java.util.List;

/**
 * Created by Matty on 10/10/2016.
 */
public interface CartItemDao {

    void addCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    void removeAllCartItems(Cart cart);

    CartItem getCartItemByProductId(int id);

    List<CartItem> getCartItemByCartId(int id);
}
