/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.main.Controller;


import java.util.List;
import locadora.main.Model.LocalDTO;
import locadora.main.Service.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/locais")
public class LocalController {
    
    @Autowired
    private LocalService service;
    
    @GetMapping("/prateleiras")
    public List<LocalDTO> getLocal(){
        return service.lerTodos();
    }
    
}
