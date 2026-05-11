/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.main.Controller;


import java.util.List;
import locadora.main.Model.LocalDTO;
import locadora.main.Service.LocalService;
import locadora.main.Service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/locais")
public class LocalController {
    
    @Autowired
    private LocalService service;
    
    @Autowired
    private TokenService tokenService;
   
    
    @GetMapping("/prateleiras")
    public List<LocalDTO> lerTodos(
            @RequestHeader("Authorization") String auth){
        
        String token = auth.replace("Bearer ", "");
        tokenService.validarToken(token);
            return service.lerTodos();
    }
    
   
    
}
