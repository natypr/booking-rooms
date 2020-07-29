package by.naty.booking.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", length = 50, unique = true)
    private String name;
    @Column(name = "room_type", length = 15)
    @Enumerated(EnumType.STRING)
    private RoomType roomType;
    @Column(name = "location", length = 300)
    private String location;
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<Reservation> reservations = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (!id.equals(room.id)) return false;
        if (!name.equals(room.name)) return false;
        if (roomType != room.roomType) return false;
        if (!location.equals(room.location)) return false;
        return Objects.equals(reservations, room.reservations);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + roomType.hashCode();
        result = 31 * result + location.hashCode();
        result = 31 * result + (reservations != null ? reservations.hashCode() : 0);
        return result;
    }
}
