package com.service;

import com.DTO.CommentDto;

import java.util.List;

public interface CommentService {
    List<CommentDto> findAll();
    CommentDto findById(Integer id);
    void create(CommentDto CommentDto);
    void update(CommentDto CommentDto);
    void remove(Integer id);
}
