package by.naty.booking.service.impl;

import by.naty.booking.controller.RoomController;
import by.naty.booking.dto.RoomDto;
import by.naty.booking.mapper.RoomMapper;
import by.naty.booking.model.Room;
import by.naty.booking.repository.RoomRepository;
import by.naty.booking.service.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    private static final Logger log = LoggerFactory.getLogger(RoomController.class);
    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;

    public RoomServiceImpl(RoomRepository roomRepository, RoomMapper roomMapper) {
        this.roomRepository = roomRepository;
        this.roomMapper = roomMapper;
    }

    @Override
    public RoomDto create(RoomDto roomDto) {
        String roomName = roomDto.getName();
        log.info("Create room with name - " + roomName);
        try {
            return roomMapper.toRoomDto(roomRepository.save(roomMapper.toRoom(roomDto)));
        } catch (Exception e) {
            log.error("Room not created, name already exists - " + roomName);
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    String.format("Unable to create resource with requested name=%s exc=%s", roomName, e));
        }
    }

    @Override
    public List<RoomDto> findAll() {
        log.info("Find all rooms");
        return roomMapper.toRoomDtoList(roomRepository.findAll());
    }

    @Transactional
    @Override
    public RoomDto findById(Long id) {
        log.info("Find room with id - " + id);
        return roomMapper.toRoomDto(roomRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Unable to find resource with requested id=%d", id))));
    }

    @Override
    public RoomDto update(Long id, RoomDto newRoomDto) {
        Room existingRoom = roomRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Unable to find resource with requested id=%d", id)));
        existingRoom.setLocation(newRoomDto.getLocation());
        log.info("Update room with id - " + id);
        return roomMapper.toRoomDto(roomRepository.save(existingRoom));
    }

    @Override
    public void delete(Long id) {
        log.info("Delete room with id - " + id);
        try {
            roomRepository.deleteById(id);
        } catch (Exception e) {
            log.error("No room with id - " + id);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT,
                    String.format("Unable to delete resource with requested id=%d exc=%s", id, e));
        }
    }
}
