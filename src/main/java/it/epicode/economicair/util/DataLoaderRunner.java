package it.epicode.economicair.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import it.epicode.economicair.model.Aeroporto;
import it.epicode.economicair.model.Role;
import it.epicode.economicair.model.Roles;
import it.epicode.economicair.model.User;
import it.epicode.economicair.repository.RoleRepository;
import it.epicode.economicair.repository.UserRepository;
import it.epicode.economicair.service.AeroportoService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class DataLoaderRunner implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

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
		aggiungiUtente();
	}

	private void stampaAeroporti(List<Aeroporto> aeroporti) {
		for (Aeroporto aeroporto : aeroporti) {
			aeroportoService.aggiungi(aeroporto);
			log.info(aeroporto + " inserito correttamente");

		}
	}

	private void aggiungiUtente() {
		BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
		Role role = new Role();
		role.setRoleName(Roles.ROLE_ADMIN);
		User user = new User();
		Set<Role> roles = new HashSet<>();
		roles.add(role);
		user.setUsername("admin");
		user.setPassword(bCrypt.encode("admin"));
		user.setEmail("admin@domain.com");
		user.setRoles(roles);
		user.setActive(true);
		//roleRepository.save(role);
		userRepository.save(user);

	}

}
