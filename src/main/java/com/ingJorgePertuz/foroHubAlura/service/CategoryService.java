package com.ingJorgePertuz.foroHubAlura.service;

import com.ingJorgePertuz.foroHubAlura.model.Category;
import com.ingJorgePertuz.foroHubAlura.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Optional<Category> updateCategory(Long id, Category category) {
        return categoryRepository.findById(id).map(existingCategory -> {
            existingCategory.setCategoryName(category.getCategoryName());
            existingCategory.setDescription(category.getDescription());
            return categoryRepository.save(existingCategory);
        });
    }

    public boolean deleteCategory(Long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
