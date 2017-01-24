package com.stockreport.service;

import com.stockreport.model.Cart;

/**
 * Created by Matty on 10/10/2016.
 */
public interface CartService {

    Cart getCartById(int cartId);

    void update(Cart cart);
}
