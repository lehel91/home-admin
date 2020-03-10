package hu.lmsystems.homeadmin.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hu.lmsystems.homeadmin.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findByName(String name);
	
	List<Product> findAll();
	
	@SuppressWarnings("unchecked")
	Product saveAndFlush(Product product);
	
	@Query(value = "SELECT name FROM products where name like %:keyword%", nativeQuery = true)
	List<String> search(@Param("keyword") String keyword);
}
