package com.how2java.tmall.service;

import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.util.page;

import java.util.List;

public interface CategoryService {

    List<Category> list();
    void add(Category category);
    void delete( Category category);
    Category get(int id );
    void update(Category category);

}
