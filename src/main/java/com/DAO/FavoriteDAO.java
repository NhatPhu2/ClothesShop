package com.DAO;

import com.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteDAO extends JpaRepository<Favorite,Integer> {
}
