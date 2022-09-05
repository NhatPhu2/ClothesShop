package com.DAO;

import com.entity.ProductSizes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSizesDAO extends JpaRepository<ProductSizes,Integer> {
}
