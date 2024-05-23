package com.example.demo.repo;

import com.example.demo.model.Users;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface UsersRepo extends JpaRepository<Users, Long> {
    Optional<Users> findByUsername(String username);
    Optional<Users> findById(Long id);

    @Modifying
    @Transactional
    @Query("update Users u set u.role = :role where u.id = :id")
    int updateUserRole(@Param("role") String role, @Param("id") Long id);
}
