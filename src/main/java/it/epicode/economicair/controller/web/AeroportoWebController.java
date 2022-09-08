package it.epicode.economicair.controller.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import it.epicode.economicair.model.Aeroporto;
import it.epicode.economicair.service.AeroportoService;

@Controller
@RequestMapping("/web/aeroporto")
public class AeroportoWebController {

	@Autowired
	private AeroportoService aeroportoService;
	
	@GetMapping("/mostraInserimento")
	public ModelAndView mostraInserimento() {
		return new ModelAndView("InserimentoAeroporto", "aeroporto", new Aeroporto());
	}
	
	@PostMapping("/inserisciAeroporto")
	public String submitAdd(@ModelAttribute("course") Aeroporto aeroporto, BindingResult result, ModelMap m) {
		aeroportoService.aggiungi(aeroporto);
		return "index";
	}
}
