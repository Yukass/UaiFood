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
public class PedidoEstadoEntregue implements PedidoEstado{

    public String getEstado() {
        return "Entregue";
    }

    public void receber(Pedido pedido) {
    }

    public void preparar(Pedido pedido) {
    }

    public void despachar(Pedido pedido) {
    }

    public void entregar(Pedido pedido) {
    }

    public void devolver(Pedido pedido) {
        pedido.setEstado(new PedidoEstadoDevolvido());
    }

    public void cancelar(Pedido pedido) {
        pedido.setEstado(new PedidoEstadoCancelado());
    }
    
    public void finalizar(Pedido pedido){
        pedido.setEstado(new PedidoEstadoFinalizado());
    }
    
    
}
