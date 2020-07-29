package by.naty.booking.mapper;

import by.naty.booking.dto.RoomDto;
import by.naty.booking.model.Room;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring", uses = {ReservationMapper.class})
public interface RoomMapper {

    @Named("roomDtoMapper")
    Room roomDtoToRoom(RoomDto roomDto);

    @Mapping(target = "reservations", ignore = true)
    @Named("roomMapper")
    RoomDto roomToRoomDto(Room room);

    @IterableMapping(qualifiedByName = "roomDtoMapper")
    List<Room> roomDtoListToRoomList(List<RoomDto> roomDto);

    @IterableMapping(qualifiedByName = "roomMapper")
    List<RoomDto> roomListToRoomDtoList(List<Room> room);

}
