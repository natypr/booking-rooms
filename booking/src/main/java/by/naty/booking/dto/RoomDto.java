package by.naty.booking.dto;

import by.naty.booking.model.RoomType;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class RoomDto {

    private Long id;
    private String name;
    @JsonProperty("room_type")
    private RoomType roomType;
    private String location;
    private List<ReservationDto> reservations = new ArrayList<>();

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

    public List<ReservationDto> getReservations() {
        return reservations;
    }

    public void setReservations(List<ReservationDto> reservations) {
        this.reservations = reservations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomDto roomDto = (RoomDto) o;

        if (!id.equals(roomDto.id)) return false;
        if (!name.equals(roomDto.name)) return false;
        if (roomType != roomDto.roomType) return false;
        return location.equals(roomDto.location);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + roomType.hashCode();
        result = 31 * result + location.hashCode();
        return result;
    }
}
