package com.sheryians.major.service;

import com.sheryians.major.model.Category;
import jdk.nashorn.internal.runtime.options.Option;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> getAllCategories();
    void addCategory(Category category);

    void  removeCategoryById(Integer categoryId);
     Optional<Category> getCategoryById(Integer categoryId);

}
