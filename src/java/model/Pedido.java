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
    private String status;
    private Cliente cliente;
    private String pagamento;
    //Mudar String por Pagamento
    private ArrayList<Item_Pedido> itensPedidos;

    public Pedido() {
    }
    
    public Pedido(double total, Cliente cliente, String pagamento, ArrayList<Item_Pedido> itensPedidos) {
        this.total = total;
        PedidoEstadoRecebido estado = new PedidoEstadoRecebido();
        this.status = estado.getEstado();
        this.cliente = cliente;
        this.pagamento = pagamento;
        this.itensPedidos = itensPedidos;
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

    public String getStatus() {
        return status;
    }
    
    public void setEstado(String status){
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    public ArrayList<Item_Pedido> getItensPedido() {
        return itensPedidos;
    }

    public void setItensPedido(ArrayList<Item_Pedido> itensPedidos) {
        this.itensPedidos = itensPedidos;
    }
    
}
