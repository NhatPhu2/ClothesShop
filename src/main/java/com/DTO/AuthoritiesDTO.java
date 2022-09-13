package com.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class AuthoritiesDTO implements Serializable {
    private String fullname;
    private String email;
    private String photo;
    private String phoneNumber;
}
