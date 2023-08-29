package com.groupeisi.repository;

import com.groupeisi.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmailIgnoreCase(String email);
}
