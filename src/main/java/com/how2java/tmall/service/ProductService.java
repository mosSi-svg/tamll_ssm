package com.how2java.tmall.service;

import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.pojo.Property;

import java.util.List;

public interface ProductService {

    void  add(Product product);
    void delete(int id);
    void update(Product product);
    List<Product> list( int cid);
    Product get(int id);
 }
