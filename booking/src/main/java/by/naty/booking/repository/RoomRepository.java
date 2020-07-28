package by.naty.booking.repository;

import by.naty.booking.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query(value =
            "select * from room as r " +
                "where r.id not in " +
                 "( select reserv.room_id from reservation as reserv " +
                        "where (date_start >= ?1 and date_start < ?2) or (date_end > ?1 and date_end <= ?2)"
            , nativeQuery = true)
    List<Room> findAvailableRoom(Date dateFrom, Date dateTo);

    @Query(value =
            "select * from (select * from room as r where r.id not in " +
                    "(select reserv.room_id from reservation as reserv " +
                        "where (date_start >= ?1 and date_start < ?2) or (date_end > ?1 and date_end <= ?2))) as roo " +
                        "where roo.id = ?3"
            , nativeQuery = true)
    Room checkAvailability(LocalDateTime dateFrom, LocalDateTime dateTo, int id);

}
