/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.main.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.util.Date;
import java.util.List;
import javax.crypto.SecretKey;
import locadora.main.Model.LogarDTO;
import locadora.main.Model.UsuarioDTO;
import locadora.main.Repository.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 * @author Aluno
 */
@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioDAO repository;
 
    public void cadastrar(UsuarioDTO usuario){
        repository.cadastrar(usuario);
    }
    
    public LogarDTO autenticar(String email, String senha){
        return repository.logar(email, senha);
    }
    
    /*
    public List<UsuarioDTO> listar(){
        return repository.lerTodos();
    }
    */
    /*
    public void deletarUsuario(int id){
        repository.deletar(id);
    }
    */
    
    
    
}
