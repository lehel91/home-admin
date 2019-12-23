package hu.lmsystems.homeadmin.authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.lmsystems.homeadmin.authentication.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
