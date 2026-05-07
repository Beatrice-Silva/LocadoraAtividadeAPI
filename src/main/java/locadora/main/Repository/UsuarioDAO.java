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
import org.springframework.stereotype.Repository;

/**
 *
 * @author Aluno
 */
@Repository
public class UsuarioDAO {
    
    public List<UsuarioDTO> lerTodos() {
        List<UsuarioDTO> dados = new ArrayList<>();
        try (Connection conn = Conexao.conectar()) {
            String sql = "SELECT * FROM usuario";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                UsuarioDTO user = new UsuarioDTO(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("senha")
                );
                dados.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dados;
    }
    
    public void cadastrar(UsuarioDTO user) {
        try (Connection conn = Conexao.conectar()) {
            String sql = "INSERT INTO usuario (nome, email, senha) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getSenha());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public UsuarioDTO logar(String email, String senha) {
        try (Connection conn = Conexao.conectar()) {
            String sql = "SELECT * FROM usuario WHERE email = ? AND senha = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new UsuarioDTO(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("senha")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; 
    }
    
    
}
