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
public class Dinheiro implements Pagamento{
    
    public Long id;
    
    public Dinheiro() {
        this.id = 1L;
    }

    @Override
    public String getNome() {
        return "Dinheiro";
    }

    @Override
    public Long getId() {
        return 1L;
    }

    @Override
    public float getDesconto() {
        return 5;
    }
    
}
