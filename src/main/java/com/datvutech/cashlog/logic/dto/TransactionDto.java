package com.datvutech.cashlog.logic.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.datvutech.cashlog.data.entity.type.TransactionType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class TransactionDto {
    private Integer transId;

    private String code;

    private TransactionType transType;

    private BigDecimal amount;

    private LocalDateTime date;

    private String detail;

    /* Begin: References */
    private UserDto userDto;
    private BankDto bankDto;
    /* End: References */

    /* Begin: Bussiness */
    private String collected = "0";
    private String paid = "0";
    private String datetime = "";
    private Long bankId;
    private Long userId;
    // private String userCode = "";
    // private String bankCode = "";
    /* End: Bussiness */
}
