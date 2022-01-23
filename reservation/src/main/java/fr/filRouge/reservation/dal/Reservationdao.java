package fr.filRouge.reservation.dal;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.filRouge.reservation.bo.Reservation;
import fr.filRouge.reservation.bo.Seance;

public interface Reservationdao extends CrudRepository<Reservation, Integer> {
	List<Reservation> findAllBySeance(Seance seance);

}
