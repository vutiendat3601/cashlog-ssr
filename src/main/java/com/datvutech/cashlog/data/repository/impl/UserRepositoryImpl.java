package com.datvutech.cashlog.data.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.datvutech.cashlog.data.entity.User;
import com.datvutech.cashlog.data.entity.type.RoleType;
import com.datvutech.cashlog.data.repository.UserRepository;
import com.datvutech.cashlog.data.repository.generic.impl.GenericRepositoryImpl;

@Repository
public class UserRepositoryImpl
                extends GenericRepositoryImpl<User>
                implements UserRepository {

        protected UserRepositoryImpl() {
                super(User.class);
        }

        @Override
        public User findByUsernameAndPassword(String username, String password) {
                Session session = sessionFactory.getCurrentSession();
                String sql = "FROM User " +
                                "WHERE username = :username AND password = :password";
                List<User> users = session.createQuery(sql, User.class)
                                .setParameter("username", username)
                                .setParameter("password", password)
                                .getResultList();
                return users.isEmpty() ? null : users.get(0);
        }

        @Override
        public List<User> findByRole(RoleType role) {
                Session session = sessionFactory.getCurrentSession();
                String sql = "FROM User" +
                                " WHERE role = :role";
                List<User> users = session.createQuery(sql, User.class)
                                .setParameter("role", role)
                                .getResultList();
                return users;
        }

        @Override
        public User findByCode(String code) {
                Session session = sessionFactory.getCurrentSession();
                String sql = "FROM User" +
                                " WHERE code = :code";
                List<User> users = session.createQuery(sql, User.class)
                                .setParameter("code", code)
                                .getResultList();
                return users.isEmpty() ? null : users.get(0);
        }

        @Override
        public User findByUserId(int userId) {
                Session session = sessionFactory.getCurrentSession();
                User user = session.find(User.class, userId);
                return user;
        }
}
