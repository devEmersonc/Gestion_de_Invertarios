package com.devEmersonc.gestion_de_inventarios.service.categoryService;

import com.devEmersonc.gestion_de_inventarios.dto.CategoryDTO;
import com.devEmersonc.gestion_de_inventarios.dto.SaveCategoryDTO;
import com.devEmersonc.gestion_de_inventarios.model.Category;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> getCategories();
    CategoryDTO getCategory(Long id);
    void saveCategory(SaveCategoryDTO saveCategoryDTO);
    void updateCategory(Long id, SaveCategoryDTO saveCategoryDTO);
    void deleteCategory(Long id);
    CategoryDTO convertEntityToDto(Category category);
}
