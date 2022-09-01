package com.DTO;

import com.entity.Comment;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class CommentDTO implements Serializable {
    private Integer idComment;
    private String description;
    private Comment commentProduct;
    private Comment commentCustomer;
}
