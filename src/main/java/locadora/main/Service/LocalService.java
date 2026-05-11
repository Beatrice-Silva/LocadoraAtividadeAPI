/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.main.Service;

import java.util.List;
import locadora.main.Model.LocalDTO;
import locadora.main.Repository.LocalDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author Aluno
 */
@Service
public class LocalService {

    @Autowired
    private LocalDAO repository;
    
    public List<LocalDTO> lerTodos(){
        return repository.lerTodos();
    }
    
    
    
}
