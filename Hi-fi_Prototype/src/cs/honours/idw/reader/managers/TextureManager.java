package cs.honours.idw.reader.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class TextureManager {
	//public static Texture _____ = new Texture(Gdx.files.internal(path));
	public static Texture appBG = new Texture(Gdx.files.internal("homescreen/gradientBG.png"));
	public static Texture toolbarActivator = new Texture(Gdx.files.internal("readerScreen/toolbarActivator.png"));	
	
	public static Texture bookCoverBG = new Texture(Gdx.files.internal("homescreen/homeScreenBG.png"));
	public static Texture bookCoverFG = new Texture(Gdx.files.internal("homescreen/homeScreenFG.png"));
	public static Texture toLibraryBG = new Texture(Gdx.files.internal("homescreen/pageTurnSwipe.png"));
	
	public static Texture toLibraryFG = new Texture(Gdx.files.internal("homescreen/toMyLibrary.png"));
	public static Texture toLifeOfPiFG = new Texture(Gdx.files.internal("homescreen/toLifeOfPi.png"));

	public static Texture loginSkip = new Texture(Gdx.files.internal("homescreen/loginSkip.png"));
	public static Texture loginFacebook = new Texture(Gdx.files.internal("homescreen/loginFacebook.png"));
	public static Texture loginUsername = new Texture(Gdx.files.internal("homescreen/loginUsername.png"));
	public static Texture loginPassword = new Texture(Gdx.files.internal("homescreen/loginPassword.png"));
	public static Texture loginUserPicture = new Texture(Gdx.files.internal("homescreen/loginUserPic.png"));

	
	public static Texture welcome = new Texture(Gdx.files.internal("homescreen/welcome.png"));
	public static Texture welcomeUser = new Texture(Gdx.files.internal("homescreen/welcomeUser.png"));
	public static Texture welcomeMuneeb = new Texture(Gdx.files.internal("homescreen/welcomeMuneeb.png"));

	
	//Library UI
	public static Texture searchBar = new Texture(Gdx.files.internal("libraryScreen/searchBar.png"));
	public static Texture searchBarJane = new Texture(Gdx.files.internal("libraryScreen/searchBarJane.png"));
	public static Texture categoryBG = new Texture(Gdx.files.internal("libraryScreen/categoryBG.png"));
	public static Texture bookBG = new Texture(Gdx.files.internal("libraryScreen/bookBG.png"));

	//Category icons
	public static Texture categoryTitles = new Texture(Gdx.files.internal("libraryScreen/categoryTitles.png"));
	public static Texture categoryAuthors = new Texture(Gdx.files.internal("libraryScreen/categoryAuthors.png"));
	public static Texture categoryGenres = new Texture(Gdx.files.internal("libraryScreen/categoryGenres.png"));
	public static Texture categoryRecommended = new Texture(Gdx.files.internal("libraryScreen/categoryRecommended.png"));
	public static Texture categoryReadLater = new Texture(Gdx.files.internal("libraryScreen/categoryReadLater.png"));
	public static Texture categoryRecent = new Texture(Gdx.files.internal("libraryScreen/categoryRecentBooks.png"));
	
	//Book Icons
	public static Texture coverLifeOfPi = new Texture(Gdx.files.internal("libraryScreen/coverLifeOfPi.png"));
	public static Texture coverGreenMile = new Texture(Gdx.files.internal("libraryScreen/coverGreenMile.png"));
	public static Texture coverPride = new Texture(Gdx.files.internal("libraryScreen/coverPride.png"));
	public static Texture coverSense = new Texture(Gdx.files.internal("libraryScreen/coverSense.png"));
	public static Texture coverJaneEyre = new Texture(Gdx.files.internal("libraryScreen/coverJaneEyre.png"));
	
	//Search sort orders
	public static Texture sortAuthor = new Texture(Gdx.files.internal("libraryScreen/sortAuthor.png"));
	public static Texture sortTitle = new Texture(Gdx.files.internal("libraryScreen/sortTitle.png"));

	//reading pages
	public static Texture readPage1 = new Texture(Gdx.files.internal("readerScreen/readingPage1.png"));
	public static Texture readPage2 = new Texture(Gdx.files.internal("readerScreen/readingPage2.png"));
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public TextureManager(){
		
	}
}
