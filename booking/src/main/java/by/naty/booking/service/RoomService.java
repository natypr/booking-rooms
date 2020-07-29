package by.naty.booking.service;

import by.naty.booking.dto.RoomDto;

import java.util.Date;
import java.util.List;

public interface RoomService extends BaseService<RoomDto> {

    RoomDto update(Long id, RoomDto newRoomDto);

    List<RoomDto> findAvailableRooms(Date dateFrom, Date dateTo);

}
