/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.screencontrollers;

import com.jme3.app.SimpleApplication;
import mygame.MyStartScreen;

/**
 *
 * @author ARIS CRUZ
 */
public class StartScreenController extends SimpleApplication {
    
    public static void main(String[] args) {
        StartScreenController startScreenController = new StartScreenController();
        startScreenController.start();
    }

    @Override
    public void simpleInitApp() {
        MyStartScreen myStartScreen = new MyStartScreen();
        myStartScreen.initialize(stateManager, this);
    }    
}
