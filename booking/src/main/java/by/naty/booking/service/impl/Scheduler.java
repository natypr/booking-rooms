package by.naty.booking.service.impl;

import by.naty.booking.repository.ReservationRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class Scheduler {
    private final ReservationRepository reservationRepository;

    public Scheduler(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Scheduled(fixedDelay = 60000)
    public void deleteReservations() {
        reservationRepository.deleteWithInvalidDate();
    }
}
