/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.main.Service;


import java.util.List;
import locadora.main.Model.ItemDTO;
import locadora.main.Repository.ItemDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Aluno
 */
@Service
public class ItemService {
 
    @Autowired
    private ItemDAO repository;
    
    public void adicionar(ItemDTO item){
        repository.adicionar(item);
    }
    
    public List<ItemDTO> lerTodosItens(){
        return repository.lerTodosItens();
    }
    
    public void deletarItem(int id){
        repository.deletar(id);
    }
    
    
    
    
    
}
