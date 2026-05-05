/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.main.Model;

/**
 *
 * @author Aluno
 */
public class ItemDTO {

    private int iditem;
    private int idlocal;
    private String nomeitem;
    private Double preco;
    private String colecao;

    public ItemDTO() {
    }

    public ItemDTO(int iditem, int idlocal, String nomeitem, Double preco, String colecao) {
        this.iditem = iditem;
        this.idlocal = idlocal;
        this.nomeitem = nomeitem;
        this.preco = preco;
        this.colecao = colecao;
    }

    public int getIditem() {
        return iditem;
    }

    public void setIditem(int iditem) {
        this.iditem = iditem;
    }

    public int getIdlocal() {
        return idlocal;
    }

    public void setIdlocal(int idlocal) {
        this.idlocal = idlocal;
    }

    public String getNomeitem() {
        return nomeitem;
    }

    public void setNomeitem(String nomeitem) {
        this.nomeitem = nomeitem;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getColecao() {
        return colecao;
    }

    public void setColecao(String colecao) {
        this.colecao = colecao;
    }

    
}
