/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.model;

/**
 *
 * @author moutaz hegazy
 */
public interface SETVIEW {
    public void setView(int at,char mark);
    public void resetScreen();
    default public void enterGame(){}
    public void runWinnigAnimation(String name);
    public void runLosingAnimation(String name);
    public void runDrawAnimation();
    public void isMyTurn();
    public void isNotMyTurn();
    default void hideRecordButton(){}
}
