package com.devEmersonc.gestion_de_inventarios.service.productService;

import com.devEmersonc.gestion_de_inventarios.dto.ProductDTO;
import com.devEmersonc.gestion_de_inventarios.dto.SaveProductDTO;
import com.devEmersonc.gestion_de_inventarios.model.Product;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getProducts();
    ProductDTO getProduct(Long id);
    void saveProduct(SaveProductDTO saveProductDTO);
    void updateProduct(Long id, SaveProductDTO saveProductDTO);
    void deleteProduct(Long id);
    ProductDTO convertEntityToDto(Product product);
}
