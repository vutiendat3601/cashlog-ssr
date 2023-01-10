package com.datvutech.cashlog.logic.service;

import com.datvutech.cashlog.data.pagination.PageResponse;
import com.datvutech.cashlog.data.sort.Sorter;
import com.datvutech.cashlog.logic.dto.TransactionDto;

public interface TransactionService {
    void createTransaction(TransactionDto transDto);

    PageResponse<TransactionDto> getTransactionPage(int page, int max, Sorter sorter);

    long getNumberOfTransactions();
}
