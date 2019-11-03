package com.how2java.tmall.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.service.CategoryService;
import com.how2java.tmall.service.ProductService;
import com.how2java.tmall.util.page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("")
public class ProductController {
    @Autowired
    ProductService  productService;

    @Autowired
    CategoryService categoryService;

    @RequestMapping("admin_product_list")
    public  String list(int cid ,Model model , page page){
        PageHelper.offsetPage(page.getStart(),page.getCount());
        List<Product> products= productService.list(cid) ;
        int total = (int)new PageInfo<>(products).getTotal();
        page.setTotal(total);
        Category c = categoryService.get(cid);
        model.addAttribute("page",page);
        model.addAttribute("c",c);
        model.addAttribute("products",products);
        return  "admin/listProduct";
    }

    @RequestMapping("admin_product_delete")
    public  String delete( int id,Model model){
               int cid = productService.get(id).getCid();
                productService.delete(id);
                model.addAttribute("cid",cid);
                return "redirect:admin_product_list";
    }
    @RequestMapping("admin_product_add")

        public String add(Model model , Product product ){
        productService.add(product);
        model.addAttribute("cid",product.getCid());
        return "redirect:admin_product_list";
    }

    @RequestMapping("admin_product_edit")

    public String edit( int id  ,Model model ){
       Product product = productService.get(id);
       model.addAttribute("product",product);
       return "admin/editProduct";

    }

    @RequestMapping("admin_product_update")

    public  String update( Model model, Product product){
        productService.update(product);
        model.addAttribute("cid",product.getCid());
        return "redirect:admin_product_list";
    }

}
