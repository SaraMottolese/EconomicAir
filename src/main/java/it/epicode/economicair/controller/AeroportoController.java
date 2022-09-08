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

import it.epicode.economicair.model.Aeroporto;
import it.epicode.economicair.service.AeroportoService;

@RestController
@RequestMapping("/api/aeroporto")
public class AeroportoController {
	
	@Autowired
	private AeroportoService aeroportoService;
	
	@PostMapping("/aggiungi")
	public ResponseEntity<Aeroporto> aggiungi(@RequestBody Aeroporto aeroporto){
		Aeroporto aggiungiAeroporto= aeroportoService.aggiungi(aeroporto);
		return new ResponseEntity<Aeroporto>(aggiungiAeroporto, HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/elimina/{id}")
	public ResponseEntity<String> elimina(@PathVariable Long id){
		aeroportoService.elimina(id);
		return new ResponseEntity<String>("Aeroporto eliminato correttamente", HttpStatus.OK);
	}
	
	@PutMapping("/aggiorna/{id}")
	public ResponseEntity<Aeroporto> aggiorna (@RequestBody Aeroporto aeroporto, @PathVariable Long id){
		Aeroporto updateAeroporto= aeroportoService.aggiornaAeroporto(aeroporto, id);
		return new ResponseEntity<Aeroporto>(updateAeroporto, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<Page<Aeroporto>> trovaTutti(Pageable pageable){
		Page<Aeroporto>listaAeroporti= aeroportoService.getAll(pageable);
		return new ResponseEntity<Page<Aeroporto>>(listaAeroporti, HttpStatus.OK);
	}
	

}
