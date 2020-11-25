/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.Pedido;
import model.PedidoEstado;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.MementoManager;

/**
 *
 * @author Yukas
 */
public class MainFactory {

    public static Object getObject(String state) {
        Object actionObject = null;
        String nomeClasse = state;

        Class classe = null;
        Object objeto = null;
        try {
            classe = Class.forName(nomeClasse);
            objeto = classe.newInstance();
        } catch (Exception ex) {
            return null;
        }

        actionObject = objeto;
        return actionObject;
    }

    public static Boolean invocarMetodoFactory(Pedido pedido, String nomeMetodo) {
        Boolean mudou = false;
        try {
            Method metodo = PedidoEstado.class.getMethod(nomeMetodo, Pedido.class);
            mudou = (Boolean) metodo.invoke(pedido.getStatus(), pedido);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(MainFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mudou;
    }

    public static void invocarMemento(MementoManager mm, String nomeMetodo) {

        try {
            Method metodo = MementoManager.class.getMethod(nomeMetodo);
            metodo.invoke(mm);
        } catch (SecurityException | IllegalArgumentException | NoSuchMethodException | IllegalAccessException | InvocationTargetException ex) {
            Logger.getLogger(MainFactory.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
