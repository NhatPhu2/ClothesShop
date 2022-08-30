package com.service;

import com.DTO.FavoriteDTO;

import java.util.List;

public interface FavoriteService {
    List<FavoriteDTO> findAll();
    FavoriteDTO findById(Integer id);
    void create(FavoriteDTO FavoriteDto);
    void update(FavoriteDTO FavoriteDto);
    void remove(Integer id);
}
