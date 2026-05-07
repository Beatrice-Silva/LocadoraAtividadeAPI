/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.main.Controller;

import java.util.List;
import locadora.main.Model.UsuarioDTO;
import locadora.main.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Aluno
 */

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
 
    @Autowired
    private UsuarioService service;
    
    @GetMapping
    public List<UsuarioDTO> getUsuarios() {
        return service.listar();
    } 
    
    @PostMapping("/cadastrar")
    public String cadastrar(@RequestBody UsuarioDTO user) {
        service.salvar(user);
        return "Usuario cadastrado com sucesso";
    }
  
    @PostMapping("/login")
    public Object login(@RequestBody UsuarioDTO user) {
        UsuarioDTO usuarioLogado = service.autenticar(user.getEmail(), user.getSenha());
        if(user != null){
            return user;
        }
        return "E-mail ou senha incorretos";
    }
    
    
}
