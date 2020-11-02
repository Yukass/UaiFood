/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Yukas
 */
public class ActionFactory {
  public static Action create(String action){
    Action actionObject= null;
    String nomeClasse = "action." + action + "Action";
    Class classe = null;
    Object object = null;
    try {
      classe = Class.forName(nomeClasse);
      object = classe.newInstance();
    } catch (Exception ex) {
      return null;
    }
    if(!(object instanceof Action)) return null;
    actionObject = (Action) object;
    return actionObject;
  }
}
