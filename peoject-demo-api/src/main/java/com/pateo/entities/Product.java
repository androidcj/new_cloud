package com.pateo.entities;

import java.io.Serializable;

/**
 * 自定义简单Pojo
 */
public class Product implements Serializable {
    /**
     * 主键ID
     */
    private Long  pid;
    /**
     * 产品名称
     */
    private String  productName;

    /**
     * 数据来源
     */
    private String  dbSource;

    public Product() {
    }

    public Product(String productName) {
        this.productName = productName;
    }

    public Product(Long pid, String productName, String dbSource) {
        this.pid = pid;
        this.productName = productName;
        this.dbSource = dbSource;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDbSource() {
        return dbSource;
    }

    public void setDbSource(String dbSource) {
        this.dbSource = dbSource;
    }
}
