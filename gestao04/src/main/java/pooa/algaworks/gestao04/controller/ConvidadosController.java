package pooa.algaworks.gestao04.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pooa.algaworks.gestao04.models.Convidado;
import pooa.algaworks.gestao04.repository.Convidados;

@Controller
public class ConvidadosController {
    
    @Autowired
    Convidados convidadosTable;
    
    @GetMapping("/convidados")
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("ListaConvidados.html");
        mv.addObject("convidados",convidadosTable.findAll());
        mv.addObject(new Convidado());
        return mv;
    }
    
    @PostMapping("/convidados")
    public String salvar(Convidado c) {
        this.convidadosTable.save(c);
        return "redirect:/convidados";
    }
    
    @RequestMapping(path = "/convidados/excluir/{id}")
    public String excluir(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response) {		
        this.convidadosTable.deleteById(id);	
        return "redirect:/convidados";
    }
    
    @RequestMapping(path ="/convidados/alterar/{id}")
    public ModelAndView alterar(@PathVariable Long id, HttpServletRequest request,  HttpServletResponse response) {
	ModelAndView mv = new ModelAndView("ListaConvidados");
	mv.addObject("convidados",convidadosTable.findAll());
        mv.addObject("convidado", convidadosTable.findById(id));
        return mv;
    }
    
}
