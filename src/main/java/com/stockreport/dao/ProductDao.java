package com.stockreport.dao;

import com.stockreport.model.Product;
import com.stockreport.model.ProductCategory;

import java.util.List;

/**
 * Created by Teemu on 14/09/2016.
 */
public interface ProductDao {

    List<Product> getProductList();

    List<ProductCategory> getProductCategoryList();

    List<Product> getProductByCategory(String category);

    Product getProductById(int id);

    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(Product product);

    Product getProductUnitCount(int id);

}
