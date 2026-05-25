package com.example.demo.repositories;

import com.example.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByResourceId(UUID resourceId);

    default List<User> getAll() {
        return findAll();
    }

    default User getByResourceId(UUID resourceId) {
        return this.findByResourceId(resourceId).orElse(null);
    }
}
