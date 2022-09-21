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

    @PostMapping("/comments")
    public CommentDTO addComment(@RequestBody CommentDTO commentDTO){
        commentDTO.setCommentDate(new Date());
       return  commentService.create(commentDTO);
    }

    @GetMapping("/comments")
    public List<CommentDTO> showComment(@RequestParam Integer idProduct){
        return commentService.findAllByIdProduct(idProduct);
    }

    @DeleteMapping("/comments/{id}")
    public void deleteComment(@PathVariable Integer id){
        commentService.remove(id);
    }

    @PutMapping("/comments")
    public CommentDTO updateComment(){
        return null;
    }
}
