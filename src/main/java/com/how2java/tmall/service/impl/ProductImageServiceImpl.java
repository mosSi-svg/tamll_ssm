package com.how2java.tmall.service.impl;

import com.how2java.tmall.mapper.ProductImageMapper;
import com.how2java.tmall.pojo.ProductImage;
import com.how2java.tmall.pojo.ProductImageExample;
import com.how2java.tmall.service.ProductImageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductImageServiceImpl implements ProductImageService {
    @Autowired
    ProductImageMapper productImageMapper;
    @Override
    public ProductImage get(int id) {
        return productImageMapper.selectByPrimaryKey(id);
    }

    @Override
    public void delete(int id) {
        productImageMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<ProductImage> lists( int pid,String type) {
        ProductImageExample  productImageExample =new ProductImageExample();
        productImageExample.createCriteria().andPidEqualTo(pid).andTypeEqualTo(type);
        productImageExample.setOrderByClause("id desc");
        List<ProductImage> lists = productImageMapper.selectByExample(productImageExample);
        return lists;
    }

    @Override
    public void add(ProductImage productImage) {
    productImageMapper.insert(productImage);
    }

    @Override
    public void update(ProductImage productImage) {
    productImageMapper.updateByPrimaryKey(productImage);
    }
}
