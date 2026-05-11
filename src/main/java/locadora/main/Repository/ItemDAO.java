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
import locadora.main.Model.ItemDTO;
import locadora.main.Model.LocalDTO;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Aluno
 */
@Repository
public class ItemDAO {
 
    
    public List<ItemDTO> lerTodosItens(){
    List<ItemDTO> dados = new ArrayList();
    try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conn.prepareStatement("SELECT * FROM locaul");
            rs = stmt.executeQuery();
        
            while(rs.next()){
                ItemDTO item = new ItemDTO();
                item.setIditem(rs.getInt("iditem"));
                item.setIdlocaul(rs.getInt("idlocaul"));
                item.setNomeitem(rs.getString("nomeitem"));
                item.setPreco(rs.getDouble("preco"));
                item.setColecao(rs.getString("solecao"));
                dados.add(item);
            }
            
    }catch(SQLException e){
        e.printStackTrace();
    }
    return dados;
    }
    
    
    public void adicionar(ItemDTO item){
        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement("INSERT INTO itens (nomeitem, idlocal, preco, colecao)"
                    + "VALUES (?,?,?,?)");
            
            stmt.setString(1, item.getNomeitem());
            stmt.setInt(2, item.getIdlocaul());
            stmt.setDouble(3, item.getPreco());
            stmt.setString(4, item.getColecao());
            
            stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
        
    public void deletar(int id){
        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM item WHERE iditem = ?");
            stmt.setInt(1, id);
            
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        }catch(SQLException e ){
        e.printStackTrace();
        }
    }
    
    
}
