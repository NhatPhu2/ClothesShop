package com.DTO;

import com.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public class CommentDto implements Serializable {
    private final Integer id;
    private final String description;
    private final Comment commentProduct;
    private final Comment commentCustomer;
}
