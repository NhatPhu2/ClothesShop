package com.DAO;

import com.entity.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeDAO extends JpaRepository<Size,Integer> {
}
