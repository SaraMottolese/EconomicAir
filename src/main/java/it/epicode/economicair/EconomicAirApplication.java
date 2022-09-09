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

	}
}
