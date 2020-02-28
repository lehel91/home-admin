package hu.lmsystems.homeadmin.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.lmsystems.homeadmin.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByUserName(String userName);
}
