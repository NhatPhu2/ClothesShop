package com.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public class RoleDto implements Serializable {
    private final String id;
    private final String name;
}
