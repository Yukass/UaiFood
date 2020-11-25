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
public interface Pagamento {
    
    public Long getId();

    public String getNome();

    public float getDesconto();
    
    public double calculaDesconto(double valor);

}
