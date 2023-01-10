package com.datvutech.cashlog.logic.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datvutech.cashlog.app.util.mapper.TransactionMapper;
import com.datvutech.cashlog.data.entity.Bank;
import com.datvutech.cashlog.data.entity.Transaction;
import com.datvutech.cashlog.data.entity.User;
import com.datvutech.cashlog.data.pagination.PageRequest;
import com.datvutech.cashlog.data.pagination.PageResponse;
import com.datvutech.cashlog.data.pagination.Pageable;
import com.datvutech.cashlog.data.repository.TransactionRepository;
import com.datvutech.cashlog.data.sort.Sorter;
import com.datvutech.cashlog.logic.dto.TransactionDto;
import com.datvutech.cashlog.logic.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionMapper transMapper;

    @Autowired
    private TransactionRepository transRepo;

    @Override
    public void createTransaction(TransactionDto transDto) {
        /* Begin: References */
        Bank bank = new Bank(transDto.getBankId());
        User user = new User(transDto.getUserId());
        /* End: References */

        Transaction trans = transMapper.transDtoToEntity(transDto);
        trans.setUser(user);
        trans.setBank(bank);
        trans.setDate(LocalDateTime.now());
        transRepo.insert(trans);
    }

    @Override
    public PageResponse<TransactionDto> getTransactionPage(int page, int max, Sorter sorter) {
        Pageable pageRequest = PageRequest.of(page, max, sorter);
        PageResponse<Transaction> pageResponse = transRepo.findAll(pageRequest);
        PageResponse<TransactionDto> pageDtoResponse = new PageResponse<>();
        List<TransactionDto> transDtos = new ArrayList<>();
        pageResponse.getResult().forEach(t -> {
            TransactionDto transDto = transMapper.transEntityToDto(t);
            transDtos.add(transDto);
        });
        pageDtoResponse.setCount(pageResponse.getCount());
        pageDtoResponse.setResult(transDtos);
        return pageDtoResponse;
    }

    @Override
    public long getNumberOfTransactions() {
        return transRepo.countAll();
    }

}
