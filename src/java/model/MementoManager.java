/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author Yukas
 */
public class MementoManager {

    private ArrayList<PedidoEstado> mementos;
    public int index;

    public MementoManager(PedidoEstado pe) {
        mementos = new ArrayList<PedidoEstado>();
        mementos.add(pe);
        index = 0;
    }

    public void adicionarMemento(PedidoEstado memento) {
        esquecerProximos();
        mementos.add(memento);
        index++;
    }

    public PedidoEstado atual() {
        return mementos.get(index);
    }

    public void retroceder() {
        if (index > 0) {
            index--;
        }
    }

    public void avancar() {
        if (index < mementos.size() - 1) {
            index++;
        }
    }

    public void esquecerProximos() {
        for (int i = mementos.size() - 1; i > index; i--) {
            mementos.remove(i);
        }
    }
}
