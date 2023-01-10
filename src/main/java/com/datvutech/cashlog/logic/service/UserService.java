package com.datvutech.cashlog.logic.service;

import java.util.List;

import com.datvutech.cashlog.data.entity.type.RoleType;
import com.datvutech.cashlog.logic.dto.UserDto;

public interface UserService {
    List<UserDto> getUsers(RoleType role);
}
