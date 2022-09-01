package com.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class SizeDTO implements Serializable {
    private Integer idSize;
    private String nameSize;
}
