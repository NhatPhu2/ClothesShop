package com.DAO;

import com.entity.ProductColors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductColorsDAO extends JpaRepository<ProductColors,Integer> {
    @Query("select  o from ProductColors o where o.colorProduct.idColor=:idColor and o.product.idProduct=:idProduct")
    ProductColors findByIdColorAndIdProduct(Integer idColor, Integer idProduct);
}
