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

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public TextureManager(){
		
	}
}
