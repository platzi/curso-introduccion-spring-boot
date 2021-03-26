package com.platzi.springboot.repository;

import com.platzi.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.email=?1")
    Optional<User> findMyUserByEmail(String email);

//    List<User> findByNameOrderById(String name);

    List<User> findByNameContaining(String name);

    List<User> findByNameLike(String name);
}
