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
public class PedidoEstadoCancelado extends PedidoEstado{

    public PedidoEstadoCancelado(){
        this.nome = "Cancelado";
        this.mensagem = "Pedido foi cancelado";      
    }

    public boolean finalizar(Pedido pedido){
        pedido.setStatus(new PedidoEstadoFinalizado());
        return true;
    }
    
}
