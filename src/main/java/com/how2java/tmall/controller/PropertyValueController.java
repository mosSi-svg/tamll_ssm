package com.how2java.tmall.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.tmall.mapper.ProductMapper;
import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.pojo.PropertyValue;
import com.how2java.tmall.service.ProductService;
import com.how2java.tmall.service.PropertyValueService;
import com.how2java.tmall.util.page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.*;
@Controller
@RequestMapping("")
public class PropertyValueController {
    @Autowired
    PropertyValueService propertyValueService;
    @Autowired
    ProductService productService;
    @RequestMapping("admin_propertyValue_edit")

    public  String edit(Model  model , int pid ,page page){
        Product product =  productService.get(pid);
        PageHelper.offsetPage(page.getStart(),page.getCount());
        propertyValueService.init(product);
        List<PropertyValue> lists =  propertyValueService.list(product.getId());
        int total =  (int )new PageInfo<PropertyValue>(lists).getTotal();
        page.setTotal(total);
        model.addAttribute("page",page);
        model.addAttribute("pvs",lists);
        model.addAttribute("product",product);
        return "admin/listPropertyValue";
    }



}
