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

import it.epicode.economicair.model.Volo;
import it.epicode.economicair.service.VoloService;

@RestController
@RequestMapping("api/volo")
public class VoloController {

	@Autowired
	private VoloService voloService;

	@PostMapping("/aggiungi")
	public ResponseEntity<Volo> aggiungi(@RequestBody Volo volo) {
		Volo aggiungiVolo = voloService.aggiungi(volo);
		return new ResponseEntity<Volo>(aggiungiVolo, HttpStatus.CREATED);
	}

	@DeleteMapping("/elimina/{id}")
	public ResponseEntity<String> elimina(@PathVariable Long id) {
		voloService.elimina(id);
		return new ResponseEntity<String>("Volo eliminato correttamente", HttpStatus.OK);
	}

	@PutMapping("/aggiorna/{id}")
	public ResponseEntity<Volo> aggiorna(@RequestBody Volo volo, @PathVariable Long id) {
		Volo updateVolo = voloService.aggiornaVolo(volo, id);
		return new ResponseEntity<Volo>(updateVolo, HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<Page<Volo>> trovaTutti(Pageable pageable) {
		Page<Volo> listaVoli = voloService.getAll(pageable);
		return new ResponseEntity<Page<Volo>>(listaVoli, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Volo> getById(@PathVariable Long id) {
		Volo volo = voloService.findById(id);
		return new ResponseEntity<Volo>(volo, HttpStatus.OK);
	}
}
