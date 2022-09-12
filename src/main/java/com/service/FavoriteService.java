package com.service;

import com.DTO.FavoriteDTO;
import com.entity.Favorite;

import java.util.List;

public interface FavoriteService {
    List<FavoriteDTO> findAll();
    FavoriteDTO findById(Integer id);
    void create(FavoriteDTO FavoriteDto);
    void update(FavoriteDTO FavoriteDto);
    void remove(Integer id);
    Favorite checkInDB(int idCustomer, int idProduct);
}
