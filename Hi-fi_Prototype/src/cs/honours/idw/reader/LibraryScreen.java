package cs.honours.idw.reader;

import java.util.ListIterator;

import com.badlogic.gdx.math.Vector2;

import cs.honours.idw.books.*;
import cs.honours.idw.reader.managers.ScreenManager;
import cs.honours.idw.reader.managers.ScreenManager.screenState;
import cs.honours.idw.reader.managers.TextureManager;



public class LibraryScreen extends ReaderScreen {
	public enum LibraryState{
		CategoryScreen, 	 
		TitlesScreen,	
		AuthorsScreen,	 
		GenreScreen,	 
		RecommendedScreen,	 
		ReadLaterScreen,	 
		RecentBooksScreen,
		SearchScreen,
		SearchAuthorScreen}

	public screenState currentLibraryState = screenState.CategoryScreen;
	public ReaderScreen currentScreen;


	ReaderScreen categoryScreen = new ReaderScreen();

	ReaderScreen titlesScreen = new ReaderScreen();
	ReaderScreen authorsScreen = new ReaderScreen();
	ReaderScreen genreScreen = new ReaderScreen();	
	ReaderScreen recommendedScreen = new ReaderScreen();
	ReaderScreen readLaterScreen = new ReaderScreen();	 
	ReaderScreen recentBooksScreen = new ReaderScreen();
	ReaderScreen searchScreen = new ReaderScreen();
	ReaderScreen searchAuthorScreen = new ReaderScreen();

	BookCollection collection = new BookCollection();

	public LibraryScreen(){
		GameObject bg = new GameObject(new Vector2(0,0),TextureManager.appBG);

		GameObject bottomSwipeBG = new GameObject(new Vector2(0,800-TextureManager.toLibraryBG.getHeight()),TextureManager.toLibraryBG);		
		bottomSwipeBG.setNextTapState(screenState.LibraryScreen);
		bottomSwipeBG.setNextSwipeLeftState(screenState.LibraryScreen);


		GameObject searchBar = new GameObject(new Vector2(0,0), TextureManager.searchBar);
		searchBar.setNextTapState(screenState.SearchScreen);


		categoryScreen.addScreenElement(bg);
		categoryScreen.addScreenElement(searchBar);




		for(int i = 0; i<6;i++){
			Vector2 position = new Vector2(0,68+110*i);
			GameObject catBG = new GameObject(position, TextureManager.categoryBG);
			switch(i){
			case 0:
				catBG.setNextTapState(screenState.TitlesScreen);
				categoryScreen.addScreenElement(new GameObject(position, TextureManager.));
				break;
			case 1:
				catBG.setNextTapState(screenState.AuthorsScreen);
				categoryScreen.addScreenElement(new GameObject(position, TextureManager.));
				break;
			case 2:
				catBG.setNextTapState(screenState.GenreScreen);
				categoryScreen.addScreenElement(new GameObject(position, TextureManager.));
				break;
			case 3:
				catBG.setNextTapState(screenState.RecommendedScreen);
				categoryScreen.addScreenElement(new GameObject(position, TextureManager.));
				break;
			case 4:
				catBG.setNextTapState(screenState.ReadLaterScreen);
				categoryScreen.addScreenElement(new GameObject(position, TextureManager.));
				break;
			case 5:
				catBG.setNextTapState(screenState.RecentBooksScreen);
				categoryScreen.addScreenElement(new GameObject(position, TextureManager.));
				break;
				
			}
			categoryScreen.addScreenElement(catBG);	
		}
		

		categoryScreen.addScreenElement(bottomSwipeBG);

		/*
		titlesScreen	
		authorsScreen	 
		genreScreen	 
		recommendedScreen 
		readLaterScreen	 
		recentBooksScreen 
		searchScreen
		searchAuthorScreen
		 */

		currentScreen=categoryScreen;
	}

	public ListIterator<GameObject> getScreenElements(){
		return currentScreen.getScreenElements();		
	}

	public ReaderScreen getPreviousScreen(){
		return currentScreen.getPreviousScreen();
	}

	public  ScreenManager.screenState getPreviousState(){
		return currentScreen.getPreviousState();
	}

	public void update(){
		System.out.println(ScreenManager.currentState);
		switch(ScreenManager.currentState){
		case CategoryScreen:
			currentScreen=categoryScreen;
			break;
		case TitlesScreen:
			break;
		case AuthorsScreen:
			break;
		case GenreScreen:
			break;
		case RecommendedScreen:
			break;
		case ReadLaterScreen:
			break;
		case RecentBooksScreen:
			break;
		case SearchScreen:
			break;
		case SearchAuthorScreen:
			break;



		}


	}


}
