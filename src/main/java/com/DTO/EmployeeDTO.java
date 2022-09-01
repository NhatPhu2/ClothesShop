package com.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class EmployeeDTO implements Serializable {
    private Integer idEmployee;
    private String fullname;
    private String email;
    private String photo;
    private String phoneNumber;
}
