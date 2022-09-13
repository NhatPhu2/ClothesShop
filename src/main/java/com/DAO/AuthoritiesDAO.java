package com.DAO;

import com.entity.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthoritiesDAO extends JpaRepository<Authorities,Integer> {
}
