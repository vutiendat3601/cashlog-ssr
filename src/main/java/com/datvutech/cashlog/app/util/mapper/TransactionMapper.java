package com.datvutech.cashlog.app.util.mapper;

import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.datvutech.cashlog.data.entity.Transaction;
import com.datvutech.cashlog.logic.dto.BankDto;
import com.datvutech.cashlog.logic.dto.TransactionDto;
import com.datvutech.cashlog.logic.dto.UserDto;

@Component
public class TransactionMapper extends AbstractMapper {

    @Autowired
    private DateTimeFormatter dateTimeFormatter;

    @Autowired
    private DecimalFormat decimalFormat;

    public TransactionDto transEntityToDto(Transaction transEntity) {
        TransactionDto transDto = mapper.map(transEntity, TransactionDto.class);
        transDto.setDatetime(dateTimeFormatter.format(transDto.getDate()));
        switch (transDto.getTransType()) {
            case COLLECTED:
                transDto.setCollected(decimalFormat.format(transDto.getAmount()));
                break;
            case PAID:
                transDto.setPaid(decimalFormat.format(transDto.getAmount()));
                break;
        }
        transDto.setBankDto(mapper.map(transEntity.getBank(), BankDto.class));
        transDto.setUserDto(mapper.map(transEntity.getUser(), UserDto.class));
        return transDto;
    }

    public Transaction transDtoToEntity(TransactionDto transDto) {
        Transaction trans = mapper.map(transDto, Transaction.class);
        return trans;
    }
}
