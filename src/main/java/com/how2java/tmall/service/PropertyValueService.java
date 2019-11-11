package com.how2java.tmall.service;

import com.how2java.tmall.pojo.Product;
<<<<<<< HEAD
import com.how2java.tmall.pojo.PropertyValue;

import java.util.List;

public interface PropertyValueService {



    public  PropertyValue get(int ptid, int pid);

    public List<PropertyValue> lists( int pid );

    public void init(Product p);

    public  void update( PropertyValue propertyValue);
=======
import com.how2java.tmall.pojo.Property;
import com.how2java.tmall.pojo.PropertyValue;
import java.util.List;

public interface  PropertyValueService {

     public  PropertyValue get( int ptid , int pid);

     public  void  init( Product product);

     public List<PropertyValue>  list( int pid);
>>>>>>> origin/master

}
