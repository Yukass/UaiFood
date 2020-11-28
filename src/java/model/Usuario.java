package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
public abstract class Usuario implements Serializable{
    private static final long serialVerionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private String senha;
    private String cep;
    private String logradouro;
    private String bairro;
    private String numero;
    private String complemento;
    private String cidade;
    private String estado;
    
     public Usuario(){
        
    }
    
     public Usuario(Long id){
        this.id = id;
    }
    
    public Long getId() {
        return id;
    }

    public Usuario setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Usuario setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getTelefone() {
        return telefone;
    }

    public Usuario setTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Usuario setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getSenha() {
        return senha;
    }

    public Usuario setSenha(String senha) {
        this.senha = senha;
        return this;
    }

    public String getCep() {
        return cep;
    }

    public Usuario setCep(String cep) {
        this.cep = cep;
        return this;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public Usuario setLogradouro(String logradouro) {
        this.logradouro = logradouro;
        return this;
    }

    public String getBairro() {
        return bairro;
    }

    public Usuario setBairro(String bairro) {
        this.bairro = bairro;
        return this;
    }

    public String getComplemento() {
        return complemento;
    }

    public Usuario setComplemento(String complemento) {
        this.complemento = complemento;
        return this;
    }

    public String getCidade() {
        return cidade;
    }

    public Usuario setCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public String getEstado() {
        return estado;
    }

    public Usuario setEstado(String estado) {
        this.estado = estado;
        return this;
    }

    public String getNumero() {
        return numero;
    }

    public Usuario setNumero(String numero) {
        this.numero = numero;
        return this;
    }

}