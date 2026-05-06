/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.main.Controller;

import locadora.main.Model.ItemDTO;
import locadora.main.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Aluno
 */
@Controller
public class ItemController {
    
    @Autowired
    private ItemService service;
    
    @PostMapping("/adicionar")
    public String adicionar(@ModelAttribute ItemDTO item){
        service.adicionar(item);
        return "redirect:/funcionarios";
        
    }
    
}
