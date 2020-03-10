package hu.lmsystems.homeadmin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.lmsystems.homeadmin.dao.ProductRepository;
import hu.lmsystems.homeadmin.model.Product;

@Transactional
@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<String> search(String keyword) {
		return productRepository.search(keyword);
	}

	@Override
	public Product save(Product product) {
		return productRepository.saveAndFlush(product);
	}

}
