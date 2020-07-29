package by.naty.booking.repository;

import by.naty.booking.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    void deleteByDateEndBefore(LocalDateTime t);

    List<Reservation> findByUserId(Long userId);

}
