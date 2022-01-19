package fr.filRouge.reservation.dal;

import org.springframework.data.repository.CrudRepository;

import fr.filRouge.reservation.bo.Film;

public interface Filmdao extends CrudRepository<Film, Integer> {

}
