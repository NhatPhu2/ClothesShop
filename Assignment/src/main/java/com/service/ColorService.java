package com.service;

import com.DTO.ColorDto;

import java.util.List;

public interface ColorService {
    List<ColorDto> findAll();
    ColorDto findById(Integer id);
    void create(ColorDto ColorDto);
    void update(ColorDto ColorDto);
    void remove(Integer id);
}
