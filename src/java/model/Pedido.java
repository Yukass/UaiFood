/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Yukas
 */
@Entity
public class Pedido implements Serializable{
    private static final long serialVerionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double total;
    private PedidoEstado status;
    private Cliente cliente;
    private Pagamento pagamento;
    private ArrayList<Item_Pedido> itensPedido;

    public Pedido() {
    }
    
    public Pedido(double total, String status, Cliente cliente, Pagamento pagamento, ArrayList<Item_Pedido> itensPedido) {
        this.total = total;
        this.status = new PedidoEstadoRecebido();
        this.cliente = cliente;
        this.pagamento = pagamento;
        this.itensPedido = itensPedido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public PedidoEstado getStatus() {
        return status;
    }
    
    public void setEstado(PedidoEstado status){
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public ArrayList<Item_Pedido> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(ArrayList<Item_Pedido> itensPedido) {
        this.itensPedido = itensPedido;
    }
    
}
