package it.epicode.economicair.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.epicode.economicair.model.Prenotazione;
import it.epicode.economicair.service.PrenotazioneService;

@RestController
@RequestMapping("api/prenotazione")
public class PrenotazioneController {

	@Autowired
	private PrenotazioneService prenotazioneService;

	@PostMapping("/aggiungi")
	public ResponseEntity<Prenotazione> aggiungi(@RequestBody Prenotazione prenotazione) {
		Prenotazione aggiungiPrenotazione = prenotazioneService.aggiungi(prenotazione);
		return new ResponseEntity<Prenotazione>(aggiungiPrenotazione, HttpStatus.CREATED);
	}

	@DeleteMapping("/elimina/{id}")
	public ResponseEntity<String> elimina(@PathVariable Long id) {
		prenotazioneService.elimina(id);
		return new ResponseEntity<String>("Prenotazione eliminata correttamente", HttpStatus.OK);
	}

	@PutMapping("/aggiorna/{id}")
	public ResponseEntity<Prenotazione> aggiorna(@RequestBody Prenotazione prenotazione, @PathVariable Long id) {
		Prenotazione updateAeroporto = prenotazioneService.aggiornaPrenotazione(prenotazione, id);
		return new ResponseEntity<Prenotazione>(updateAeroporto, HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<Page<Prenotazione>> trovaTutti(Pageable pageable) {
		Page<Prenotazione> listaPrenotazioni = prenotazioneService.getAll(pageable);
		return new ResponseEntity<Page<Prenotazione>>(listaPrenotazioni, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Prenotazione> getById(@PathVariable Long id) {
		Prenotazione prenotazione = prenotazioneService.findById(id);
		return new ResponseEntity<Prenotazione>(prenotazione, HttpStatus.OK);
	}
}
