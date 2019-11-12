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
import pooa.algaworks.gestao04.models.Festa;
import pooa.algaworks.gestao04.repository.FestaRepository;

@Controller
public class FestaController {
    
    @Autowired
    FestaRepository festaTable;
    
    @GetMapping("/festas")
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("ListaFestas");
        mv.addObject("festas", festaTable.findAll());
        mv.addObject("festa", new Festa());
        return mv;
    }
    
    @PostMapping("/festas")
    public String salvar(Festa fes) {
        this.festaTable.save(fes);
        return "redirect:/festas";
    }
    
    @RequestMapping(path = "/festas/excluir/{id}")
    public String excluir(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response) {
        this.festaTable.deleteById(id);
        return "redirect:/festas";
    }
    
    @RequestMapping(path = "/festas/alterar/{id}")
    public ModelAndView alterar(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView("ListaFestas");
        mv.addObject("festas", festaTable.findAll());
        mv.addObject("festa", festaTable.findById(id));
        return mv;
    }
}
