package com.DAO;

import com.entity.Favorite;
import com.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteDAO extends JpaRepository<Favorite,Integer> {
	
//	@Query("select f  from  Favorite f where f.favoriteProduct = ?1 and f.favoriteCustomer = ?2")
//	Favorite findByCustomerAndProduct(Product p, Customer c);
}
