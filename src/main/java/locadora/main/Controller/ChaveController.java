/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.main.Controller;

import io.jsonwebtoken.Claims;
import locadora.main.Model.LogarDTO;
import locadora.main.Model.UsuarioDTO;
import locadora.main.Service.TokenService;
import locadora.main.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("api/chave")
public class ChaveController {
    
    @Autowired
    private TokenService service;
    
    @Autowired
    private UsuarioService serviceUsuario;
    
    
    @PostMapping("/logar")
    public String login(@RequestBody LogarDTO user) {
        LogarDTO usuarioLogado = serviceUsuario.autenticar(user.getEmail(), user.getSenha());
        if(user.getEmail() != null){
           //return service.gerarToken(usuario.getEmail();
        }
        return "E-mail ou senha incorretos";
    }
    

    @PostMapping("/cadastrar")
    public String cadastrar(@RequestBody UsuarioDTO usuario) {
        serviceUsuario.cadastrar(usuario);
        return "Usuario cadastrado com sucesso";
    }
    
    
    @PostMapping("/validar-token")
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
   
    /*
    @DeleteMapping("/{id}")
    public String deletar(@PathVariable int id){
        serviceUsuario.deletarUsuario(id);
        return "Usuário deletado com sucesso!";
    }
    */
    
}

