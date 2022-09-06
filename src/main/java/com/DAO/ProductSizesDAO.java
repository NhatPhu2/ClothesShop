package com.DAO;

import com.entity.ProductSizes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSizesDAO extends JpaRepository<ProductSizes,Integer> {
    @Query("select  o from ProductSizes  o where o.product.idProduct =?1 and o.sizeProduct.idSize=?2")
    ProductSizes findByIdProduct(Integer idProduct,Integer idSize);
}
