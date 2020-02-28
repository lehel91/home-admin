package hu.lmsystems.homeadmin.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.lmsystems.homeadmin.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findByName(String name);
}
