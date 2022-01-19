package fr.filRouge.reservation.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.filRouge.reservation.bll.ReservationManager;
import fr.filRouge.reservation.bo.Reservation;

@RestController
public class ReservationWS {

	@Autowired
	private ReservationManager reservationManager;

//	@GetMapping("/films")
//	public List<Film> getAllFilm() {
//		return reservationManager.getAllFilm();

	@GetMapping("/reservations")
	public List<Reservation> getAllReservation() {
		return reservationManager.getAllReservation();

	}

}
