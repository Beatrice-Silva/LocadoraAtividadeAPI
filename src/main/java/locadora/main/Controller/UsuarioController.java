/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.main.Controller;

import java.util.List;
import locadora.main.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Aluno
 */
@Controller
public class UsuarioController {
 
    @Autowired
    private UsuarioService service;
    
    @GetMapping("usuarios")
    public String getUsuarios(Model model) {
        List<UsuarioDTO> lista = service.lerTodos();
        model.addAtribute("lista",lista);
        return "usuarios";
    }
    
    
}
