/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Yukas
 */
public abstract class PedidoEstado implements Serializable {    
    protected String nome;
    protected String mensagem;
   
    
    public boolean receber(Pedido pedido){
        return false;
    }
    
    public boolean preparar(Pedido pedido){
        return false;
    }
    
    public boolean despachar(Pedido pedido){
        return false;
    }
    
    public boolean entregar(Pedido pedido){
        return false;
    }
    
    public boolean devolver(Pedido pedido){
        return false;
    }
    
    public boolean cancelar(Pedido pedido){
        return false;
    }
    
    public boolean finalizar(Pedido pedido){
        return false;
    }
    
    public String getNome(){
        return nome;
    }
    
    public String getMensagem(){
        return mensagem;
    }
}
