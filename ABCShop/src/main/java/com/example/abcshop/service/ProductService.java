package com.example.abcshop.service;

import com.example.abcshop.entity.Product;

import java.util.List;

public interface ProductService {

	public List<Product> getProducts();

    public void saveProduct(Product theProduct);

	public Product getProduct(int theId);

	public void deleteById(int theId);

}
