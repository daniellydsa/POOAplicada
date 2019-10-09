package pooa.algaworks.gestao04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import pooa.algaworks.gestao04.repository.Convidados;

@Controller
public class ConvidadosController {
    
    @Autowired
    Convidados convidadosTable;
    
    @GetMapping("/convidados")
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("ListaConvidados.html");
        mv.addObject("convidados",convidadosTable.findAll());
        return mv;
    }
    
}
