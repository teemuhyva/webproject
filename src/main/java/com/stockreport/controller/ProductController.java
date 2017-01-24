package com.stockreport.controller;

import com.stockreport.model.Product;
import com.stockreport.model.ProductCategory;
import com.stockreport.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

/**
 * Created by Matty on 08/10/2016.
 */

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/productCategory")
    public String getProductCategory(Model model) {
        List<ProductCategory> productCategoryList = productService.getProductCategoryList();
        model.addAttribute("productCategoryList", productCategoryList);

        return "productCategory";
    }

    @RequestMapping("/viewStock/{category}")
    public String category(@PathVariable(value = "category") String category, Model model) {
        List<Product> categories = productService.getProductByCategory(category);
        model.addAttribute("categories", categories);

        return "viewStock";
    }

    @RequestMapping("/viewDetails/{id}")
    public String viewProduct(@PathVariable int id, Model model) throws IOException {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);

        return "viewDetails";
    }
}
