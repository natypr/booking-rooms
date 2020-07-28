package by.naty.booking.mapper;

import by.naty.booking.dto.UserDto;
import by.naty.booking.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring")
public interface UserMapper {

    User toUser(UserDto userDto);

    UserDto toUserDto(User user);

    List<User> toUserList(List<UserDto> userDto);

    List<UserDto> toUserDtoList(List<User> user);

}
