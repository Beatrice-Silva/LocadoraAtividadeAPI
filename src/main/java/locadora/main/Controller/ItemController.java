/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.main.Controller;
import locadora.main.Model.ItemDTO;
import locadora.main.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Aluno
 */
@RestController
@RequestMapping("/itens")
public class ItemController {
    
    @Autowired
    private ItemService service;
    
    @PostMapping("/adicionar")
    public String adicionar(@RequestBody ItemDTO item){
        service.adicionar(item);
        return "redirect:/funcionarios";
        
    }
    
}
