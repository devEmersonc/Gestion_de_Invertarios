package com.devEmersonc.gestion_de_inventarios.controller;

import com.devEmersonc.gestion_de_inventarios.dto.CategoryDTO;
import com.devEmersonc.gestion_de_inventarios.dto.SaveCategoryDTO;
import com.devEmersonc.gestion_de_inventarios.service.categoryService.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getCategories() {
        List<CategoryDTO> categories = categoryService.getCategories();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategory(@PathVariable Long id) {
        CategoryDTO category = categoryService.getCategory(id);
        return ResponseEntity.ok(category);
    }

    @PostMapping
    public ResponseEntity<String> saveCategory(@Valid @RequestBody SaveCategoryDTO saveCategoryDTO) {
        categoryService.saveCategory(saveCategoryDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Categoría guardada con éxito.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCategory(@Valid @RequestBody SaveCategoryDTO saveCategoryDTO, @PathVariable Long id) {
        categoryService.updateCategory(id, saveCategoryDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Categoria actualizada.");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok("Categoria eliminada con éxito.");
    }
}
