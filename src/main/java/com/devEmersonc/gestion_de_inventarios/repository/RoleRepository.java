package com.devEmersonc.gestion_de_inventarios.repository;

import com.devEmersonc.gestion_de_inventarios.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    List<Role> findByName(String name);
}
