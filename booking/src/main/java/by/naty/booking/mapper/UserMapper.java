package by.naty.booking.mapper;

import by.naty.booking.dto.UserDto;
import by.naty.booking.model.User;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring", uses = {ReservationMapper.class})
public interface UserMapper {

    @Named("userDtoMapper")
    User userDtoToUser(UserDto userDto);

    @Mapping(target = "reservations", ignore = true)
    @Named("userMapper")
    UserDto userToUserDto(User user);

    @IterableMapping(qualifiedByName = "userDtoMapper")
    List<User> userDtoListToUserList(List<UserDto> userDto);

    @IterableMapping(qualifiedByName = "userMapper")
    List<UserDto> userListToUserDtoList(List<User> user);

}
