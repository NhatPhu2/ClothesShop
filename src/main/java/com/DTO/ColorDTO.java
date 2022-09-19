package com.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class ColorDTO implements Serializable {
    private Integer idColor;
    @NotEmpty(message = "${Color.ColorDTO.nameColor}")
    private String nameColor;
}
