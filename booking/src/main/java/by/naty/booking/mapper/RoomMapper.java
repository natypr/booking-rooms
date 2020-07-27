package by.naty.booking.mapper;

import by.naty.booking.dto.RoomDto;
import by.naty.booking.model.Room;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring")
public interface RoomMapper {

    Room toRoom(RoomDto roomDto);

    RoomDto toRoomDto(Room room);

    List<Room> toRoomList(List<RoomDto> roomDto);

    List<RoomDto> toRoomDtoList(List<Room> room);

}
