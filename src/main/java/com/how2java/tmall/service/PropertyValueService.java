package com.how2java.tmall.service;

import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.pojo.PropertyValue;

import java.util.List;

public interface PropertyValueService {



    public  PropertyValue get(int ptid, int pid);

    public List<PropertyValue> lists( int pid );

    public void init(Product p);

    public  void update( PropertyValue propertyValue);

}
