package com.DTO;

import com.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class CommentDTO implements Serializable {
    private Integer id;
    private String description;
    private Comment commentProduct;
    private Comment commentCustomer;
}
