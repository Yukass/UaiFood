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
public class PedidoEstadoFinalizado implements PedidoEstado{
    public String getEstado() {
    return "Finalizado";
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
    }

    public void cancelar(Pedido pedido) {
    }
    
    public void finalizar(Pedido pedido){
    }
    
}
