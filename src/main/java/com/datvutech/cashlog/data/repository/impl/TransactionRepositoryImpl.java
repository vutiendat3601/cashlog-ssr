package com.datvutech.cashlog.data.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.datvutech.cashlog.data.entity.Transaction;
import com.datvutech.cashlog.data.repository.TransactionRepository;
import com.datvutech.cashlog.data.repository.generic.impl.PageableRepositoryImpl;

@Repository
public class TransactionRepositoryImpl
                extends PageableRepositoryImpl<Transaction>
                implements TransactionRepository {

        public TransactionRepositoryImpl() {
                super(Transaction.class);
        }

        @Override
        public Transaction findByTransactionId(int transId) {
                Session session = sessionFactory.getCurrentSession();
                Transaction trans = session.find(Transaction.class, transId);
                return trans;
        }

        @Override
        public List<Transaction> findByUserId(int userId) {
                Session session = sessionFactory.getCurrentSession();
                String sql = "FROM Transaction " +
                                "WHERE user.userId = :userId";
                List<Transaction> transactions = session.createQuery(sql, Transaction.class)
                                .setParameter("userId", userId)
                                .getResultList();
                return transactions;
        }
}
