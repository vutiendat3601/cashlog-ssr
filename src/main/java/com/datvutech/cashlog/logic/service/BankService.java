package com.datvutech.cashlog.logic.service;

import java.util.List;

import com.datvutech.cashlog.logic.dto.BankDto;

public interface BankService {
    List<BankDto> getBanks();
}
