/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.app.Application;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.niftygui.NiftyJmeDisplay;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;

/**
 *
 * @author ARIS CRUZ
 */
public class MyStartScreen extends AbstractAppState implements ScreenController {
    
    private Nifty nifty;
    private Application app;
    private NiftyJmeDisplay niftyJmeDisplay;

    @Override
    public void initialize(AppStateManager stateManager, Application application) {
        super.initialize(stateManager, application);
        this.app = application;
        //TODO: initialize your AppState, e.g. attach spatials to rootNode
        //this is called on the OpenGL thread after the AppState has been attached
        niftyJmeDisplay = new NiftyJmeDisplay(app.getAssetManager(),
                    app.getInputManager(), app.getAudioRenderer(), 
                    app.getRenderManager().getPostView("Gui Default"));
        nifty = niftyJmeDisplay.getNifty();
        nifty.fromXml("Interface/startscreen.xml", "startscreen");
        app.getViewPort().addProcessor(niftyJmeDisplay);
    }
 
    @Override
    public void update(float tpf) {
        //TODO: implement behavior during runtime
    }
 
    @Override
    public void cleanup() {
        super.cleanup();
        //TODO: clean up what you initialized in the initialize method,
        //e.g. remove all spatials from rootNode
        //this is called on the OpenGL thread after the AppState has been detached
        //System.exit(1);
    }    
    
    /** custom methods */ 
     public void startGame(String nextScreen) {
       nifty.gotoScreen(nextScreen);  // switch to another screen
       // start the game and do some more stuff...
       app.getStateManager().detach(this);
       app.getStateManager().attach(new BlasterMainScreen());
     }

     public void quitGame() {
       app.stop(); 
     }    
    
    public void bind(Nifty nifty, Screen screen) {
      
    }

    public void onStartScreen() {
       
    }

    public void onEndScreen() {
      this.cleanup();
    }
    
}
