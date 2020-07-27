package by.naty.booking.service;

import by.naty.booking.dto.RoomDto;

import java.util.List;

public interface RoomService {

    RoomDto create(RoomDto roomDto);

    List<RoomDto> findAll();

    RoomDto findById(Long id);

    RoomDto update(Long id, RoomDto newRoomDto);

    void delete(Long id);

}
