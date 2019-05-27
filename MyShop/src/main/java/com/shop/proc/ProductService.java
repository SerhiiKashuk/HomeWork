package com.shop.proc;

import java.util.List;

public interface ProductService {
	public Product findById(int id);
	public void save(Product product);
	public void remove(int id);
	public void update(int id, char vieved);
	public List<Product> findAll();
}
