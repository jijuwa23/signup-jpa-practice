package com.example.pogobank.repository;

import com.example.pogobank.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Query(value = "SELECT * FROM USERS u where u.status = 'ACTIVE'", nativeQuery = true)
    List<UserEntity> getActiveAccounts();
}
