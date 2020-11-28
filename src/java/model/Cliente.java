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
     
    public void Observar(Observable pedido) {
        pedido.addObserver(this);
    }
    
    public Cliente(){
        
    }
    
    public Cliente(String cpf){
        this.cpf = cpf;
    
    }
    
    @Override
    public void update(Observable o, Object arg) {
        
            if (o instanceof Pedido) {
            Pedido pedido = (Pedido) o;
            String msg = "Olá, " + getNome() + ", o estado do seu pedido mudou. ";
            System.out.println(msg);

            String msgEmail = "<h2 style='text-align:center; padding: 50px 20px'>Olá, " + getNome() + " </h2>";
            msgEmail += "<h3 style='text-align:center;'>O estado do seu pedido mudou.</h3><br/>";
            msgEmail += "<h2 style='text-align:center;'>" + pedido.getStatus().getMensagem() + "</h2>";
            //Email email = new Email(this.getEmail(), "Status do Pedido " + pedido.getId(), msgEmail);
           // email.enviarEmail();
    
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