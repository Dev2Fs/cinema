package fr.filRouge.reservation.dal;

import org.springframework.data.repository.CrudRepository;

import fr.filRouge.reservation.bo.Reservation;

public interface Reservationdao extends CrudRepository<Reservation, Integer> {

}
