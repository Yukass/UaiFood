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
public class PedidoEstadoPreparo extends PedidoEstado{
    
    public PedidoEstadoPreparo(){
        this.nome = "Preparo";
        this.mensagem = "Pedido sendo preparado";      
    }

    public boolean despachar(Pedido pedido) {
        pedido.setStatus(new PedidoEstadoDespachado());
        return true;
    }

    public boolean cancelar(Pedido pedido) {
        pedido.setStatus(new PedidoEstadoCancelado());
        return true;
    }

    
}
