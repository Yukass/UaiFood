/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author braia
 */
@Entity
public class Combo implements Serializable {
 private static final long serialVerionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private ArrayList<Item_Pedido> alimento;
    private Long idLoja;
    
    public Combo(){}
    
    public Combo(String nome, Long idLoja, ArrayList<Item_Pedido> alimento) {
        this.nome = nome;
        this.idLoja = idLoja;
        this.alimento = alimento;
    }

    
    public ArrayList<Item_Pedido> getAlimento() {
        return alimento;
    }

    public void setAlimento(ArrayList<Item_Pedido> alimento) {
        this.alimento = alimento;
    }

    public ArrayList<Item_Pedido> getItem_Pedido() {
        return alimento;
    }

    public void setItem_Pedido(ArrayList<Item_Pedido> alimento) {
        this.alimento = alimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getIdLoja() {
        return idLoja;
    }

    public void setIdLoja(Long idLoja) {
        this.idLoja = idLoja;
    }
    
    
}
