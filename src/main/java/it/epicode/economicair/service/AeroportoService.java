package it.epicode.economicair.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.epicode.economicair.model.Aeroporto;
import it.epicode.economicair.model.Prenotazione;
import it.epicode.economicair.repository.AeroportoRepository;

@Service
public class AeroportoService {

	@Autowired
	private AeroportoRepository aeroportoRepository;
	
	public Aeroporto aggiungi(Aeroporto a) {
		return aeroportoRepository.save(a);
	}

	public void elimina(Long id) {
		aeroportoRepository.deleteById(id);
	}

	public Page<Aeroporto> getAll(Pageable pageable) {
		return aeroportoRepository.findAll(pageable);
	}

	public Aeroporto findById(Long id) {
		Optional<Aeroporto> aeroportoResult = aeroportoRepository.findById(id);

		if (aeroportoResult.isPresent()) {
			return aeroportoResult.get();
		} else
			return null;
	}

	public Aeroporto aggiornaAeroporto(Aeroporto a, Long id) {
		Optional<Aeroporto> aeroportoResult = aeroportoRepository.findById(id);

		if (aeroportoResult.isPresent()) {
			Aeroporto aeroporto = new Aeroporto();
			aeroporto.setCitta(a.getCitta());
			aeroporto.setCodice(a.getCodice());
			aeroporto.setNazione(a.getNazione());
			aeroporto.setNome(a.getNome());
			return aeroportoRepository.save(aeroporto);
		} else
			return null;

	}
}
