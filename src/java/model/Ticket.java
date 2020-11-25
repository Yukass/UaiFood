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
public class Ticket implements Pagamento{
    public Long id;
    
    public Ticket() {
        this.id = 3L;
    }

    @Override
    public String getNome() {
        return "Ticket";
    }

    @Override
    public Long getId() {
        return 3L;
    }

    @Override
    public float getDesconto() {
        return 0;
    }
    
}
