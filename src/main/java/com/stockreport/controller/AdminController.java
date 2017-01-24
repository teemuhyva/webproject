package com.stockreport.controller;

import com.stockreport.model.*;
import com.stockreport.service.CustomerOrderService;
import com.stockreport.service.CustomerService;
import com.stockreport.service.ProductService;
import com.stockreport.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Matty on 09/10/2016.
 */

@Controller
@RequestMapping("/admin")
public class AdminController {

    private Path path;

    @Autowired
    private ProductService productService;

    @Autowired
    private SiteService siteService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerOrderService customerOrderService;

    @RequestMapping
    public String adminPage() {
        return "admin";
    }

    @RequestMapping("/orderHistory")
    public String orderHistory(Model model) {
        List<CustomerOrder> orderHistoryList = customerOrderService.getAllCustomerOrderByStatus();
        model.addAttribute("orderHistoryList", orderHistoryList);

        return "orderHistory";
    }

    @RequestMapping("/orderHistory/agentHistory/{id}")
    public String agentHistory(@PathVariable("id") int id, Model model) {
        List<CustomerOrder> agentHistoryList = customerOrderService.getCustomerOrderHistoryById(id);
        model.addAttribute("agentHistoryList", agentHistoryList);
        return "agentHistory";
    }

    @RequestMapping({"/orders"})
    public String orders(Model model) {
        List<CustomerOrder> customerOrderList = customerOrderService.getAllCustomersWithOrders();
        model.addAttribute("customerOrderList", customerOrderList);

        return "orders";
    }

    @RequestMapping({"/orders/agentOrder/{id}"})
    public String agentOrder(@PathVariable("id") int id, Model model) {
        List<CustomerOrder> agentOrder = customerOrderService.getCustomerOrderById(id);
        model.addAttribute("agentOrder", agentOrder);
        return "agentOrder";
    }

    @RequestMapping("/orders/clearOrderById/{id}")
    public String deleteCustomerOrderById(@PathVariable("id") int id) {
        CustomerOrder customerId = customerOrderService.getCustomerIdByOrderId(id);
        CustomerOrder customerOrder = customerOrderService.findCustomerOrderByOrderId(id);
        customerOrderService.deleteCustomerOrder(customerOrder);
        siteService.modifyUnitCountPerSite(customerOrder);

        return "redirect:/admin/orders/agentOrder/" + customerId.getCustomer().getCustomerId();

    }

    @RequestMapping("/siteList")
    public String siteList(Model model) {
        List<Site> siteList = siteService.getAllSites();
        model.addAttribute("siteList", siteList);

        return "siteList";
    }

    @RequestMapping("/siteList/siteStock/{site}")
    public String categorySite(@PathVariable(value = "site") String site, Model model) {
        List<Site> siteStock = siteService.getStockBySite(site);
        model.addAttribute("siteStock", siteStock);

        return "siteStock";
    }

    @RequestMapping("/productInventory")
    public String productInventory(Model model) {
        List<Product> products = productService.getProductList();
        model.addAttribute("products", products);

        return "productInventory";
    }


    @RequestMapping("/product/addProduct")
    public String addProduct(Model model) {
        Product product = new Product();
        product.setProductCondition("new");
        product.setProductManufacturer("dell");

        model.addAttribute("product", product);

        return "addProduct";
    }

    @RequestMapping(value = "/product/addProduct", method = RequestMethod.POST)
    public String addProductPost(@Valid @ModelAttribute("product") Product product, BindingResult result, HttpServletRequest request) {

        if(result.hasErrors()) {
            return "addProduct";
        }

        productService.addProduct(product);

        MultipartFile productImage = product.getProdImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + product.getpId() + ".png");

        if (productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(path.toString()));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Product image saving failed", e);
            }
        }

        return "redirect:/admin/productInventory";
    }

    @RequestMapping("/product/updateProduct/{id}")
    public String updateProduct(@PathVariable("id") int id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);

        return "updateProduct";
    }


    @RequestMapping(value = "/product/updateProduct", method = RequestMethod.POST)
    public String updateProduct(@Validated @ModelAttribute("product") Product product, BindingResult result, HttpServletRequest request) {

        if(result.hasErrors()) {
            return "addProduct";
        }

        MultipartFile productImage = product.getProdImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + product.getpId() + ".png");

        if (productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(path.toString()));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Product image saving failed", e);
            }
        }


        productService.editProduct(product);

        return "redirect:/admin/productInventory";
    }

    @RequestMapping("/customer")
    public String customerManagement(Model model) {

        List<Customer> customerList = customerService.getAllCustomers();
        model.addAttribute("customerList", customerList);

        return "customerManagement";
    }

    @RequestMapping("/customer/modifyCustomer/{id}")
    public String modifyCustomer(@PathVariable("id") int id, Model model) {
        Customer customer = customerService.getCustomerById(id);
        model.addAttribute("customer", customer);

        return "modifyCustomer";
    }

    @RequestMapping(value = "/customer/modifyCustomer", method = RequestMethod.POST)
    public String modifyCustomer(@ModelAttribute("customer") Customer customer, BindingResult result) {
        if(result.hasErrors()) {
            return "customerManagement";
        }

        customerService.editCustomer(customer);

        return "redirect:/admin/customer";
    }

    @RequestMapping("/customer/removeCustomer/{id}")
    public String removeCustomer(@PathVariable int id) {

        Customer customer = customerService.getCustomerById(id);
        customerService.removeCustomer(customer);

        return "redirect:/admin/customer";
    }

    @RequestMapping("/product/deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id, Model model, HttpServletRequest request) {


        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + id + ".png");

        if(Files.exists(path)) {
            try {
                Files.delete(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Product product = productService.getProductById(id);
        productService.deleteProduct(product);

        return "redirect:/admin/productInventory";
    }
}
