package com.stockreport.controller;

import com.stockreport.model.Customer;
import com.stockreport.model.Site;
import com.stockreport.service.CustomerService;
import com.stockreport.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Teemu on 18/01/2017.
 */

@Controller
@RequestMapping("/rest/stocklist")
public class StockRestController {

    @Autowired
    private SiteService siteService;

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/retrievelocation", method = RequestMethod.GET)
    public @ResponseBody String getSiteByUser (@AuthenticationPrincipal User activeUser) {
        Customer customer = customerService.getCustomerByUsername(activeUser.getUsername());
        String sitename = customer.getSAdd().getStreetName();
        return sitename;
    }

    @RequestMapping(value = "/stocklistBySite", method = RequestMethod.GET)
    public @ResponseBody  List<Site> getUniqueSiteList(@RequestParam("name") String name) {
        List<Site> siteListBySiteName = siteService.getStockBySite(name);

        return siteListBySiteName;
    }

    @RequestMapping(value = "/stockpost", method = RequestMethod.PUT, consumes="application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void postUpdate(@RequestBody Site site) {
        siteService.updateStock(site);
    }
}
