package com.how2java.tmall.controller;

import com.github.pagehelper.PageInfo;
import com.how2java.tmall.util.page;
import com.github.pagehelper.PageHelper;
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.Property;
import com.how2java.tmall.service.CategoryService;
import com.how2java.tmall.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("")
public class PropertyController {
    @Autowired
    PropertyService  propertyService;
    @Autowired
    CategoryService  categoryService;

    @RequestMapping("admin_property_add")
    public  String  add(Model model , Property property){
    propertyService.add(property);
    return  "redirect:admin_property_list?cid="+property.getCid();
    }
    @RequestMapping("admin_property_delete")
    public  String  delete( Model model , int id){
       int ID = propertyService.get(id).getCid();
        propertyService.delete(id);

        return  "redirect:admin_property_list?cid="+ID;
    }

    @RequestMapping("admin_property_edit")
    public String edit(Model model , int id){
    Property property = propertyService.get(id);
    Category category = categoryService.get(property.getCid());
    model.addAttribute("property",property);
    model.addAttribute("c",category);
    return  "admin/editProperty";
    }

    @RequestMapping("admin_property_update")
    public  String update( Model model , Property property){
       propertyService.update(property);
       return  "redirect:admin_property_list?cid="+property.getCid();

    }

    @RequestMapping("admin_property_list")
    public  String list(Model model, int cid, page page){

        Category c = categoryService.get(cid);
        PageHelper.offsetPage(page.getStart(),page.getCount());
        List<Property> ps = propertyService.list(cid);
        int total = (int)new PageInfo<>(ps).getTotal();
        page.setTotal(total);
        page.setParam("&cid="+c.getId());
        model.addAttribute("ps", ps);
        model.addAttribute("c", c);
        model.addAttribute("page", page);
        return "admin/listProperty";
    }

}
