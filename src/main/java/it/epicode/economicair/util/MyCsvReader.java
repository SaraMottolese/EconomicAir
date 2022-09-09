package it.epicode.economicair.util;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

import it.epicode.economicair.model.Aeroporto;

public abstract class MyCsvReader {

	public static List<Aeroporto> read(FileReader file) throws IOException {
		CSVReader reader = new CSVReader(file, ',', '\'', 1);

		List<Aeroporto> aeroporti = new ArrayList<>();

		String[] record = null;

		while ((record = reader.readNext()) != null) {
			Aeroporto aeroporto = new Aeroporto();
			aeroporto.setId(Long.parseLong(record[0]));
			aeroporto.setNome(record[1]);
			aeroporto.setCitta(record[2]);
			aeroporto.setNazione(record[3]);
			aeroporto.setCodice(record[4]);
			aeroporti.add(aeroporto);
		}

		reader.close();

		return aeroporti;

	}
}
