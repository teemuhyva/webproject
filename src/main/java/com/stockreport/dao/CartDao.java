package com.stockreport.dao;

import com.stockreport.model.Cart;

import java.io.IOException;

/**
 * Created by Teemu on 22/09/2016.
 */


public interface CartDao {

    Cart getCartById(int cartId);

    Cart validate(int cartId) throws IOException;

    void update(Cart cart);
}
