package by.naty.booking.dto;

import by.naty.booking.model.RoomType;

import java.util.Objects;

public class RoomDto {

    private Long id;
    private String name;
    private RoomType roomType;
    private String location;

    public RoomDto() {
    }

    public RoomDto(Long id, String name, RoomType roomType, String location) {
        this.id = id;
        this.name = name;
        this.roomType = roomType;
        this.location = location;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomDto roomDto = (RoomDto) o;

        if (!Objects.equals(id, roomDto.id)) return false;
        if (!Objects.equals(name, roomDto.name)) return false;
        if (roomType != roomDto.roomType) return false;

        return Objects.equals(location, roomDto.location);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (roomType != null ? roomType.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        return result;
    }
}
