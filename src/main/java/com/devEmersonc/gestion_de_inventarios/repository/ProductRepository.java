package com.devEmersonc.gestion_de_inventarios.repository;

import com.devEmersonc.gestion_de_inventarios.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
