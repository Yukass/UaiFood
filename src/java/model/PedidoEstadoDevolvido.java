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
public class PedidoEstadoDevolvido extends PedidoEstado{

    public PedidoEstadoDevolvido(){
        this.nome = "Devolvido";
        this.mensagem = "Pedido foi devolvido";      
    }


    public boolean preparar(Pedido pedido) {
        pedido.setStatus(new PedidoEstadoPreparo());
        return true;
    }

    
    public boolean finalizar(Pedido pedido){
        pedido.setStatus(new PedidoEstadoFinalizado());
        return true;
    }
    
}
