package com.DAO;

import com.entity.ProductColors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductColorsDAO extends JpaRepository<ProductColors,Integer> {
}
