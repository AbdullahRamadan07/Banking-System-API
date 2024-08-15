package com.example.Banking_System.Service;

import com.example.Banking_System.DTOs.UserDto;

public interface UserService {
    UserDto findUserById(Long id);
    UserDto findUserByUsername(String username);
    UserDto saveUser(UserDto userDto);
}
