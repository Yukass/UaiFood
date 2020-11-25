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
public class Debito implements Pagamento{
    
    public Long id;
    
    public Debito() {
        this.id = 2L;
    }

    @Override
    public String getNome() {
        return "Debito";
    }

    @Override
    public Long getId() {
        return 2L;
    }

    @Override
    public float getDesconto() {
        return 10;
    }
    
}
