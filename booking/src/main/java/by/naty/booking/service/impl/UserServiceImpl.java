package by.naty.booking.service.impl;

import by.naty.booking.dto.UserDto;
import by.naty.booking.mapper.UserMapper;
import by.naty.booking.repository.UserRepository;
import by.naty.booking.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final String UNABLE_TO_FIND_BY_ID = "Unable to find resource with requested id=%d !";
    private static final String UNABLE_TO_DELETE = "Unable to delete resource with requested id=%d !";

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto create(UserDto userDto) {
        return userMapper.userToUserDto(userRepository.save(userMapper.userDtoToUser(userDto)));
    }

    @Override
    public List<UserDto> findAll() {
        return userMapper.userListToUserDtoList(userRepository.findAll());
    }

    @Override
    public UserDto findById(Long id) {
        return userMapper.userToUserDto(userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format(UNABLE_TO_FIND_BY_ID, id))));
    }

    @Override
    public void delete(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, String.format(UNABLE_TO_DELETE, id));
        }
    }

}
