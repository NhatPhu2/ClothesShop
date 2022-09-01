package com.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class CustomerDTO implements Serializable {
    private Integer idCustomer;
    private String fullname;
    private String email;
    private String photo;
    private String phoneNumber;
}
