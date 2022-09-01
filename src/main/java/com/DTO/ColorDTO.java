package com.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ColorDTO implements Serializable {
    private Integer idColor;
    private String nameColor;
}
