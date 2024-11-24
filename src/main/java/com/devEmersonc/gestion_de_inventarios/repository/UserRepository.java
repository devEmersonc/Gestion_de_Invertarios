package com.devEmersonc.gestion_de_inventarios.repository;

import com.devEmersonc.gestion_de_inventarios.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
