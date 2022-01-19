package fr.filRouge.reservation.bo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
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
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "seanceid", foreignKey = @ForeignKey(name = "real_FK"))
	private Seance seance;

	// constructeur sans Id
	public Reservation(Seance seance, Integer nbResevation) {
		super();
		this.seance = seance;

	}

}
