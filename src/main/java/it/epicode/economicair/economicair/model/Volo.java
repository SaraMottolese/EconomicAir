package it.epicode.economicair.economicair.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	
	private Aeroporto aeroportoPartenza;
	private Aeroporto aeroportoArrivo;
	private LocalDateTime dataPartenza;
	private LocalDateTime dataArrivo;
}
