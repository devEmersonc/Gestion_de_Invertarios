package com.devEmersonc.gestion_de_inventarios.controller;

import com.devEmersonc.gestion_de_inventarios.dto.ProductDTO;
import com.devEmersonc.gestion_de_inventarios.dto.SaveProductDTO;
import com.devEmersonc.gestion_de_inventarios.service.productService.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getProducts() {
        List<ProductDTO> products = productService.getProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable Long id) {
        ProductDTO product = productService.getProduct(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<String> saveProduct(@Valid @RequestBody SaveProductDTO saveProductDTO) {
        productService.saveProduct(saveProductDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Producto guardado con éxito");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@Valid @RequestBody SaveProductDTO saveProductDTO, @PathVariable Long id) {
        productService.updateProduct(id, saveProductDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Producto actualizado con éxito.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Producto eliminado con éxito.");
    }
}
