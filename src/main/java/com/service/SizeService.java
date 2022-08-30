package com.service;

import com.DTO.SizeDTO;

import java.util.List;

public interface SizeService {
    List<SizeDTO> findAll();
    SizeDTO findById(Integer id);
    void create(SizeDTO SizeDto);
    void update(SizeDTO SizeDto);
    void remove(Integer id);
}
