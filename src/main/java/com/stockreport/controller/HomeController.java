package com.stockreport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Matty on 08/10/2016.
 */

@Controller
public class HomeController {

    @RequestMapping("/")
    public String welcome() {
        return "welcome";
    }

    @RequestMapping({"/home"})
    public String home() {
        return "home";
    }

    @RequestMapping("/login")
    public String loginPage(@RequestParam(value = "error", required = false) String error, @RequestParam(value="logout",
            required = false) String logout, Model model) {
        if(error != null) {
            model.addAttribute("error", "Invalid username and password");
        }

        if(logout != null) {
            model.addAttribute("msg", "You have been logged out successfully");
        }

        return "login";
    }

}
