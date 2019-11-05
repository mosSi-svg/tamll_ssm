package com.how2java.tmall.controller;

import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.pojo.ProductImage;
import com.how2java.tmall.service.ProductImageService;
import com.how2java.tmall.service.ProductService;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import com.how2java.tmall.util.ImageUtil;
import com.how2java.tmall.util.uploadImagefile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("")
public class productImageController {

    @Autowired
    ProductImageService productImageService;
    @Autowired
    ProductService productService;
    @RequestMapping("admin_productImage_list")
    public  String list( int pid ,Model model  ){
        Product p =  productService.get(pid);
        List<ProductImage>  pisSingle=productImageService.lists( pid,productImageService.type_single) ;
        List<ProductImage> pisDetail =productImageService.lists(pid,productImageService.type_detail);
        model.addAttribute("product",p);
        model.addAttribute("pisSingle",pisSingle);
        model.addAttribute("pisDetail",pisDetail);
        return "admin/listProductImage";
    }
    @RequestMapping("admin_productImage_add")
    public  String add(Model model , uploadImagefile image, ProductImage productImage , HttpSession session){
        productImageService.add(productImage);
        String fileName=productImage.getId()+".jpg";
        String imageFolder;
        String imageFolder_small=null;
        String imageFolder_middle=null;
        if( productImageService.type_single.equals(productImage.getType())){
            imageFolder = session.getServletContext().getRealPath("img/productSingle");
            imageFolder_small =session.getServletContext().getRealPath("img/productSingle_small");
            imageFolder_middle = session.getServletContext().getRealPath("img/productSingle_middle");
        }
        else{
         imageFolder=session.getServletContext().getRealPath("img/productDetail");
        }
        File file =new File(imageFolder,fileName);
        file.getParentFile().mkdirs();
        try{
            image.getImage().transferTo(file);
            BufferedImage img = ImageUtil.change2jpg(file);
            ImageIO.write(img,"jpg",file);

            if(ProductImageService.type_single.equals(productImage.getType())) {
                File f_small = new File(imageFolder_small, fileName);
                File f_middle = new File(imageFolder_middle, fileName);

                ImageUtil.resizeImage(file, 56, 56, f_small);
                ImageUtil.resizeImage(file, 217, 190, f_middle);
            }
        }catch ( Exception r){
            r.printStackTrace();
        }
        return "redirect:admin_productImage_list?pid="+productImage.getPid();
    }
   @RequestMapping("admin_productImage_delete")

    public  String  delete( int id , HttpSession session){
        ProductImage productImage = productImageService.get(id);
        String imageFolder;
        if( productImage.getType().equals(productImageService.type_single)){
            imageFolder=session.getServletContext().getRealPath("img/productSingle");
            new File(imageFolder+"/"+productImage.getId()+".jpg").delete();
            new File(session.getServletContext().getRealPath("img/productSingle_small")+"/"+productImage.getId()+".jpg").delete();
            new File(session.getServletContext().getRealPath("img/productSingle_middle")+"/"+productImage.getId()+".jpg").delete();
        }
        else{
            imageFolder=session.getServletContext().getRealPath("img/productDetail");
            new File(imageFolder+"/"+productImage.getId()+".jpg").delete();
        }
      int pid=productImageService.get(id).getPid();
      productImageService.delete(id);
        return "redirect:admin_productImage_list?pid="+pid;
  }

}
