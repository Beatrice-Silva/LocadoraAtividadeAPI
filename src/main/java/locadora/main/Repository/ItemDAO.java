/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.main.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import locadora.main.Model.ItemDTO;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Aluno
 */
@Repository
public class ItemDAO {
 
    public void adicionar(ItemDTO item){
        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement("INSERT INTO ite (nomeitem, idlocal, preco, colecao)"
                    + "VALUES (?,?,?,?)");
            
            stmt.setString(1, item.getNomeitem());
            stmt.setDouble(2, item.getPreco());
            stmt.setString(3, item.getColecao());
            
            stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    
}
