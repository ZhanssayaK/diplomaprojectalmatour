package com.example.diploma.project.almatour.service;

import com.example.diploma.project.almatour.model.Category;
import com.example.diploma.project.almatour.model.City;
import com.example.diploma.project.almatour.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> getCategoryList() {
        return categoryRepository.findAll();
    }
}
