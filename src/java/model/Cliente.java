/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.persistence.Entity;

/**
 *
 * @author Yukas
 */
@Entity
public class Cliente extends Usuario implements Serializable, Observer {
    
    private String cpf;
       
    public Cliente(){
    
    }
    
    public Cliente(String nome,String cpf, String email, String senha, String telefone, String cep, String logradouro, String bairro,String numero, String complemento, String cidade, String estado) {
        super(nome, email, senha, telefone, cep, logradouro, bairro, numero, complemento, cidade, estado);
        this.cpf = cpf;
    }
    
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Pedido) {
            Pedido pedido = (Pedido) o;
            System.out.println("Atenção " + this.getNome()
                    + ", o seu Pedido mudou de estado para "
                    + pedido.getStatus().getNome());
        }

    }
    
    public Cliente(Long id){
        super(id);
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
}