package fr.filRouge.reservation.dal;

import org.springframework.data.repository.CrudRepository;

import fr.filRouge.reservation.bo.Seance;

public interface Seancedao extends CrudRepository<Seance, Integer> {

}
