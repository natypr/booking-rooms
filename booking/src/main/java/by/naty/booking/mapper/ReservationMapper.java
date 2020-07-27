package by.naty.booking.mapper;

import by.naty.booking.dto.ReservationDto;
import by.naty.booking.model.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring")
public interface ReservationMapper {

    Reservation toReservation(ReservationDto reservationDto);

    ReservationDto toReservationDto(Reservation reservation);

    List<Reservation> toReservationList(List<ReservationDto> reservationDto);

    List<ReservationDto> toReservationDtoList(List<Reservation> reservation);

}
