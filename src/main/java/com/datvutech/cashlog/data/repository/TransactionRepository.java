package com.datvutech.cashlog.data.repository;

import java.util.List;

import com.datvutech.cashlog.data.entity.Transaction;
import com.datvutech.cashlog.data.repository.generic.PagebleRepository;

public interface TransactionRepository
                extends PagebleRepository<Transaction> {
        Transaction findByTransactionId(int transId);

        List<Transaction> findByUserId(int userId);
}
