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
      
    @Value("${api.security.token.secret}")
    private String secret;
  
    private SecretKey getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(this.secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    
    public List<UsuarioDTO> listar(){
        return repository.lerTodos();
    }
    
    //public void salvar(UsuarioDTO usuario){
    //    repository.cadastrar(usuario);
    //}
    
    public UsuarioDTO autenticar(String email, String senha){
        return repository.logar(email, senha);
    }
    
    public void deletarUsuario(int id){
        repository.deletar(id);
    }
    
    public String gerarTokenCadastrar(UsuarioDTO usuario) {
        return Jwts.builder()
                .subject("locadora")
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 7200000))
                .signWith(getSignKey())
                .compact();
        //repository.cadastrar(usuario);
        
    }
    
       public Claims extrairClaims(String token) {
        return Jwts.parser()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    
    
    
}
