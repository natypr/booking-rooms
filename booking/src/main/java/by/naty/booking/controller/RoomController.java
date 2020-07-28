package by.naty.booking.controller;

import by.naty.booking.dto.RoomDto;
import by.naty.booking.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping
    public ResponseEntity<RoomDto> create(@RequestBody RoomDto roomDto) {
        return new ResponseEntity<>(roomService.create(roomDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RoomDto>> findAll() {
        return new ResponseEntity<>(roomService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomDto> findById(@PathVariable Long id) {
        return new ResponseEntity<>(roomService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoomDto> update(@PathVariable Long id, @RequestBody RoomDto roomDto) {
        return new ResponseEntity<>(roomService.update(id, roomDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        roomService.delete(id);
        return ResponseEntity.ok("Successfully deleted");
    }

    @GetMapping("/d")
    public ResponseEntity<List<RoomDto>> findAvailableRooms(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") Date start,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") Date end) {
        return new ResponseEntity<>(roomService.findAvailableRooms(start, end), HttpStatus.OK);
    }
}
