package com.how2java.tmall.service;

import com.how2java.tmall.pojo.Property;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PropertyService  {


    public  void add(Property property);

    public  void delete(int id);

    public  void update( Property property);

    public List<Property> list(int cid );

    public  Property get(int id);

}
