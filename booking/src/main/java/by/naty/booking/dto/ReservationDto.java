package by.naty.booking.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.Objects;

public class ReservationDto {

    private Long id;
    @JsonProperty("room_id")
    private Long roomId;
    @JsonProperty("user_id")
    private Long userId;
    private String name;
    private String description;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm")
    @JsonProperty("date_start")
    private Date dateStart;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm")
    @JsonProperty("date_end")
    private Date dateEnd;

    public ReservationDto() {
    }

    public ReservationDto(Long id, Long roomId, Long userId, String name,
                          Date dateStart, Date dateEnd) {
        this.id = id;
        this.roomId = roomId;
        this.userId = userId;
        this.name = name;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public ReservationDto(Long id, Long roomId, Long userId, String name,
                          String description, Date dateStart, Date dateEnd) {
        this.id = id;
        this.roomId = roomId;
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReservationDto that = (ReservationDto) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(roomId, that.roomId)) return false;
        if (!Objects.equals(userId, that.userId)) return false;
        if (!Objects.equals(name, that.name)) return false;
        if (!Objects.equals(description, that.description)) return false;
        if (!Objects.equals(dateStart, that.dateStart)) return false;
        return Objects.equals(dateEnd, that.dateEnd);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (roomId != null ? roomId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (dateStart != null ? dateStart.hashCode() : 0);
        result = 31 * result + (dateEnd != null ? dateEnd.hashCode() : 0);
        return result;
    }
}
