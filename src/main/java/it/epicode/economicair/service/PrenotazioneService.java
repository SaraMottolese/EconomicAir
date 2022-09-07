package it.epicode.economicair.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.economicair.model.Prenotazione;
import it.epicode.economicair.repository.PrenotazioneRepository;

@Service
public class PrenotazioneService {
	
	@Autowired
	PrenotazioneRepository prenotazioneRepository;
	
	public Prenotazione aggiungi(Prenotazione p) {
		return prenotazioneRepository.save(p);
	}
	
	public void elimina(Long id) {
		prenotazioneRepository.deleteById(id);
	}
	
	public List<Prenotazione> getAll(){
		return prenotazioneRepository.findAll();
	}
	
	public Prenotazione aggiornaPrenotazione(Prenotazione p, Long id) {
		return prenotazioneRepository.save(p);
	}

}
