package com.example.demo.Service;

<<<<<<< HEAD
import com.example.demo.Handler.ResourceNotFoundException;
=======
import com.example.demo.Exception.ResourceNotFoundException;
>>>>>>> 1957c4b6ff9e5403bcb8d45ec6c576c1065d3e5b
import com.example.demo.Model.Category;
import com.example.demo.Repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    // Constructor injection
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // CREATE
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    // READ ALL
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // READ BY ID
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
    }

    // UPDATE
    public Category updateCategory(Category category) {

        Category existingCategory = categoryRepository.findById(category.getId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Category not found with id: " + category.getId()));

        existingCategory.setName(category.getName());
        existingCategory.setActive(category.isActive());
        existingCategory.setParent(category.getParent());

        return categoryRepository.save(existingCategory);
    }


    // DELETE
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
