/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Yukas
 */
@Entity
public class Pedido extends Observable implements Serializable{
    private static final long serialVerionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double total;
    private PedidoEstado status;
    private Cliente cliente;
    private Long idLoja;
    private Pagamento pagamento;
    //Mudar String por Pagamento
    private ArrayList<Item_Pedido> itensPedidos;

    public Pedido() {
    }
    
    public Pedido(double total, Cliente cliente, Pagamento pagamento, ArrayList<Item_Pedido> itensPedidos, Long idLoja) {
        this.total = total;
        this.status = new PedidoEstadoRecebido();
        this.cliente = cliente;
        this.pagamento = pagamento;
        this.itensPedidos = itensPedidos;
        this.idLoja = idLoja;
    }

     public Long getIdLoja() {
        return idLoja;
    }

    public void setIdLoja(Long idLoja) {
        this.idLoja = idLoja;
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

    public Pedido setStatus(PedidoEstado status) {
        this.status = status;
        return this;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Pedido setCliente(Cliente cliente) {
        this.cliente = cliente;
        this.addObserver(this.cliente);
        return this;
    }
    
    public Pedido setPedido(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }
    
    public void notificar() {
        setChanged();
        notifyObservers();
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public ArrayList<Item_Pedido> getItensPedidos() {
        return itensPedidos;
    }

    public void setItensPedidos(ArrayList<Item_Pedido> itensPedidos) {
        this.itensPedidos = itensPedidos;
    }
    
}
