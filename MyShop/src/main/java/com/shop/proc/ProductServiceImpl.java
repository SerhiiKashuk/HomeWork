package com.shop.proc;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;


@Named
public class ProductServiceImpl implements ProductService {
	 @Inject
   private ProductDao productDao;
	public Product findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(Product product) {
		// TODO Auto-generated method stub
		productDao.save(product);
	}

	public void remove(int id) {
		// TODO Auto-generated method stub
		
	}

	public void update(int id, char vieved) {
		// TODO Auto-generated method stub
		
	}

	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productDao.findAll();
	}


}
