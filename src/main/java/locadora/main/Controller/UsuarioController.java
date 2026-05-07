/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.main.Controller;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.util.List;
import javax.crypto.SecretKey;
import locadora.main.Model.UsuarioDTO;
import locadora.main.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Aluno
 */

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
 
    @Autowired
    private UsuarioService service;
    private String secret;
    
    @GetMapping
    public List<UsuarioDTO> getUsuarios() {
        return service.listar();
    }
    
    @PostMapping("/cadastrar")
    public String cadastrar(@RequestBody UsuarioDTO usuario) {
        service.salvar(usuario);
        return "Usuario cadastrado com sucesso";
    }
    
    @DeleteMapping("/{id}")
    public String deletar(@PathVariable int id){
        service.deletarUsuario(id);
        return "Usuário deletado com sucesso!";
    }
    
    @PostMapping("/login")
    public Object login(@RequestBody UsuarioDTO user) {
        UsuarioDTO usuarioLogado = service.autenticar(user.getEmail(), user.getSenha());
        
        
        if(user != null){
           return user;
        }
        return "E-mail ou senha incorretos";
    }
    
    @GetMapping("/tokengerado")
    public String testeToken() {
        return service.gerarToken();
    }
    
    @PostMapping("/validartoken")
    public String validarToken(@RequestParam String token) {
        
        if (service.validarToken(token)) {
        
            Claims claims = service.extrairClaims(token);
            return "Token válido! Subject: " + claims.getSubject() + 
                   ", Emitido em: " + claims.getIssuedAt() + 
                   ", Expira em: " + claims.getExpiration();
        } else {
            return "Token inválido ou expirado!";
        }
    }
    
    
}
