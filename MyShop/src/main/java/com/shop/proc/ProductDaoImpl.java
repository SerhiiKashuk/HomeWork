package com.shop.proc;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;




@Repository
public class ProductDaoImpl implements ProductDao {
	@PersistenceContext
	private EntityManager em;
	public Product findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(Product product) {
		// TODO Auto-generated method stub
		Product prod = em.find(Product.class, product);
  	if (prod != null){
  		em.remove(prod);
  	}
		
	}

	public void remove(int id) {
		// TODO Auto-generated method stub
		
	}

	public void update(int id, char vieved) {
		// TODO Auto-generated method stub
		
	}

	public List<Product> findAll() {
		TypedQuery<Product> query = em.createQuery("SELECT * FROM product",  Product.class);
    List<Product> listM = query.getResultList();
    return listM;
	}

}
