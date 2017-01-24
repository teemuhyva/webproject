package com.stockreport.service;

import com.stockreport.model.Product;
import com.stockreport.model.ProductCategory;

import java.util.List;

/**
 * Created by Matty on 08/10/2016.
 */
public interface ProductService {

    List<Product> getProductList();

    List<ProductCategory> getProductCategoryList();

    List<Product> getProductByCategory(String productCategory);

    Product getProductById(int id);

    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(Product product);

    Product getProductUnitCount(int id);
}
