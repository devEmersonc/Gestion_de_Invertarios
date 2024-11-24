package com.devEmersonc.gestion_de_inventarios.service.serviceImpl.productServiceImpl;

import com.devEmersonc.gestion_de_inventarios.dto.ProductDTO;
import com.devEmersonc.gestion_de_inventarios.dto.SaveProductDTO;
import com.devEmersonc.gestion_de_inventarios.exception.ProductNotFoundException;
import com.devEmersonc.gestion_de_inventarios.model.Product;
import com.devEmersonc.gestion_de_inventarios.model.User;
import com.devEmersonc.gestion_de_inventarios.repository.ProductRepository;
import com.devEmersonc.gestion_de_inventarios.service.SecurityService;
import com.devEmersonc.gestion_de_inventarios.service.productService.ProductService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final SecurityService securityService;

    public ProductServiceImpl(ProductRepository productRepository, SecurityService securityService) {
        this.productRepository = productRepository;
        this.securityService = securityService;
    }

    @Override
    public List<ProductDTO> getProducts() {
        return productRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO getProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException());
        return this.convertEntityToDto(product);
    }

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void saveProduct(SaveProductDTO saveProductDTO) {
        Product product = new Product();
        product.setName(saveProductDTO.getName());
        product.setDescription(saveProductDTO.getDescription());
        product.setPrice(saveProductDTO.getPrice());
        product.setStock(saveProductDTO.getStock());
        product.setCategory(saveProductDTO.getCategory());
        product.setSupplier(saveProductDTO.getSupplier());

        User user = securityService.getAuthenticatedUser();
        product.setUser(user);

        productRepository.save(product);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    public void updateProduct(Long id, SaveProductDTO saveProductDTO) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException());
        product.setName(saveProductDTO.getName());
        product.setDescription(saveProductDTO.getDescription());
        product.setPrice(saveProductDTO.getPrice());
        product.setStock(saveProductDTO.getStock());
        product.setCategory(saveProductDTO.getCategory());
        product.setSupplier(saveProductDTO.getSupplier());
        productRepository.save(product);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException());
        productRepository.deleteById(product.getId());
    }

    @Override
    public ProductDTO convertEntityToDto(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());
        productDTO.setStock(product.getStock());
        return productDTO;
    }
}
