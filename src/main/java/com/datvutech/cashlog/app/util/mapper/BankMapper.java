package com.datvutech.cashlog.app.util.mapper;

import org.springframework.stereotype.Component;

import com.datvutech.cashlog.data.entity.Bank;
import com.datvutech.cashlog.logic.dto.BankDto;

@Component
public class BankMapper extends AbstractMapper {

    public BankDto bankEntityToDto(Bank bankEntity) {
        BankDto bankDto = mapper.map(bankEntity, BankDto.class);
        return bankDto;
    }
}
