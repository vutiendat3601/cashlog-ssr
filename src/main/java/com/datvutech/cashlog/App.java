package com.datvutech.cashlog;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.datvutech.cashlog.app.config.RootConfig;
import com.datvutech.cashlog.data.repository.BankRepository;
import com.datvutech.cashlog.data.repository.TransactionRepository;
import com.datvutech.cashlog.data.repository.UserRepository;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(RootConfig.class);
        UserRepository userRepo = app.getBean(UserRepository.class);
        BankRepository bankRepo = app.getBean(BankRepository.class);
        TransactionRepository transRepo = app.getBean(TransactionRepository.class);

        DummyData.createBank(bankRepo);
        DummyData.createUser(userRepo);
        DummyData.createTransaction(transRepo);

        app.close();
    }
}
