package com.how2java.tmall.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.service.CategoryService;
import com.how2java.tmall.util.ImageUtil;
import com.how2java.tmall.util.page;
import com.how2java.tmall.util.uploadImagefile;
import com.sun.deploy.net.HttpResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("")
public class CategoryController {
    @Autowired
    CategoryService  categoryService;
    @RequestMapping("admin_category_list")
    public ModelAndView listCategory(page page){
        ModelAndView mav = new ModelAndView();
        PageHelper.offsetPage(page.getStart(),page.getCount());
        List<Category> cs = categoryService.list();
        int total = (int ) new PageInfo<>(cs).getTotal();
        page.setTotal(total);
        mav.addObject("cs",cs);
        mav.addObject("page" ,page);
        mav.setViewName("admin/listCategory");
       return  mav;
   }

    @RequestMapping("admin_category_add")

    public  String   add(Category category , uploadImagefile  uploadImagefile , HttpSession session)throws IOException {
        categoryService.add(category);
        File imageFolder = new File(session.getServletContext().getRealPath("img/category"));
        File file = new File(imageFolder,category.getId()+".jpg");
        if(! file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        uploadImagefile.getImage().transferTo(file);
        BufferedImage img = ImageUtil.change2jpg(file);
        ImageIO.write(img, "jpg", file);
        return "redirect:/admin_category_list";
    }

    @RequestMapping("admin_category_delete")

    public String delete(Category category , HttpSession session){
        categoryService.delete(category);
        File file = new File(session.getServletContext().getRealPath("img/category"),category.getId()+".jpg");
        if ( file.exists()){
            file .delete();
        }
        return "redirect:/admin_category_list";
    }
    @RequestMapping("admin_category_edit")
    public String edit( int id ,Model model){
       Category category = categoryService.get(id);
       model.addAttribute("c",category);
        return "admin/editCategory";
    }
    @RequestMapping("admin_category_update")
   public  String update( uploadImagefile imagefile , Category category , Model model,HttpSession httpSessio)throws  IOException{
        File file = new File(httpSessio.getServletContext().getRealPath("img/category"),category.getId()+".jpg");
        if( file.exists()){
            file.delete();
        }
        imagefile.getImage().transferTo(file);
        BufferedImage img = ImageUtil.change2jpg(file);
        ImageIO.write(img, "jpg", file);
        categoryService.update(category);
        return  "redirect:/admin_category_list";

    }
}
