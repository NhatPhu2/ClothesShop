package com.service;

import com.DTO.CommentDTO;

import java.util.List;

public interface CommentService {
    List<CommentDTO> findAll();
    CommentDTO findById(Integer id);
    void create(CommentDTO CommentDto);
    void update(CommentDTO CommentDto);
    void remove(Integer id);
}
