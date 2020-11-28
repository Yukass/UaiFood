/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;


/**
 *
 * @author Yukas
 */
@Entity
public class Loja extends Usuario implements Serializable {

    private String cnpj;
 
    public Loja(){}
    
    public Loja(String cnpj){
        this.cnpj = cnpj;
    }
    
      public Loja(Long id){
        super(id);
    }

    public String getCnpj() {
        return cnpj;
    }

    public Loja setCnpj(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

}