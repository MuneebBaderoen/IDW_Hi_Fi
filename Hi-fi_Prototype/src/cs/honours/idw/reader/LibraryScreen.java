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

	public static screenState currentLibraryState = screenState.CategoryScreen;
	public static ReaderScreen currentScreen;


	public ReaderScreen categoryScreen = new ReaderScreen();

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
		//Library Screens
		GameObject bg = new GameObject(new Vector2(0,0),TextureManager.appBG);

		GameObject bottomSwipeBG = new GameObject(new Vector2(0,800-TextureManager.toLibraryBG.getHeight()),TextureManager.toLibraryBG);		
		bottomSwipeBG.setNextTapState(screenState.LibraryScreen);
		bottomSwipeBG.setNextSwipeLeftState(screenState.LibraryScreen);


		GameObject searchBar = new GameObject(new Vector2(0,0), TextureManager.searchBar);
		searchBar.setNextTapState(screenState.SearchScreen);

		categoryScreen.addScreenElement(bg);
		categoryScreen.addScreenElement(searchBar);
		categoryScreen.setPreviousState(screenState.CategoryScreen);
		for(int i = 0; i<6;i++){
			Vector2 position = new Vector2(0,68+110*i);
			GameObject catBG = new GameObject(position, TextureManager.categoryBG);
			switch(i){
			case 0:
				catBG.setNextTapState(screenState.TitlesScreen);
				categoryScreen.addScreenElement(catBG);
				categoryScreen.addScreenElement(new GameObject(position, TextureManager.categoryTitles));
				break;
			case 1:
				catBG.setNextTapState(screenState.AuthorsScreen);
				categoryScreen.addScreenElement(catBG);
				categoryScreen.addScreenElement(new GameObject(position, TextureManager.categoryAuthors));
				break;
			case 2:
				catBG.setNextTapState(screenState.GenreScreen);
				categoryScreen.addScreenElement(catBG);
				categoryScreen.addScreenElement(new GameObject(position, TextureManager.categoryGenres));
				break;
			case 3:
				catBG.setNextTapState(screenState.RecommendedScreen);
				categoryScreen.addScreenElement(catBG);
				categoryScreen.addScreenElement(new GameObject(position, TextureManager.categoryRecommended));
				break;
			case 4:
				catBG.setNextTapState(screenState.ReadLaterScreen);
				categoryScreen.addScreenElement(catBG);
				categoryScreen.addScreenElement(new GameObject(position, TextureManager.categoryReadLater));
				break;
			case 5:
				catBG.setNextTapState(screenState.RecentBooksScreen);
				categoryScreen.addScreenElement(catBG);
				categoryScreen.addScreenElement(new GameObject(position, TextureManager.categoryRecent));
				break;
				
			}
				
		}
		

		categoryScreen.addScreenElement(bottomSwipeBG);

		titlesScreen.setPreviousScreen(categoryScreen);
		titlesScreen.setPreviousState(screenState.CategoryScreen);
		titlesScreen.addScreenElement(bg);
		titlesScreen.addScreenElement(searchBar);
		titlesScreen.addScreenElement(bottomSwipeBG);
		for(int i = 0; i<3;i++){
			Vector2 position = new Vector2(0,68+72*i);
			GameObject bookBG = new GameObject(position, TextureManager.bookBG);
			bookBG.setNextTapState(screenState.ReadingScreen);
			titlesScreen.addScreenElement(bookBG);
			switch(i){
			case 0:				
				titlesScreen.addScreenElement(new GameObject(position, TextureManager.coverJaneEyre));
				break;
			case 1:			
				titlesScreen.addScreenElement(new GameObject(position, TextureManager.coverLifeOfPi));
				break;
			case 2:			
				titlesScreen.addScreenElement(new GameObject(position, TextureManager.coverPride));
				break;
			}
		}
		
		/*
		authorsScreen	 
		genreScreen	 
		recommendedScreen 
		readLaterScreen	 
		recentBooksScreen 
		
		 */
		GameObject searchBarJane = new GameObject(new Vector2(0,0), TextureManager.searchBarJane);
		searchBar.setNextTapState(screenState.SearchScreen);
		
		searchScreen.addScreenElement(bg);
		searchScreen.addScreenElement(searchBarJane);
		searchScreen.addScreenElement(bottomSwipeBG);
		searchScreen.setPreviousScreen(categoryScreen);
		
		searchScreen.setPreviousState(screenState.CategoryScreen);
		
		for(int i = 0; i<3;i++){
			Vector2 position = new Vector2(0,68+72*i);
			
			
			switch(i){
			case 0:	
				GameObject bookBG = new GameObject(position, TextureManager.bookBG);
				bookBG.setNextTapState(screenState.SearchAuthorScreen);
				searchScreen.addScreenElement(bookBG);
				searchScreen.addScreenElement(new GameObject(position, TextureManager.sortTitle));				
				break;
			case 1:			
				GameObject bookBG2 = new GameObject(position, TextureManager.bookBG);
				bookBG2.setNextTapState(screenState.ReadingScreen);
				searchScreen.addScreenElement(bookBG2);
				searchScreen.addScreenElement(new GameObject(position, TextureManager.coverJaneEyre));
				break;
			case 2:			
				GameObject bookBG3 = new GameObject(position, TextureManager.bookBG);
				bookBG3.setNextTapState(screenState.ReadingScreen);
				searchScreen.addScreenElement(bookBG3);
				searchScreen.addScreenElement(new GameObject(position, TextureManager.coverPride));
				break;
			}
		}
		
		
		
		
		searchAuthorScreen.addScreenElement(bg);
		searchAuthorScreen.addScreenElement(searchBarJane);
		searchAuthorScreen.addScreenElement(bottomSwipeBG);
		searchAuthorScreen.setPreviousScreen(categoryScreen);
		searchAuthorScreen.setPreviousState(screenState.CategoryScreen);
		
		for(int i = 0; i<3;i++){
			Vector2 position = new Vector2(0,68+72*i);
			
			
			switch(i){
			case 0:				
				GameObject bookBG = new GameObject(position, TextureManager.bookBG);
				bookBG.setNextTapState(screenState.SearchScreen);
				searchAuthorScreen.addScreenElement(bookBG);
				searchAuthorScreen.addScreenElement(new GameObject(position, TextureManager.sortAuthor));
				break;
			case 1:			
				GameObject bookBG2 = new GameObject(position, TextureManager.bookBG);
				bookBG2.setNextTapState(screenState.ReadingScreen);
				searchAuthorScreen.addScreenElement(bookBG2);
				searchAuthorScreen.addScreenElement(new GameObject(position, TextureManager.coverJaneEyre));
				break;
			case 2:			
				GameObject bookBG3 = new GameObject(position, TextureManager.bookBG);
				bookBG3.setNextTapState(screenState.ReadingScreen);
				searchAuthorScreen.addScreenElement(bookBG3);
				searchAuthorScreen.addScreenElement(new GameObject(position, TextureManager.coverPride));
				break;
			}
		}
		
		
		
		
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
			currentScreen=titlesScreen;
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
			currentScreen=searchScreen;
			break;
		case SearchAuthorScreen:
			currentScreen=searchAuthorScreen;
			break;



		}


	}


}
