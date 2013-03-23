package cs.honours.idw.reader;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;



public class ScreenManager {
	
	public enum screenState {HomeScreen, LoggedInScreen, LoginSkippedScreen, LibraryScreen, SearchScreen, ReadingScreen};
	
	
	private static screenState currentState = screenState.HomeScreen;
	
	public ScreenManager(){
		
		
	}
	
	public screenState getState(){
		return currentState;		
	}
	
	public static void setState(screenState newState){
		 currentState = newState;		
	}
	
	public void update(){
		
	}
	
	public void draw(SpriteBatch spritebatch){
		
		
	}

}
