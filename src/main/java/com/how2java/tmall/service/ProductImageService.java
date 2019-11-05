package com.how2java.tmall.service;

import com.how2java.tmall.pojo.ProductImage;
import java.util.List;

public interface  ProductImageService {

  public   String type_single = "type_single";
    public  String type_detail = "type_detail";
    public  void add(ProductImage productImage);

    public  void delete(int id);

    public  void update( ProductImage productImage);

    public List<ProductImage> lists ( int id ,String type);

    public  ProductImage get( int id);


}
