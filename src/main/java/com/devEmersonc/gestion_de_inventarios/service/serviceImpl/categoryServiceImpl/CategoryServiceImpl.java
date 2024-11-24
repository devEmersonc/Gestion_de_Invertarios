package com.devEmersonc.gestion_de_inventarios.service.serviceImpl.categoryServiceImpl;

import com.devEmersonc.gestion_de_inventarios.dto.CategoryDTO;
import com.devEmersonc.gestion_de_inventarios.dto.SaveCategoryDTO;
import com.devEmersonc.gestion_de_inventarios.exception.CategoryNotFoundException;
import com.devEmersonc.gestion_de_inventarios.model.Category;
import com.devEmersonc.gestion_de_inventarios.model.User;
import com.devEmersonc.gestion_de_inventarios.repository.CategoryRepository;
import com.devEmersonc.gestion_de_inventarios.service.SecurityService;
import com.devEmersonc.gestion_de_inventarios.service.categoryService.CategoryService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final SecurityService securityService;

    public CategoryServiceImpl(CategoryRepository categoryRepository, SecurityService securityService) {
        this.categoryRepository = categoryRepository;
        this.securityService = securityService;
    }
    @Override
    public List<CategoryDTO> getCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO getCategory(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException());
        return this.convertEntityToDto(category);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    public void saveCategory(SaveCategoryDTO saveCategoryDTO) {
        Category category = new Category();
        category.setName(saveCategoryDTO.getName());
        categoryRepository.save(category);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    public void updateCategory(Long id, SaveCategoryDTO saveCategoryDTO) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException());
        category.setName(saveCategoryDTO.getName());
        categoryRepository.save(category);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    public void deleteCategory(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException());
        categoryRepository.deleteById(category.getId());
    }

    @Override
    public CategoryDTO convertEntityToDto(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setName(category.getName());
        return categoryDTO;
    }
}
