package com.datvutech.cashlog.data.repository.impl;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.datvutech.cashlog.data.entity.Bank;
import com.datvutech.cashlog.data.repository.BankRepository;
import com.datvutech.cashlog.data.repository.generic.impl.GenericRepositoryImpl;

@Repository
public class BankRepositoryImpl extends GenericRepositoryImpl<Bank>
                implements BankRepository {

        protected BankRepositoryImpl() {
                super(Bank.class);
        }

        @Override
        public Bank findByCode(String code) {
                Session session = sessionFactory.getCurrentSession();
                String sql = "FROM Bank" +
                                " WHERE code = :code";
                List<Bank> banks = session.createQuery(sql, Bank.class)
                                .setParameter("code", code)
                                .getResultList();
                return banks.isEmpty() ? null : banks.get(0);
        }

        @Override
        public Bank findByBankId(int bankId) {
                Session session = sessionFactory.getCurrentSession();
                Bank bank = session.find(Bank.class, bankId);
                return bank;
        }

        @PersistenceContext
        private Session sessionx;
}
