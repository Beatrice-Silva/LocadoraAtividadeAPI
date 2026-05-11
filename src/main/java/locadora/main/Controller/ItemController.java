/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.main.Controller;
import java.util.List;
import locadora.main.Model.ItemDTO;
import locadora.main.Model.LocalDTO;
import locadora.main.Service.ItemService;
import locadora.main.Service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Aluno
 */
@RestController
@RequestMapping("/api/itens")
public class ItemController {
    
    @Autowired
    private ItemService service;
    
    
    @Autowired
    private TokenService tokenService;
   
    
    @GetMapping
    public List<ItemDTO> lerTodosItens(@RequestHeader("Authorization") String auth){
        
        String token = auth.replace("Bearer ", "");
        tokenService.validarToken(token);
            return service.lerTodosItens();
        
    }
    
    @PostMapping("/adicionar")
    public String adicionar(@RequestHeader ("Authorization") String auth,@RequestBody ItemDTO item){
        
        String token = auth.replace("Bearer ", "");
        tokenService.validarToken(token);
        service.adicionar(item);
        return "redirect:/Itens";   
    
    }
   
    @DeleteMapping("/{id}")
    public String deletar(@RequestHeader ("Authorization") String auth, @PathVariable int id){
        
        String token = auth.replace("Bearer ", "");
        tokenService.validarToken(token);
        service.deletarItem(id);
        return "Item deletado com sucesso!";
    }

    
    
    
    
   
    
    
}
