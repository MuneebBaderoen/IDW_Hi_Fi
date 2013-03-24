package cs.honours.idw.reader.managers;

import java.io.Reader;
import java.util.ListIterator;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import cs.honours.idw.reader.GameObject;
import cs.honours.idw.reader.ReaderScreen;



public class ScreenManager {

	public enum screenState {HomeScreen, LoggedInScreen, LoginSkippedScreen, CurrentlyReadingScreen, LibraryScreen, SearchScreen, ReadingScreen};


	private static screenState currentState = screenState.HomeScreen;

	ReaderScreen homeScreen;
	ReaderScreen currentlyReadingHomeScreen;
	ReaderScreen loggedInScreen;
	ReaderScreen libraryScreen;
	ReaderScreen searchScreen;
	ReaderScreen readingScreen;

	ReaderScreen favouritesScreen;

	public static ReaderScreen currentScreen;

	public ScreenManager(){
		//Homescreen init
		//Application background

		GameObject bg = new GameObject(new Vector2(0,0),TextureManager.appBG);
		//Not yet logged in


		GameObject toLib = new GameObject(new Vector2(0,480-TextureManager.toLibraryBG.getHeight()),TextureManager.toLibraryBG);		
		toLib.setNextTapState(screenState.LibraryScreen);
		toLib.setNextSwipeLeftState(screenState.LibraryScreen);


		GameObject toCurrentBook = new GameObject(new Vector2(0,480-TextureManager.toLibraryBG.getHeight()),TextureManager.toLibraryBG);		
		toCurrentBook.setNextTapState(screenState.LibraryScreen);
		toCurrentBook.setNextSwipeLeftState(screenState.LibraryScreen);



		//Home screen before login
		homeScreen=new ReaderScreen();	
		homeScreen.addScreenElement(bg);//
		//homeScreen.addScreenElement(toLib);//
		homeScreen.addScreenElement(new GameObject(new Vector2(70,60),TextureManager.welcome));
		homeScreen.addScreenElement(new GameObject(new Vector2(70,110),TextureManager.loginUsername));
		homeScreen.addScreenElement(new GameObject(new Vector2(70,160),TextureManager.loginPassword));

		GameObject loginFB = new GameObject(new Vector2(70,210),TextureManager.loginFacebook);
		loginFB.setNextTapState(screenState.LoggedInScreen);
		homeScreen.addScreenElement(loginFB);		

		GameObject loginSk = new GameObject(new Vector2(70,260),TextureManager.loginSkip);
		loginSk.setNextTapState(screenState.LoginSkippedScreen);
		homeScreen.addScreenElement(loginSk);

		//Logged in Screen
		
		
		//Login Skipped screen








		//Currently reading a book, screen.
		currentlyReadingHomeScreen=new ReaderScreen();	
		currentlyReadingHomeScreen.addScreenElement(bg);//

		GameObject bcbg = new GameObject(new Vector2(95,150),TextureManager.bookCoverBG);
		bcbg.scale=1.5f;
		bcbg.setBounds();

		GameObject bcfg = new GameObject(new Vector2(95,150),TextureManager.bookCoverFG);
		bcfg.scale=1.5f;
		bcfg.setBounds();
		bcfg.setNextTapState(screenState.ReadingScreen);

		currentlyReadingHomeScreen.addScreenElement(bcbg);//
		currentlyReadingHomeScreen.addScreenElement(bcfg);//
		currentlyReadingHomeScreen.addScreenElement(toLib);//

		//Library Screen



		currentScreen=homeScreen;

	}

	public void toPreviousScreen(){
		currentScreen = currentScreen.getPreviousScreen();
	}

	public screenState getState(){
		return currentState;		
	}

	public static void setState(screenState newState){
		if(newState!=null)
			currentState = newState;		
	}

	public void update(){
		switch(currentState){
		case HomeScreen:
			System.out.println("HomeScreen");
			break;
		case LoggedInScreen:
			System.out.println("LoggedInScreen");
			break;
		case LoginSkippedScreen:
			System.out.println("Login Skipped Screen");
			break;
		case CurrentlyReadingScreen:
			System.out.println("CurrentlyReadingScreen");
			break;
		case LibraryScreen:
			System.out.println("LibraryScreen");
			break;
		case SearchScreen:
			System.out.println("SearchScreen");
			break;
		case ReadingScreen:
			System.out.println("ReadingScreen");
			break;
		}
	}

	public void draw(SpriteBatch spriteBatch){
		ListIterator<GameObject> iter = currentScreen.getScreenElements();
		int count = 0;
		while(iter.hasNext()){

			iter.next().getSprite().draw(spriteBatch);


			//g.getSprite().draw(spritebatch);
		}


		//new Sprite(TextureManager.appBG).draw(spritebatch);
	}

}
