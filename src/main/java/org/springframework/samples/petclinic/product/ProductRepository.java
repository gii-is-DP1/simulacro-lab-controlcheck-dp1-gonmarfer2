package org.springframework.samples.petclinic.product;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;



public interface ProductRepository extends CrudRepository<Product, Integer> {
    List<Product> findAll();
	
    @Query("SELECT pt FROM ProductType pt")
	List<ProductType> findAllProductTypes();
    
//    Optional<Product> findById(int id);
    Product findByName(String name);
//    Product save(Product p);
    
    @Query("SELECT pt FROM ProductType pt WHERE pt.name = ?1")
    ProductType findProductTypeByName(String name);
    
    List<Product> findByPriceLessThan(Double price);
}
