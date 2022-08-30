package com.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public class CustomerDTO implements Serializable {
    private final Integer id;
    private final String fullname;
    private final String email;
    private final String photo;
    private final String phoneNumber;
}
