package cs.honours.idw.reader;

import java.io.Reader;
import java.util.ListIterator;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;



public class ScreenManager {
	
	public enum screenState {HomeScreen, LoggedInScreen, LoginSkippedScreen, LibraryScreen, SearchScreen, ReadingScreen};
	
	
	private static screenState currentState = screenState.HomeScreen;
	
	ReaderScreen homeScreen;
	ReaderScreen loggedInScreen;
	ReaderScreen loggedInSkippedScreen;
	ReaderScreen libraryScreen;
	ReaderScreen searchScreen;
	ReaderScreen readingScreen;
	
	ReaderScreen favouritesScreen;
	
	ReaderScreen currentScreen;
	
	public ScreenManager(){
		homeScreen=new ReaderScreen();		
		homeScreen.addScreenElement(new GameObject(new Vector2(100,100),TextureManager.appBG));
		
		currentScreen=homeScreen;
		
	}
	
	public void toPreviousScreen(){
		currentScreen = currentScreen.getPreviousScreen();
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
		ListIterator<GameObject> iter = currentScreen.getScreenElements(); 
		while(iter.hasNext())
			iter.next().getSprite().draw(spritebatch);		
	}

}
