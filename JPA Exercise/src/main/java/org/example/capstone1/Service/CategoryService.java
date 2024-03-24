package org.example.capstone1.Service;

import lombok.RequiredArgsConstructor;
import org.example.capstone1.Model.Category;
import org.example.capstone1.Repository.CategoryRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categories;

    public List<Category> getCategories() {
        return categories.findAll();
    }

    public void addCategory(Category category) {
        categories.save(category);
    }

    public Boolean updateCategory(Integer id, Category category) {
        Category c=categories.getById(id);
        if (c==null){
            return false;
        }
        c.setName(category.getName());
        categories.save(c);
        return true;
    }

    public boolean deleteCategory(Integer id) {
        Category c=categories.getById(id);
        if (c==null){
            return false;
        }
        categories.delete(c);
        return true;
    }
}