/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.text.DecimalFormat;

/**
 *
 * @author Yukas
 */
public class Debito implements Pagamento, Serializable{
    
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

    @Override
    public double calculaDesconto(double valor) {
         valor = valor - (valor * (getDesconto()/100));
         String valorFormatado = null;
         valorFormatado = (new DecimalFormat("##.##").format(valor));
         valorFormatado = valorFormatado.replace(",",".");
         valor = Double.parseDouble(valorFormatado);
         return valor;  
    }
    
}
