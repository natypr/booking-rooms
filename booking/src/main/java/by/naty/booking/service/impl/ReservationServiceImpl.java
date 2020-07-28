package by.naty.booking.service.impl;

import by.naty.booking.dto.ReservationDto;
import by.naty.booking.mapper.ReservationMapper;
import by.naty.booking.model.Reservation;
import by.naty.booking.repository.ReservationRepository;
import by.naty.booking.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {

    private static final String UNABLE_TO_FIND_BY_ID = "Unable to find resource with requested id=%d !";

    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;

    public ReservationServiceImpl(ReservationRepository reservationRepository, ReservationMapper reservationMapper) {
        this.reservationRepository = reservationRepository;
        this.reservationMapper = reservationMapper;
    }

    @Override
    public ReservationDto create(ReservationDto reservationDto) {
        Reservation reservation = reservationMapper.toReservation(reservationDto);
        return reservationMapper.toReservationDto(reservationRepository.save(reservation));
    }

    @Override
    public List<ReservationDto> findAll() {
        return reservationMapper.toReservationDtoList(reservationRepository.findAll());
    }

    @Transactional
    @Override
    public ReservationDto findById(Long id) {
        return reservationMapper.toReservationDto(reservationRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format(UNABLE_TO_FIND_BY_ID, id))));
    }

    @Override
    public List<ReservationDto> findAllByIdUser(Long userId) {
        List<Reservation> reservationList = reservationRepository.findAll();
        List<Reservation> reservationOfUserWithCurrentId = reservationList
                .stream()
                .filter(reservation -> reservation.getUserId().equals(userId))
                .collect(Collectors.toList());
        return reservationMapper.toReservationDtoList(reservationOfUserWithCurrentId);
    }

    @Override
    public List<ReservationDto> findAllByIdRoom (Long roomId){
        List<Reservation> reservationList = reservationRepository.findAll();
        List<Reservation> reservationOfUserWithCurrentId = reservationList
                .stream()
                .filter(reservation -> reservation.getRoomId().equals(roomId))
                .collect(Collectors.toList());
        return reservationMapper.toReservationDtoList(reservationOfUserWithCurrentId);
    }

    @Override
    public void delete(Long id) {
        reservationRepository.deleteById(id);
    }
}
