package by.naty.booking.service;

import by.naty.booking.dto.RoomDto;

import java.time.LocalDateTime;
import java.util.List;

public interface RoomService extends BaseService<RoomDto> {

    RoomDto update(Long id, RoomDto newRoomDto);

    List<RoomDto> findAvailableRooms(LocalDateTime dateFrom, LocalDateTime dateTo);

    List<RoomDto> findAvailableRoomForUser(LocalDateTime dateFrom, LocalDateTime dateTo, Long userId);

}
