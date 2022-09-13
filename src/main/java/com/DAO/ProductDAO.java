package com.DAO;

import com.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDAO extends JpaRepository<Product,Integer> {
    @Query("select o from Product o where o.category.idCategory=?1")
    List<Product> findAllByIdCategory(Integer idCategory);

    @Query("select o from Product o where  o.productStyle.idProductStyle=?1 and o.category.idCategory=?2")
    List<Product> findAllProductByStyle(Integer idStyle, Integer idCategory);
}
