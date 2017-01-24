package com.stockreport.service.impl;

import com.stockreport.dao.ProductDao;
import com.stockreport.model.Product;
import com.stockreport.model.ProductCategory;
import com.stockreport.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Matty on 08/10/2016.
 */

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    public Product getProductById(int productId) {
        return productDao.getProductById(productId);
    }

    public List<Product> getProductByCategory(String productCategory) {
        return productDao.getProductByCategory(productCategory);
    }

    public List<Product> getProductList() {
        return productDao.getProductList();
    }

    public List<ProductCategory> getProductCategoryList() {
        return productDao.getProductCategoryList();
    }

    public void addProduct(Product product) {
        productDao.addProduct(product);
    }

    public void editProduct(Product product) {
        productDao.editProduct(product);
    }

    public void deleteProduct(Product product) {
        productDao.deleteProduct(product);
    }

    public Product getProductUnitCount(int id) {
        return productDao.getProductUnitCount(id);
    }

}
