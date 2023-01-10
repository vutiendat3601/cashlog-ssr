package com.datvutech.cashlog.logic.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datvutech.cashlog.app.util.mapper.BankMapper;
import com.datvutech.cashlog.data.entity.Bank;
import com.datvutech.cashlog.data.repository.BankRepository;
import com.datvutech.cashlog.logic.dto.BankDto;
import com.datvutech.cashlog.logic.service.BankService;

@Service
public class BankServiceImpl implements BankService {
    @Autowired
    private BankMapper bankMapper;

    @Autowired
    private BankRepository bankRepo;

    @Override
    public List<BankDto> getBanks() {
        List<Bank> banks = bankRepo.findAll();
        List<BankDto> bankDtos = new ArrayList<>();
        banks.forEach(b -> {
            BankDto bankDto = bankMapper.bankEntityToDto(b);
            bankDtos.add(bankDto);
        });
        return bankDtos;
    }

}
