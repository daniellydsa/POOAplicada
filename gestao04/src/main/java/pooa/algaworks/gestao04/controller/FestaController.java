package pooa.algaworks.gestao04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import pooa.algaworks.gestao04.models.FestaModel;
import pooa.algaworks.gestao04.repository.FestaRepository;

@Controller
public class FestaController {
    
    @Autowired
    FestaRepository festaTable;
    
    @GetMapping("/festas")
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("ListaFestas");
        mv.addObject("festas", festaTable.findAll());
        mv.addObject(new FestaModel());
        return mv;
    }
    
    @PostMapping("/festas")
    public String salvar(FestaModel fes) {
        this.festaTable.save(fes);
        return "redirect:/festas";
    }
}
