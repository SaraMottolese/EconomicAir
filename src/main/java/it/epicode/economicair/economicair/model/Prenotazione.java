package it.epicode.economicair.economicair.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString; 

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Prenotazione {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Length(max = 6)
	private String codice;
	
	private String codicePosto;
	private String descrizione;
	private double costoBiglietto;
}
