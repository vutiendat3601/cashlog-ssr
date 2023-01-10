package com.datvutech.cashlog.app.util.mapper;

import org.springframework.stereotype.Component;

import com.datvutech.cashlog.data.entity.User;
import com.datvutech.cashlog.logic.dto.UserDto;

@Component
public class UserMapper extends AbstractMapper {

    public UserDto userEntityToDto(User userEntity) {
        UserDto userDto = mapper.map(userEntity, UserDto.class);
        return userDto;
    }
}
