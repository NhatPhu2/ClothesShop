package com.serviceImpl;

import com.DAO.CommentDAO;
import com.DTO.CommentDTO;
import com.entity.Comment;
import com.service.CommentService;
import com.utils.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentDAO commentDAO;

    @Autowired
    Convert convert;
    @Override
    public List<CommentDTO> findAll() {

        return null;
    }

    @Override
    public CommentDTO findById(Integer id) {
        return null;
    }

    @Override @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public CommentDTO create(CommentDTO CommentDto) {
        return null;
    }

    @Override @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public void update(CommentDTO CommentDto) {

    }

    @Override @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public void remove(Integer id) {

    }

    @Override
    public List<CommentDTO> findAllByIdProduct(Integer id) {
        List<Comment> comments = commentDAO.findAllByIdProduct(id);
        List<CommentDTO> commentDTOS = comments.stream()
                .map(commentEntity -> convert.toDto(commentEntity,CommentDTO.class))
                .collect(Collectors.toList());
        return commentDTOS;
    }
}
