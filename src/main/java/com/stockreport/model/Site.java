package com.stockreport.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Matty on 21/10/2016.
 */

@Entity
public class Site implements Serializable{

    private static final long serialVersionUID = -8124883360622443845L;

    @Id
    @GeneratedValue
    private int id;

    private String siteName;
    private int productCount;
    private Timestamp currentTime;
    private Timestamp modifiedTime;


    @ManyToOne
    private Product product;

    private int conditionGood;
    private int conditionFaulty;


    public void setConditionGood(int conditionGood) {
        this.conditionGood = conditionGood;
    }

    public void setConditionFaulty(int conditionFaulty) {
        this.conditionFaulty = conditionFaulty;
    }

    public int getConditionGood() {
        return conditionGood;
    }

    public int getConditionFaulty() {
        return conditionFaulty;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public Timestamp getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Timestamp currentTime) {
        this.currentTime = currentTime;
    }

    public Timestamp getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Timestamp modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}
