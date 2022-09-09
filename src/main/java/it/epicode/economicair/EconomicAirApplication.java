package it.epicode.economicair;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.epicode.economicair.model.Aeroporto;
import it.epicode.economicair.util.MyCsvReader;

@SpringBootApplication
public class EconomicAirApplication {

	public static void main(String[] args) {
		SpringApplication.run(EconomicAirApplication.class, args);

		try {
			FileReader fileReader = new FileReader("src/main/resources/static/FileCSV.csv");
			List<Aeroporto> aeroporti = new ArrayList<>();
			aeroporti = MyCsvReader.read(fileReader);
			stampaAeroporti(aeroporti);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static void stampaAeroporti(List<Aeroporto> aeroporti) {
		for (Aeroporto aeroporto : aeroporti) {
			System.out.println(aeroporto);
		}
	}
}
