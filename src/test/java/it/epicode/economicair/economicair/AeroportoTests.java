package it.epicode.economicair.economicair;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import it.epicode.economicair.model.Aeroporto;
import it.epicode.economicair.service.AeroportoService;

@SpringBootTest
public class AeroportoTests {

	@Autowired
	private AeroportoService aeroportoService;
	
	@Test
	void test() {
		Aeroporto aeroporto = new Aeroporto();
		aeroporto.setCitta("Milano");
		aeroporto.setCodice("MLN");
		aeroporto.setNazione("Italia");
		aeroporto.setNome("Linate");
		
		aeroportoService.aggiungi(aeroporto);
		
		assertEquals(aeroportoService.findById(1L).getCodice(), "MLN");
	}

}
