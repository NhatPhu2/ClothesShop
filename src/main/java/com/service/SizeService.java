package com.service;

import com.DTO.SizeDto;

import java.util.List;

public interface SizeService {
    List<SizeDto> findAll();
    SizeDto findById(Integer id);
    void create(SizeDto SizeDto);
    void update(SizeDto SizeDto);
    void remove(Integer id);
}
