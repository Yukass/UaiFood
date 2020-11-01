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
    
    public Loja(String nome, String cnpj, String email,
            String senha, String telefone, String cep, String logradouro,
            String bairro, String numero,String complemento, String cidade, String estado) {
        super(nome, email, senha, telefone, cep, logradouro, bairro, numero, complemento, cidade, estado);

        this.cnpj = cnpj;
    }
    
      public Loja(Long id){
        super(id);
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

}
