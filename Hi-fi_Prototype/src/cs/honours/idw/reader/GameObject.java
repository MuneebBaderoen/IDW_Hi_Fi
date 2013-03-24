package cs.honours.idw.reader;

import com.badlogic.gdx.math.*;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.Texture.TextureFilter;

import cs.honours.idw.reader.managers.ScreenManager;

public class GameObject {
	protected Vector2 position = new Vector2();
	
	private Texture tex; 
	protected Rectangle boundingBox;// = new Rectangle();
	
	public Sprite sprite;	
	public float rotationAngle = 0f;
	public float scale = 1f;

	ScreenManager.screenState nextTapState = null,
	nextLongPressState= null,
	nextSwipeLeftState= null,
	nextSwipeRightState= null;
	
	public GameObject(Vector2 pos){
		position = pos;		
	}
	
	public GameObject(Vector2 pos, Texture newTex){	
		
		position = pos;
		boundingBox = new Rectangle(pos.x,pos.y, newTex.getWidth(),newTex.getHeight());
		setTexture(newTex);
		setPos(position);		
			
	}
	
	//Texture gets/sets
	public void setTexture(Texture newTex){
		
		tex = newTex;
		tex.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		sprite = new Sprite(tex);
		sprite.flip(false, true);
		sprite.setRotation(rotationAngle);
		sprite.setScale(scale);
		
	}

	public Texture getTexture(){
		return tex;
	}
	
	public Sprite getSprite(){
		return sprite;		
	}	
	
	//Reactions to user input
	//Setting responses
	public void setNextTapState(ScreenManager.screenState nextState){
		nextTapState=nextState;	}
	public void setNextLongPressState(ScreenManager.screenState nextState){
		nextLongPressState=nextState;
	}
	public void setNextSwipeLeftState(ScreenManager.screenState nextState){
		nextSwipeLeftState=nextState;
	}
	public void setNextSwipeRightState(ScreenManager.screenState nextState){
		nextSwipeRightState=nextState;
	}	
	
	
	
	//Methods run by InputManager
	public void onTap(){
		ScreenManager.setState(nextTapState);
	}	
	public void onLongPress(){
		ScreenManager.setState(nextLongPressState);
	}	
	public void onSwipeLeft(){
		ScreenManager.setState(nextSwipeLeftState);
	}	
	public void onSwipeRight(){
		ScreenManager.setState(nextSwipeRightState);
	}
	
		
	//Bounding box gets/sets
	public void setBounds(){			
		sprite.setBounds(boundingBox.x, boundingBox.y, boundingBox.width, boundingBox.height);
		sprite.setRotation(rotationAngle);
		sprite.setScale(scale);
		boundingBox=new Rectangle(sprite.getBoundingRectangle());
	}
	
	public void setNewBounds(Vector2 pos){		
		sprite.setBounds(boundingBox.x, boundingBox.y, boundingBox.width, boundingBox.height);
		sprite.setRotation(rotationAngle);
		sprite.setScale(scale);
		boundingBox=new Rectangle(sprite.getBoundingRectangle());
	}
	
	
	public void setBoundingBoxPosition(Vector2 pos)
	{
		boundingBox.x = pos.x;	
		boundingBox.y = pos.y;
	}
	
	public Rectangle getBounds(){			
		return boundingBox;
	}
	
	//Position gets/sets
	public void updatePos(Vector2 deltaPos){
		setPos(position.add(deltaPos));
	}
	
	public void setPos(Vector2 newPos){		
		boundingBox.x = position.x;//-boundingBox.width/2;
		boundingBox.y = position.y;//-boundingBox.height/2;
		sprite.setBounds(boundingBox.x, boundingBox.y, boundingBox.width, boundingBox.height);
	}
	
	public Vector2 getPos(){
		return position;	
	}

}
