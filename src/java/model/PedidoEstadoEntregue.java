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
public class PedidoEstadoEntregue extends PedidoEstado{

    public PedidoEstadoEntregue(){
        this.nome = "Entregue";
        this.mensagem = "Pedido entregue";      
    }

    public boolean devolver(Pedido pedido) {
        pedido.setStatus(new PedidoEstadoDevolvido());
        return true;
    }

    public boolean cancelar(Pedido pedido) {
        pedido.setStatus(new PedidoEstadoCancelado());
        return true;
    }
    
    public boolean finalizar(Pedido pedido){
        pedido.setStatus(new PedidoEstadoFinalizado());
        return true;
    }
    
    
}
