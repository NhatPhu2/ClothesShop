package com.service;

import com.DTO.RoleDto;

import java.util.List;

public interface RoleService {
    List<RoleDto> findAll();
    RoleDto findById(Integer id);
    void create(RoleDto RoleDto);
    void update(RoleDto RoleDto);
    void remove(Integer id);
}
