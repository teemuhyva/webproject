package com.stockreport.controller;

import com.stockreport.model.*;
import com.stockreport.service.CartItemService;
import com.stockreport.service.CartService;
import com.stockreport.service.CustomerOrderService;
import com.stockreport.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Matty on 13/10/2016.
 */

@Controller
public class OrderController {

    @Autowired
    private CartService cartService;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private CustomerOrderService customerOrderService;

    @Autowired
    private ProductService productService;

    @RequestMapping("/order/{cartId}")
    @Transactional
    public String createOrder(@PathVariable("cartId") int cartId) {
        Cart cart = cartService.getCartById(cartId);
        List<CartItem> cartItem = cartItemService.getCartItemByCartId(cartId);
        Customer customer = cart.getCustomer();

        for(CartItem item : cartItem) {
            CustomerOrder customerOrder = new CustomerOrder();
            Product product = productService.getProductById(item.getProduct().getpId());
            customerOrder.setCart(cart);
            customerOrder.setCustomer(customer);
            customerOrder.setsAddress(customer.getSAdd());
            customerOrder.setProduct(product);
            customerOrder.setOrderQuantity(item.getQuantity());
            customerOrder.setStatus("active");

            customerOrderService.addCustomerOrder(customerOrder);

        }

        return "redirect:/checkout?cartId=" + cartId;
    }
}
