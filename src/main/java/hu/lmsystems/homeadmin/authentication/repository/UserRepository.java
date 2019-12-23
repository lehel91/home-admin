package hu.lmsystems.homeadmin.authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.lmsystems.homeadmin.authentication.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}