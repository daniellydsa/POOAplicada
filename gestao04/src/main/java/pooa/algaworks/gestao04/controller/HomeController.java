package pooa.algaworks.gestao04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {
	@GetMapping("")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("Home.html");
		return mv;
	}
	
	@GetMapping("/localizacao")
	public ModelAndView localizacao() {
		ModelAndView mv = new ModelAndView("Localizacao.html");
		return mv;
	}
}
