package fr.filRouge.reservation.bo;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "seance")
@Data
@NoArgsConstructor
public class Seance {

	@Id
	@Column(name = "id_seance")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "jour")
	private LocalDate jour;

	@Column(name = "heure")
	private LocalTime heure;

	@ManyToOne
	@JoinColumn(name = "id_film")
	private Film film;

	@ManyToOne
	@JoinColumn(name = "id_salle")
	private Salle salle;
//
//	@OneToMany(mappedBy = "reservation")
//	private List<Reservation> reservations;

}