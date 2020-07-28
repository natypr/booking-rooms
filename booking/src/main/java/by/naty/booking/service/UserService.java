package by.naty.booking.service;

import by.naty.booking.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto create(UserDto userDto);

    List<UserDto> findAll();

    UserDto findById(Long id);

}
