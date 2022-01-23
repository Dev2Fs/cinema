package fr.filRouge.reservation.bll;

import java.util.List;

import fr.filRouge.reservation.bo.Film;
import fr.filRouge.reservation.bo.Reservation;
import fr.filRouge.reservation.bo.Seance;

public interface ReservationManager {

	public List<Film> getAllFilm();

	public void addReservation(Reservation reservation);

	public List<Reservation> getAllReservation();

	public Reservation getReservationById(Integer id);

	public void delReservationById(Integer id);

	public void modReservation(Reservation reservation);

	public Seance getSeanceByID(Integer id);

	public List<Seance> getAllSeance();

	public List<Reservation> getReservationSeance(Seance seance);

}
