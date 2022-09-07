package it.epicode.economicair.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Volo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/*
	 * TODO Modificare modello per many to many aeroporto
	 */
	@ManyToOne
	private Aeroporto aeroportoPartenza;
	
	@ManyToOne
	private Aeroporto aeroportoArrivo;
	
	private LocalDateTime dataPartenza;
	private LocalDateTime dataArrivo;
}
