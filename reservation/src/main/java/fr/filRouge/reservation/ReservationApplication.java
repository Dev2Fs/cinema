package fr.filRouge.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.filRouge.reservation.bll.ReservationManager;
import fr.filRouge.reservation.bo.Reservation;

@SpringBootApplication
public class ReservationApplication implements CommandLineRunner {
	@Autowired
	ReservationManager reservationManager;

	public static void main(String[] args) {
		SpringApplication.run(ReservationApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		Reservation premiereReservation = new Reservation();
		reservationManager.addReservation(premiereReservation);

	}

}
