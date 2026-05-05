/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.main.Controller;

import ch.qos.logback.core.model.Model;
import java.util.List;
import locadora.main.Model.LocalDTO;
import locadora.main.Service.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Aluno
 */
@Controller
public class LocalController {
    
    @Autowired
    private LocalService service;
    
    @GetMapping("/prateleiras")
    public String getLocal(Model model){
        List<LocalDTO> lista = service.lerTodos();
        model.addAttribute("lista", lista);
        return "local";
        
    }
    
}
