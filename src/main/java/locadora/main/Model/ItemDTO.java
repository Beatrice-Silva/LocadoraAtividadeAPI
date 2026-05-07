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

    private Integer iditem;
    private int idlocaul;
    private String nomeitem;
    private Double preco;
    private String colecao;

    public ItemDTO() {
    }

    public ItemDTO(Integer iditem, int idlocaul, String nomeitem, Double preco, String colecao) {
        this.iditem = iditem;
        this.idlocaul = idlocaul;
        this.nomeitem = nomeitem;
        this.preco = preco;
        this.colecao = colecao;
    }

    public Integer getIditem() {
        return iditem;
    }

    public void setIditem(Integer iditem) {
        this.iditem = iditem;
    }

    public int getIdlocaul() {
        return idlocaul;
    }

    public void setIdlocaul(int idlocaul) {
        this.idlocaul = idlocaul;
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
