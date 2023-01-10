package com.datvutech.cashlog.logic.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class BankDto {
    private Integer bankId;

    private String name;

    private String code;

    private String description;

    /* Begin: References */
    /* End: References */
}
