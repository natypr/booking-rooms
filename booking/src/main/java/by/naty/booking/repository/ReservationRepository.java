package by.naty.booking.repository;

import by.naty.booking.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query(nativeQuery = true, value = "delete from reservation where reservation.date_end < now()")
    void deleteWithInvalidDate();

}
