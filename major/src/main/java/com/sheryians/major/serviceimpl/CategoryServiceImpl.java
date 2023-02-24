package com.sheryians.major.serviceimpl;

import com.sheryians.major.model.Category;
import com.sheryians.major.repositories.CategoryRepo;
import com.sheryians.major.service.CategoryService;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    @Override
    public void addCategory(Category category) {
        categoryRepo.save(category);
    }

    @Override
    public void removeCategoryById(Integer categoryId) {
        categoryRepo.deleteById(categoryId);
    }

    @Override
    public Optional<Category> getCategoryById(Integer categoryId) {
        return categoryRepo.findById(categoryId);
    }


}
