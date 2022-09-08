package it.epicode.economicair.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Aeroporto aeroportoPartenza;
	
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Aeroporto aeroportoArrivo;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime dataPartenza;
	
	 @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime dataArrivo;
}
