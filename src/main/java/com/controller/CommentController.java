package com.controller;

import com.DTO.CommentDTO;
import com.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1")
@CrossOrigin("*")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("user/comments")
    public CommentDTO addComment(@RequestBody CommentDTO commentDTO){
        commentDTO.setCommentDate(new Date());
       return  commentService.create(commentDTO);
    }

    @GetMapping("user/comments")
    public List<CommentDTO> showComment(@RequestParam Integer idProduct){
        return commentService.findAllByIdProduct(idProduct);
    }

    @DeleteMapping("user/comments/{id}")
    public void deleteComment(@PathVariable Integer id){
        commentService.remove(id);
    }

    @PutMapping("user/comments")
    public CommentDTO updateComment(){
        return null;
    }
}
