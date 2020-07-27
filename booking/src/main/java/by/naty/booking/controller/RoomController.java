package by.naty.booking.controller;

import by.naty.booking.model.Room;
import by.naty.booking.repository.RoomRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/rooms")
public class RoomController {

    private static final Logger log = LoggerFactory.getLogger(RoomController.class);
    private RoomRepository repository;

    public RoomController(RoomRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Room> getAll() {
        return repository.findAll();
    }


    @GetMapping("/{id}")
    public Room getOne(@PathVariable long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Room room) {
        HttpStatus status;
        try {
            repository.save(room);
            status = HttpStatus.CREATED;
        } catch (Exception ex) {
            log.error("Cannot create room ", ex);
            status = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity(status);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody Room room, @PathVariable long id) {
        HttpStatus status;
        room.setId(id);
        try {
            repository.save(room);
            status = HttpStatus.OK;
        } catch (Exception ex) {
            log.error("Cannot update room ", ex);
            status = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity(status);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable long id) {
        repository.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}