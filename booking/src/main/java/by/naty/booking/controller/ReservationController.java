package by.naty.booking.controller;


import by.naty.booking.dto.ReservationDto;
import by.naty.booking.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/reservation")
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public ResponseEntity<ReservationDto> create(@RequestBody ReservationDto reservationDto) {
        return new ResponseEntity<>(reservationService.create(reservationDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ReservationDto>> findAll() {
        return new ResponseEntity<>(reservationService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationDto> findById(@PathVariable Long id) {
        return new ResponseEntity<>(reservationService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<ReservationDto>> findAllByIdUser(@PathVariable Long userId) {
        return new ResponseEntity<>(reservationService.findAllByIdUser(userId), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        reservationService.delete(id);
        return ResponseEntity.ok("Successfully delete");
    }
}
