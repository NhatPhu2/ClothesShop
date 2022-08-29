package com.service;

import com.DTO.FavoriteDto;

import java.util.List;

public interface FavoriteService {
    List<FavoriteDto> findAll();
    FavoriteDto findById(Integer id);
    void create(FavoriteDto FavoriteDto);
    void update(FavoriteDto FavoriteDto);
    void remove(Integer id);
}
