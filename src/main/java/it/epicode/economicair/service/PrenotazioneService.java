package it.epicode.economicair.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.epicode.economicair.model.Prenotazione;
import it.epicode.economicair.repository.PrenotazioneRepository;

@Service
public class PrenotazioneService {

	@Autowired
	private PrenotazioneRepository prenotazioneRepository;

	public Prenotazione aggiungi(Prenotazione p) {
		return prenotazioneRepository.save(p);
	}

	public void elimina(Long id) {
		prenotazioneRepository.deleteById(id);
	}

	public Page<Prenotazione> getAll(Pageable pageable) {
		return prenotazioneRepository.findAll(pageable);
	}

	public Prenotazione findById(Long id) {
		Optional<Prenotazione> prenotazioneResult = prenotazioneRepository.findById(id);

		if (prenotazioneResult.isPresent()) {
			return prenotazioneResult.get();
		} else
			return null;
	}

	public Prenotazione aggiornaPrenotazione(Prenotazione p, Long id) {
		Optional<Prenotazione> prenotazioneResult = prenotazioneRepository.findById(id);

		if (prenotazioneResult.isPresent()) {
			Prenotazione prenotazione = new Prenotazione();
			prenotazione.setCodice(p.getCodice());
			prenotazione.setCodicePosto(p.getCodicePosto());
			prenotazione.setCostoBiglietto(p.getCostoBiglietto());
			prenotazione.setDescrizione(p.getDescrizione());
			return prenotazioneRepository.save(prenotazione);
		} else
			return null;

	}

}
