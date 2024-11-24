package com.devEmersonc.gestion_de_inventarios.repository;

import com.devEmersonc.gestion_de_inventarios.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
