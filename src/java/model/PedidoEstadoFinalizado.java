/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Yukas
 */
public class PedidoEstadoFinalizado extends PedidoEstado{
    
    public PedidoEstadoFinalizado(){
        this.nome = "Finalizado";
        this.mensagem = "Pedido finalizado";      
    }
    
}
