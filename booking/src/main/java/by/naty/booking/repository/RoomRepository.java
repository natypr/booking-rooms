package by.naty.booking.repository;

import by.naty.booking.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query(value =
            "select * from room as ro where ro.id not in (select reserv.room_id from reservation as reserv where " +
                    "(?1 <= reserv.date_start and ?2 <= reserv.date_end and ?2 >= reserv.date_start) " +
                    "or (?1 >= reserv.date_start and ?2 >= reserv.date_end and ?1 <= reserv.date_end) " +
                    "or (?1 >= reserv.date_start and ?2 <= reserv.date_end and ?1 <= reserv.date_end and ?2 >= reserv.date_start) " +
                    "or (?1 <= reserv.date_start and ?2 >= reserv.date_end));"
            , nativeQuery = true)
    List<Room> findAvailableRooms(LocalDateTime dateStart, LocalDateTime dateEnd);

}
