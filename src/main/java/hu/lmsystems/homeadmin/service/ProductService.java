package hu.lmsystems.homeadmin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.lmsystems.homeadmin.dao.ProductRepository;

public interface ProductService {
	
	public List<String> search(String keyword);

}
