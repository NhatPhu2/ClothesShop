package com.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class SizeDTO implements Serializable {
    private Integer idSize;

    @NotEmpty(message = "${Size.RoleDTO.nameRole}")
    private String nameSize;
}
