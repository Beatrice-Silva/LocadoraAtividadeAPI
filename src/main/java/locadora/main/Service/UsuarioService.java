/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.main.Service;

import java.util.List;
import locadora.main.Model.UsuarioDTO;
import locadora.main.Repository.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Aluno
 */
@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioDAO repository;
    
    public List<UsuarioDTO> listar(){
        return repository.lerTodos();
    }
    
    public void salvar(UsuarioDTO user){
       repository.cadastrar(user);
    }
    
    
    public UsuarioDTO autenticar(String email, String senha){
        return repository.logar(email, senha);
    }
    
    
    
    
}
