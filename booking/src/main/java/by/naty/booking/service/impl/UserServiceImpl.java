package by.naty.booking.service.impl;

import by.naty.booking.dto.UserDto;
import by.naty.booking.mapper.UserMapper;
import by.naty.booking.repository.ReservationRepository;
import by.naty.booking.repository.UserRepository;
import by.naty.booking.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final String UNABLE_TO_FIND_BY_ID = "Unable to find resource with requested id=%d !";

    private final UserRepository userRepository;
    private final ReservationRepository reservationRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository,
                           ReservationRepository reservationRepository,
                           UserMapper userMapper) {
        this.userRepository = userRepository;
        this.reservationRepository = reservationRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto create(UserDto userDto) {
        return userMapper.toUserDto(userRepository.save(userMapper.toUser(userDto)));
    }

    @Override
    public List<UserDto> findAll() {
        return userMapper.toUserDtoList(userRepository.findAll());
    }

    @Override
    public UserDto findById(Long id) {
        return userMapper.toUserDto(userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format(UNABLE_TO_FIND_BY_ID, id))));
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public boolean userIsAvailable(Long userId, Date dateStart, Date dateEnd) {
        //r.getDateStart() >= dateStart && r.getDateEnd() <= dateEnd (and if in interval)
        return reservationRepository.findAll()
                .stream().noneMatch(r -> r.getUserId().equals(userId));
    }
}
