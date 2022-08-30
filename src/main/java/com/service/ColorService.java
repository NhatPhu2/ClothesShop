package com.service;

import com.DTO.ColorDTO;

import java.util.List;

public interface ColorService {
    List<ColorDTO> findAll();
    ColorDTO findById(Integer id);
    void create(ColorDTO ColorDto);
    void update(ColorDTO ColorDto);
    void remove(Integer id);
}
