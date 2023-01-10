package com.datvutech.cashlog.logic.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private Integer userId;

    private String username;

    private String fullName;

    private String code;

    private String email;

    private String password;

    private String phone;

    private String role;
}
