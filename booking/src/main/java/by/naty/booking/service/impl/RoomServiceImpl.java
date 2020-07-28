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

import java.util.Date;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    private static final Logger log = LoggerFactory.getLogger(RoomController.class);
    private static final String UNABLE_TO_CREATE = "Unable to create resource with requested name = %s !";
    private static final String UNABLE_TO_FIND_BY_ID = "Unable to find resource with requested id=%d !";
    private static final String UNABLE_TO_DELETE = "Unable to delete resource with requested id=%d !";
    private static final String NAME_EXISTS = " Room not created, name already exists ";
    private static final String CHANGED_LOCATION = " Changed location in room with id=%d and location=(%s) to new location=(%s) ";
    private static final String NO_ROOM_WITH_ID = " No room with current id ";

    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;

    public RoomServiceImpl(RoomRepository roomRepository, RoomMapper roomMapper) {
        this.roomRepository = roomRepository;
        this.roomMapper = roomMapper;
    }

    @Override
    public RoomDto create(RoomDto roomDto) {
        String roomName = roomDto.getName();
        try {
            return roomMapper.toRoomDto(roomRepository.save(roomMapper.toRoom(roomDto)));
        } catch (Exception e) {
            log.error(NAME_EXISTS + roomName);
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    String.format(UNABLE_TO_CREATE + NAME_EXISTS, roomName));
        }
    }

    @Override
    public List<RoomDto> findAll() {
        return roomMapper.toRoomDtoList(roomRepository.findAll());
    }

    @Transactional
    @Override
    public RoomDto findById(Long id) {
        return roomMapper.toRoomDto(roomRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format(UNABLE_TO_FIND_BY_ID + NO_ROOM_WITH_ID, id))));
    }

    @Override
    public RoomDto update(Long id, RoomDto newRoomDto) {
        Room existingRoom = roomRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format(UNABLE_TO_FIND_BY_ID + NO_ROOM_WITH_ID, id)));
        existingRoom.setLocation(newRoomDto.getLocation());
        log.info(String.format(CHANGED_LOCATION, id, existingRoom.getLocation(), newRoomDto.getLocation()));
        return roomMapper.toRoomDto(roomRepository.save(existingRoom));
    }

    @Override
    public void delete(Long id) {
        try {
            //only if reservationService.findAllByIdRoom is empty
            roomRepository.deleteById(id);
        } catch (Exception e) {
            log.error(NO_ROOM_WITH_ID + id);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT,
                    String.format(UNABLE_TO_DELETE + NO_ROOM_WITH_ID, id));
        }
    }

    @Override
    public List<RoomDto> findAvailableRooms(Date dateFrom, Date dateTo) {
        return roomMapper.toRoomDtoList(roomRepository.findAvailableRoom(dateFrom, dateTo));
    }
}
