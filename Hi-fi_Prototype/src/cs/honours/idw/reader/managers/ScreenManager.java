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

	public enum screenState {HomeScreen, LoggedInScreen, LoginSkippedScreen, CurrentlyReadingScreen, LibraryScreen, SearchScreen, ReadingScreen, ReadingWithToolbar};


	private static screenState currentState = screenState.HomeScreen;

	ReaderScreen homeScreen;
	ReaderScreen currentlyReadingHomeScreen;
	ReaderScreen loggedInScreen;
	ReaderScreen loginSkippedScreen;
	ReaderScreen libraryScreen;
	ReaderScreen searchScreen;
	ReaderScreen readingScreen;

	ReaderScreen favouritesScreen;

	public static ReaderScreen currentScreen;
	
	public boolean currentlyReadingSomething = true;
	public boolean toolbarActive = false;

	public ScreenManager(){
		//Homescreen init
		//Application background

		GameObject bg = new GameObject(new Vector2(0,0),TextureManager.appBG);
		//Not yet logged in


		GameObject bottomSwipeBG = new GameObject(new Vector2(0,480-TextureManager.toLibraryBG.getHeight()),TextureManager.toLibraryBG);		
		bottomSwipeBG.setNextTapState(screenState.LibraryScreen);
		bottomSwipeBG.setNextSwipeLeftState(screenState.LibraryScreen);
		
		GameObject toLibrary = new GameObject(new Vector2(0,480-TextureManager.toLibraryBG.getHeight()),TextureManager.toLibraryBG);		
		

		GameObject toCurrentBook = new GameObject(new Vector2(0,480-TextureManager.toLibraryBG.getHeight()),TextureManager.toLibraryBG);		
		toCurrentBook.setNextTapState(screenState.ReadingScreen);
		toCurrentBook.setNextSwipeLeftState(screenState.ReadingScreen);



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
		loggedInScreen = new ReaderScreen();
		loggedInScreen.setPreviousScreen(homeScreen);
		loggedInScreen.addScreenElement(bg);//
		loggedInScreen.addScreenElement(new GameObject(new Vector2(70,60),TextureManager.welcomeMuneeb));
		loggedInScreen.addScreenElement(new GameObject(new Vector2(60,120),TextureManager.loginUserPicture));
		loggedInScreen.addScreenElement(bottomSwipeBG);
					
		//Login Skipped screen

		loginSkippedScreen = new ReaderScreen();
		loginSkippedScreen.setPreviousScreen(homeScreen);
		loginSkippedScreen.addScreenElement(bg);//
		loginSkippedScreen.addScreenElement(new GameObject(new Vector2(70,60),TextureManager.welcomeUser));
		loginSkippedScreen.addScreenElement(new GameObject(new Vector2(60,120),TextureManager.loginUserPicture));
		loginSkippedScreen.addScreenElement(bottomSwipeBG);

		




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
		currentlyReadingHomeScreen.addScreenElement(bottomSwipeBG);//

		//Library Screen

		libraryScreen=new ReaderScreen();
		
		//in book screen
		
		
		readingScreen=new ReaderScreen();
		GameObject toolbarActivator = new GameObject(new Vector2(0,0), TextureManager.toolbarActivator);
		toolbarActivator.setNextSwipeLeftState(screenState.ReadingWithToolbar);
		toolbarActivator.setNextSwipeRightState(screenState.ReadingWithToolbar);
		readingScreen.addScreenElement(toolbarActivator);

	
		
		


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
			currentScreen=homeScreen;
			break;
		case LoggedInScreen:
			System.out.println("LoggedInScreen");
			currentScreen=loggedInScreen;
			break;
		case LoginSkippedScreen:
			System.out.println("Login Skipped Screen");
			currentScreen=loginSkippedScreen;
			break;
		case CurrentlyReadingScreen:
			System.out.println("CurrentlyReadingScreen");
			break;
		case LibraryScreen:
			if(currentlyReadingSomething){
				currentScreen = readingScreen;
				currentState=screenState.ReadingScreen;
			}
			
			else 
				currentScreen=libraryScreen;
			System.out.println("LibraryScreen");
			break;
		case SearchScreen:
			System.out.println("SearchScreen");
			break;
		case ReadingScreen:
			currentlyReadingSomething=true;
			System.out.println("ReadingScreen");
			break;
		case ReadingWithToolbar:	
			toolbarActive=!toolbarActive;
			currentState=screenState.ReadingScreen;
			if(toolbarActive)
				System.out.println(toolbarActive);
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
		if(currentState==screenState.LibraryScreen||currentState==screenState.LoginSkippedScreen||currentState==screenState.LoggedInScreen){
			GameObject fg;
			if(!currentlyReadingSomething){
				 fg = new GameObject(new Vector2(0,480-TextureManager.toLibraryBG.getHeight()),TextureManager.toLibraryFG);	
			}
			else 
			{
				 fg = new GameObject(new Vector2(0,480-TextureManager.toLibraryBG.getHeight()),TextureManager.toLifeOfPiFG);	
			}
			fg.getSprite().draw(spriteBatch);
		}
			
				

		//new Sprite(TextureManager.appBG).draw(spritebatch);
	}

}
