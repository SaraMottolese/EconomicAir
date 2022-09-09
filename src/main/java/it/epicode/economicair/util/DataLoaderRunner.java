package it.epicode.economicair.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import it.epicode.economicair.model.Aeroporto;
import it.epicode.economicair.service.AeroportoService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class DataLoaderRunner implements CommandLineRunner {
	
	@Autowired
	private AeroportoService aeroportoService;
	
	@Value("${economicair.csvpath}")
	private String csvPath; 

	@Override
	public void run(String... args) throws Exception {
		log.info("caricamento dati da CSV: " + csvPath);
		try {
			FileReader fileReader = new FileReader(csvPath);
			List<Aeroporto> aeroporti = new ArrayList<>();
			aeroporti = MyCsvReader.read(fileReader);
			stampaAeroporti(aeroporti);

		} catch (FileNotFoundException e) {
			log.error("file al path " + csvPath + " non trovato");
			e.printStackTrace();
		} catch (IOException e) {
			log.error("IOException");
			e.printStackTrace();
		}
		log.info("caricamento da CSV completato");
	}

	private void stampaAeroporti(List<Aeroporto> aeroporti) {
		for (Aeroporto aeroporto : aeroporti) {
			aeroportoService.aggiungi(aeroporto);
			log.info(aeroporto + " inserito correttamente");
			
		}
	}

}
