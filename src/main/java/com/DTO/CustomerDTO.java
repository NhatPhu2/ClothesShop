package com.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class CustomerDTO implements Serializable {
    private Integer id;
    private String fullname;
    private String email;
    private String photo;
    private String phoneNumber;
}
