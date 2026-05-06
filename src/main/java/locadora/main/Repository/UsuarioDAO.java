/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.main.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locadora.main.Model.UsuarioDTO;

/**
 *
 * @author Aluno
 */
public class UsuarioDAO {
    
    public List<UsuarioDTO> lerTodos(){
        List<UsuarioDTO> dados = new ArrayList();
        try{
        
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = conn.prepareStatement("SELECT * FROM usuario");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                UsuarioDTO usuario = new UsuarioDTO();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                dados.add(usuario);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return dados;
        
    }
    
    
}
