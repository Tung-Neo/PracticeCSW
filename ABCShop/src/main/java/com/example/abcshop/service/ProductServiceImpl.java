package com.example.abcshop.service;

import com.example.abcshop.dao.ProductRepository;
import com.example.abcshop.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	public ProductServiceImpl(ProductRepository theProductRepository) {
		productRepository = theProductRepository;
	}

	@Override
	@Transactional
	public List<Product> getProducts() {
		return productRepository.findAll();
	}

    @Override
    @Transactional
    public void saveProduct(Product theProduct) {
        productRepository.save(theProduct);
    }

	@Override
	@Transactional
	public Product getProduct(int theId) {
		return productRepository.getById(theId);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		productRepository.deleteById(theId);
	}

}
