package com.datvutech.cashlog.logic.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datvutech.cashlog.app.util.mapper.UserMapper;
import com.datvutech.cashlog.data.entity.User;
import com.datvutech.cashlog.data.entity.type.RoleType;
import com.datvutech.cashlog.data.repository.UserRepository;
import com.datvutech.cashlog.logic.dto.UserDto;
import com.datvutech.cashlog.logic.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepo;

    @Override
    public List<UserDto> getUsers(RoleType role) {
        List<User> users = userRepo.findByRole(role);
        List<UserDto> userDtos = new ArrayList<>();
        users.forEach(u -> {
            UserDto userDto = userMapper.userEntityToDto(u);
            userDtos.add(userDto);
        });
        return userDtos;
    }

}
