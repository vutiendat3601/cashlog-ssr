package com.datvutech.cashlog.data.repository;

import java.util.List;

import com.datvutech.cashlog.data.entity.User;
import com.datvutech.cashlog.data.entity.type.RoleType;
import com.datvutech.cashlog.data.repository.generic.GenericRepository;

public interface UserRepository extends GenericRepository<User> {
    User findByUsernameAndPassword(String username, String password);

    User findByUserId(int userId);

    List<User> findByRole(RoleType role);

    User findByCode(String code);
}
