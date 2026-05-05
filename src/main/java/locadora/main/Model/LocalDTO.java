/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.main.Model;

/**
 *
 * @author Aluno
 */
public class LocalDTO {
    
    private int idlocaul;
    private int iditem;
    private String nomeitem;
    private int capacmax;

    public LocalDTO() {
    }

    public LocalDTO(int idlocaul, int iditem, String nomeitem, int capacmax) {
        this.idlocaul = idlocaul;
        this.iditem = iditem;
        this.nomeitem = nomeitem;
        this.capacmax = capacmax;
    }

    public int getIdlocaul() {
        return idlocaul;
    }

    public void setIdlocaul(int idlocaul) {
        this.idlocaul = idlocaul;
    }

    public int getIditem() {
        return iditem;
    }

    public void setIditem(int iditem) {
        this.iditem = iditem;
    }

    public String getNomeitem() {
        return nomeitem;
    }

    public void setNomeitem(String nomeitem) {
        this.nomeitem = nomeitem;
    }

    public int getCapacmax() {
        return capacmax;
    }

    public void setCapacmax(int capacmax) {
        this.capacmax = capacmax;
    }
    
    
    
}
