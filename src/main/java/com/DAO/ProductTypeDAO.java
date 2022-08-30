package com.DAO;

import com.entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeDAO extends JpaRepository<ProductType,Integer> {
}
