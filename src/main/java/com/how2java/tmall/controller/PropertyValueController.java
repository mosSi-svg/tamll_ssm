package com.how2java.tmall.controller;

<<<<<<< HEAD
=======
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.tmall.mapper.ProductMapper;
>>>>>>> origin/master
import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.pojo.PropertyValue;
import com.how2java.tmall.service.ProductService;
import com.how2java.tmall.service.PropertyValueService;
<<<<<<< HEAD
=======
import com.how2java.tmall.util.page;
>>>>>>> origin/master
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

=======
import java.util.*;
>>>>>>> origin/master
@Controller
@RequestMapping("")
public class PropertyValueController {
    @Autowired
    PropertyValueService propertyValueService;
    @Autowired
    ProductService productService;
<<<<<<< HEAD

    @RequestMapping("admin_propertyValue_edit")
    public String edit(Model model,int pid) {
        Product p = productService.get(pid);
        propertyValueService.init(p);
        List<PropertyValue> pvs = propertyValueService.lists(p.getId());

        model.addAttribute("p", p);
        model.addAttribute("pvs", pvs);
        return "admin/editPropertyValue";
    }
    @RequestMapping("admin_propertyValue_update")
    @ResponseBody
    public String update(PropertyValue pv) {
        propertyValueService.update(pv);
        return "success";
    }
}
=======
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
>>>>>>> origin/master
