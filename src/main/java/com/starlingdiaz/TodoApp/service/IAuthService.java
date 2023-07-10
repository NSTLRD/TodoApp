package com.starlingdiaz.TodoApp.service;

import com.starlingdiaz.TodoApp.dto.LoginDto;
import com.starlingdiaz.TodoApp.dto.RegisterDto;

public interface IAuthService {
    String register(RegisterDto registerDto);
    String login(LoginDto loginDto);
}
