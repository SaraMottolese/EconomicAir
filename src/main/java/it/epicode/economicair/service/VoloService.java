package it.epicode.economicair.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.epicode.economicair.model.Prenotazione;
import it.epicode.economicair.model.Volo;
import it.epicode.economicair.repository.VoloRepository;

@Service
public class VoloService {

	@Autowired
	private VoloRepository voloRepository;

	public Volo aggiungi(Volo v) {
		return voloRepository.save(v);
	}

	public void elimina(Long id) {
		voloRepository.deleteById(id);
	}

	public Page<Volo> getAll(Pageable pageable) {
		return voloRepository.findAll(pageable);
	}

	public Volo findById(Long id) {
		Optional<Volo> voloResult = voloRepository.findById(id);

		if (voloResult.isPresent()) {
			return voloResult.get();
		} else
			return null;
	}

	public Volo aggiornaVolo(Volo v, Long id) {
		Optional<Volo> voloResult = voloRepository.findById(id);

		if (voloResult.isPresent()) { 
			Volo volo = new Volo();
			volo.setId(voloResult.get().getId());
			volo.setAeroportoArrivo(v.getAeroportoArrivo());
			volo.setAeroportoPartenza(v.getAeroportoPartenza());
			volo.setDataArrivo(v.getDataArrivo());
			volo.setDataPartenza(v.getDataPartenza());
			return voloRepository.save(volo);
		} else
			return null;

	}
}
