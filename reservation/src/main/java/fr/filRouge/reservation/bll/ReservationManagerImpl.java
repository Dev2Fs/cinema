package fr.filRouge.reservation.bll;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.filRouge.reservation.bo.Film;
import fr.filRouge.reservation.bo.Reservation;
import fr.filRouge.reservation.bo.Seance;
import fr.filRouge.reservation.dal.Filmdao;
import fr.filRouge.reservation.dal.Reservationdao;
import fr.filRouge.reservation.dal.Seancedao;

@Service
public class ReservationManagerImpl implements ReservationManager {
	@Autowired
	protected Reservationdao reservationdao;

	@Autowired
	protected Filmdao filmdao;
	@Autowired
	protected Seancedao seancedao;

	@Override
	public List<Film> getAllFilm() {

		return (List<Film>) filmdao.findAll();
	}

	@Transactional
	@Override
	public void addReservation(Reservation reservation) {
		reservationdao.save(reservation);

	}

	@Override
	public List<Reservation> getAllReservation() {

		return (List<Reservation>) reservationdao.findAll();
	}

	@Override
	public Reservation getReservationById(Integer id) {

		return reservationdao.findById(id).orElse(null);
	}

	@Override
	public void delReservationById(Integer id) {
		reservationdao.deleteById(id);

	}

	@Override
	public void modReservation(Reservation reservation) {
		reservationdao.save(reservation);

	}

	@Override
	public Seance getSeanceByID(Integer id) {
		return seancedao.findById(id).orElse(null);
	}

	@Override
	public List<Seance> getAllSeance() {
		return (List<Seance>) seancedao.findAll();
	}

	@Override
	public List<Reservation> getReservationSeance(Seance seance) {
		return reservationdao.findAllBySeance(seance);
	}
}
