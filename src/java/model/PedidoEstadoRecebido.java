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
public class PedidoEstadoRecebido extends PedidoEstado{

    public PedidoEstadoRecebido(){
        this.nome = "Recebido";
        this.mensagem = "Pedido recebido";      
    }

    public boolean preparar(Pedido pedido) {
        pedido.setStatus(new PedidoEstadoPreparo());
        return true;
    }


    public boolean cancelar(Pedido pedido) {
        pedido.setStatus(new PedidoEstadoCancelado());
        return true;
    }

    
}
