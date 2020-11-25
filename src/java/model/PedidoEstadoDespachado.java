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
public class PedidoEstadoDespachado extends PedidoEstado{

    public PedidoEstadoDespachado(){
        this.nome = "Despachado";
        this.mensagem = "Pedido foi despachado";      
    }

    public boolean entregar(Pedido pedido) {
        pedido.setStatus(new PedidoEstadoEntregue());
        return true;
    }


    public boolean cancelar(Pedido pedido) {
        pedido.setStatus(new PedidoEstadoCancelado());
        return true;
    }

    
    
}
