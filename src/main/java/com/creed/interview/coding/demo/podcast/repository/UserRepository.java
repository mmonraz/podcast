package com.creed.interview.coding.demo.podcast.repository;

import com.creed.interview.coding.demo.podcast.model.security.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    //Get the user by userName from the database
    Optional<User> findByUserName(String userName);
}
