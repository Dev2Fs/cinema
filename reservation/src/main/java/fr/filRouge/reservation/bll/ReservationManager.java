package fr.filRouge.reservation.bll;

import java.util.List;

import fr.filRouge.reservation.bo.Reservation;

public interface ReservationManager {

//	public List<Film> getAllFilm();

	public void addReservation(Reservation reservation);

	public List<Reservation> getAllReservation();

	public Reservation getReservationById(Integer id);

	public void delReservationById(Integer id);

	public void modReservation(Reservation reservation);
}
