package fr.filRouge.reservation.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reservation")
@Data
@NoArgsConstructor

public class Reservation {
	@Id
	@GeneratedValue
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "seanceid")
	private Seance seance;

	// constructeur sans Id
	public Reservation(Seance seance) {
		super();
		this.seance = seance;

	}

}
