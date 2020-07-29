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
    private static final String UNABLE_TO_DELETE = "Unable to delete resource with requested id=%d !";


    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;

    public ReservationServiceImpl(ReservationRepository reservationRepository, ReservationMapper reservationMapper) {
        this.reservationRepository = reservationRepository;
        this.reservationMapper = reservationMapper;
    }

    @Override
    public ReservationDto create(ReservationDto reservationDto) {
        Reservation reservation = reservationMapper.reservationDtoToReservation(reservationDto);
        return reservationMapper.reservationToReservationDto(reservationRepository.save(reservation));
    }

    @Override
    public List<ReservationDto> findAll() {
        return reservationMapper.reservationListToReservationDtoList(reservationRepository.findAll());
    }

    @Transactional
    @Override
    public ReservationDto findById(Long id) {
        return reservationMapper.reservationToReservationDto(reservationRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format(UNABLE_TO_FIND_BY_ID, id))));
    }

    @Override
    public List<ReservationDto> findAllByIdUser(Long userId) {
        List<Reservation> reservationList = reservationRepository.findAll();
        List<Reservation> reservationOfUserWithCurrentId = reservationList.stream()
                .filter(reservation -> reservation.getUser().getId().equals(userId))
                .collect(Collectors.toList());
        return reservationMapper.reservationListToReservationDtoList(reservationOfUserWithCurrentId);
    }

    @Override
    public List<ReservationDto> findAllByIdRoom(Long roomId) {
        List<Reservation> reservationList = reservationRepository.findAll();
        List<Reservation> reservationOfUserWithCurrentId = reservationList.stream()
                .filter(reservation -> reservation.getRoom().getId().equals(roomId))
                .collect(Collectors.toList());
        return reservationMapper.reservationListToReservationDtoList(reservationOfUserWithCurrentId);
    }

    @Override
    public void delete(Long id) {
        try {
            reservationRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, String.format(UNABLE_TO_DELETE, id));
        }
    }
}
