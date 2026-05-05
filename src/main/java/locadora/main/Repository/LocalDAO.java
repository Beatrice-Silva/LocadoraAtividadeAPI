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
import locadora.main.Model.LocalDTO;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Aluno
 */
@Repository
public class LocalDAO {
    
    public List<LocalDTO> lerTodos(){
    List<LocalDTO> dados = new ArrayList();
    try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conn.prepareStatement("SELECT * FROM locaul");
            rs = stmt.executeQuery();
        
            while(rs.next()){
                LocalDTO local = new LocalDTO();
                local.setIdlocaul(rs.getInt("idlocaul"));
                local.setIditem(rs.getInt("iditem"));
                local.setNomeitem(rs.getString("nomeitem"));
                local.setCapacmax(rs.getInt("capacmax"));
                dados.add(local);
            }
            
    }catch(SQLException e){
        e.printStackTrace();
    }
        
    return dados;
    }
    
    
}
