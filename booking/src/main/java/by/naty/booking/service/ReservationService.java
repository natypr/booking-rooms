package by.naty.booking.service;

import by.naty.booking.dto.ReservationDto;

import java.util.List;

public interface ReservationService extends BaseService<ReservationDto> {

    List<ReservationDto> findAllByIdUser(Long userId);

    List<ReservationDto> findAllByIdRoom(Long roomId);

}
