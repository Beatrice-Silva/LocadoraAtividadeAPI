/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.main.Service;

import java.util.Date;
import javax.crypto.SecretKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Responsável pela geração e validação de tokens JWT
 *
 * @author Aluno
 */
@Service
public class TokenService {
    
    @Value("${api.security.token.secret}") 
    private String secret;
    
    private SecretKey getSignKey(){
        byte[] keyBytes = Decoders.BASE64.decode(this.secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    
    public String gerarToken(){
    return Jwts.builder()
            .subject("iago.teste@teste.com")
            .issuedAt(new Date())
            .expiration(new Date (System.currentTimeMillis() +  300000))
            .signWith(getSignKey())
            .compact();
            }
    
    
    public boolean validarToken(String token){
        try{
            Jwts.parser()
                    .setSignKey(getSignKey())
                    .build()
                    .parse
                    ;
            
        }catch(JwtException | IllegalArgumentException e){
            return false;
        }
        
    }
}
