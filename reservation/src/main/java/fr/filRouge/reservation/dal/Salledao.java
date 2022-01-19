package fr.filRouge.reservation.dal;

import org.springframework.data.repository.CrudRepository;

import fr.filRouge.reservation.bo.Salle;

public interface Salledao extends CrudRepository<Salle, Integer> {

}
