package com.stockreport.controller;

import com.stockreport.model.Customer;
import com.stockreport.model.Site;
import com.stockreport.service.CustomerService;
import com.stockreport.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

/**
 * Created by Teemu on 23/12/2016.
 */

@Controller
@RequestMapping("/stockxml")
public class StockController {

    @Autowired
    SiteService siteService;

    @Autowired
    CustomerService customerService;

    @RequestMapping("/viewStockByUserLocation")
    public String viewStockBySite(Model model) throws IOException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String loggedInUser = authentication.getName();
        Customer username = customerService.getCustomerByUsername(loggedInUser);
        List<Site> site = siteService.viewSiteStockBySiteAddress(username.getSAdd().getStreetName());
        model.addAttribute("site", site);

        return "viewStockBySite";
    }

    @RequestMapping("/createXml")
    public String createXml() throws IOException {


        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String loggedInUser = authentication.getName();
        Customer siteObject = customerService.getCustomerByUsername(loggedInUser);
        siteService.createxml(siteObject);

        return "redirect: /stockreport/stockxml/viewStockByUserLocation";
    }

}
