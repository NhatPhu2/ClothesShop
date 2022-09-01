package com.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class RoleDTO implements Serializable {
    private String idRole;
    private String nameRole;
}
