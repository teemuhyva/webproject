package com.stockreport.controller;

import com.stockreport.model.Customer;
import com.stockreport.model.CustomerOrder;
import com.stockreport.service.CustomerOrderService;
import com.stockreport.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Matty on 09/10/2016.
 */

@Controller
@RequestMapping("/customer/cart")
public class CartController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerOrderService customerOrderService;

    @RequestMapping
    public String getCart(@AuthenticationPrincipal User activeUser) {
        Customer customer = customerService.getCustomerByUsername(activeUser.getUsername());
        int cartId = customer.getCart().getCartId();

        return "redirect:/customer/cart/" + cartId;

    }

    @RequestMapping("/myOrder")
    public String getMyOrder(@AuthenticationPrincipal User activeUser, Model model) {
        Customer customer = customerService.getCustomerByUsername(activeUser.getUsername());
        int cartId = customer.getCart().getCartId();

        List<CustomerOrder> myOrder = customerOrderService.getCustomerOrderById(cartId);

        model.addAttribute("myOrder", myOrder);

        return "myOrder";
    }

    @RequestMapping("/myHistory")
    public String getMyHistory(@AuthenticationPrincipal User activeUser, Model model) {
        Customer customer = customerService.getCustomerByUsername(activeUser.getUsername());
        int cartId = customer.getCart().getCartId();

        List<CustomerOrder> myhistory = customerOrderService.getMyOrderHistoryById(cartId);

        model.addAttribute("myhistory", myhistory);

        return "myOrderHistory";
    }

    @RequestMapping("/{cartId}")
    public String getCartRedirect(@PathVariable(value = "cartId") int cartId, Model model) {
        model.addAttribute("cartId", cartId);

        return "cart";
    }


}
