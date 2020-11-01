package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;

@Entity
public class Cliente extends Usuario implements Serializable {
    
    private String cpf;
       
    public Cliente(){
    
    }
    
    public Cliente(String nome,String cpf, String email, String senha, String telefone, String cep, String logradouro, String bairro,String numero, String complemento, String cidade, String estado) {
        super(nome, email, senha, telefone, cep, logradouro, bairro, numero, complemento, cidade, estado);
        this.cpf = cpf;
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
