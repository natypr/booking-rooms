package by.naty.booking.mapper;

import by.naty.booking.dto.ReservationDto;
import by.naty.booking.model.Reservation;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring", uses = {UserMapper.class, RoomMapper.class})
public interface ReservationMapper {

    @Named("reservationDtoMapper")
    Reservation reservationDtoToReservation(ReservationDto reservationDto);

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "room", ignore = true)
    @Named("reservationMapper")
    ReservationDto reservationToReservationDto(Reservation reservation);

    @IterableMapping(qualifiedByName = "reservationDtoMapper")
    List<Reservation> reservationDtoListToReservationList(List<ReservationDto> reservationDto);

    @IterableMapping(qualifiedByName = "reservationMapper")
    List<ReservationDto> reservationListToReservationDtoList(List<Reservation> reservation);

}
