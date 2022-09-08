package it.epicode.economicair.economicair;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.epicode.economicair.model.Aeroporto;
import it.epicode.economicair.service.AeroportoService;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
class AeroportoControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	AeroportoService aeroportoService;
	
	@BeforeEach
	public void initAeroporto() {
		Aeroporto aeroporto = new Aeroporto();

		aeroporto.setCitta("Milano");
		aeroporto.setCodice("MLN");
		aeroporto.setNazione("Italia");
		aeroporto.setNome("Linate");
		
		aeroportoService.aggiungi(aeroporto);
	}

	@Test
	/*
	 * @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
	 */
	public void getAllAeroporti() throws Exception {
		this.mockMvc.perform(get("/api/aeroporto/all")).andExpect(status().isOk());
	}

	@Test
	public void insertAeroporto() throws Exception {
		Aeroporto aeroporto = new Aeroporto();

		aeroporto.setCitta("Milano");
		aeroporto.setCodice("MLN");
		aeroporto.setNazione("Italia");
		aeroporto.setNome("Linate");

		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(aeroporto);

		MvcResult result = mockMvc
				.perform(post("/api/aeroporto/aggiungi").contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isCreated()).andExpect(content().json("{'citta':'Milano'}")).andReturn();

		log.info(json);

	}
	
	@Test
	public void deleteAeroporto() throws Exception {
		this.mockMvc.perform(delete("/api/aeroporto/elimina/1")).andExpect(status().isOk());
	}
}
