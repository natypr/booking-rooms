package by.naty.booking.service;

import by.naty.booking.dto.ReservationDto;

import java.util.List;

public interface ReservationService {

    ReservationDto create(ReservationDto reservationDto);

    List<ReservationDto> findAll();

    ReservationDto findById(Long id);

    List<ReservationDto> findAllByIdUser(Long userId);

    void delete(Long id);

}
