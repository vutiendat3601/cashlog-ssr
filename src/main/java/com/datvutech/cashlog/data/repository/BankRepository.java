package com.datvutech.cashlog.data.repository;

import com.datvutech.cashlog.data.entity.Bank;
import com.datvutech.cashlog.data.repository.generic.GenericRepository;

public interface BankRepository extends GenericRepository<Bank> {

    Bank findByBankId(int bankId);

    Bank findByCode(String code);
}
