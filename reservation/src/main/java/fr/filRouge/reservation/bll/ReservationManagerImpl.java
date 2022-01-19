package fr.filRouge.reservation.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.filRouge.reservation.bo.Reservation;
import fr.filRouge.reservation.dal.Reservationdao;

@Service
public class ReservationManagerImpl implements ReservationManager {
	@Autowired
	protected Reservationdao reservationdao;

//	@Autowired
//	protected Filmdao filmdao;

//	@Override
//	public List<Film> getAllFilm() {
//
//		return (List<Film>) filmdao.findAll();
//	}

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

}
