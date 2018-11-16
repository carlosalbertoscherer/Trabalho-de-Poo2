/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author carlo
 */
public class CaixaClasse {

    CaixaClasse(int aInt, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getSaldo_total() {
        return saldo_total;
    }

    public void setSaldo_total(float saldo_total) {
        this.saldo_total = saldo_total;
    }
    private int id;
    private String descricao;
    private float saldo_total;
    
}
