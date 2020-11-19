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
public class PedidoEstadoDespachado implements PedidoEstado{

    public String getEstado() {
        return "Saiu para Entrega";
    }

    public void receber(Pedido pedido) {
    }

    public void preparar(Pedido pedido) {
    }

    public void despachar(Pedido pedido) {
    }

    public void entregar(Pedido pedido) {
        pedido.setEstado(new PedidoEstadoEntregue());
    }

    public void devolver(Pedido pedido) {
    }

    public void cancelar(Pedido pedido) {
        pedido.setEstado(new PedidoEstadoCancelado());
    }
    
    public void finalizar(Pedido pedido){
    }
    
    
}
