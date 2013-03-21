package cs.honours.idw;

import com.badlogic.gdx.math.*;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.Texture.TextureFilter;

public class GameObject {
	protected Vector2 position = new Vector2();
	private Texture tex; 
	protected Rectangle boundingBox = new Rectangle();
	public Sprite sprite;	
	public float rotationAngle = 0f;
	public Vector2[] normals = new Vector2[4];
	
	public GameObject(Vector2 pos){
		position = pos;		
	}
	
	//Texture gets/sets
	public void setTexture(Texture newTex){
		
		tex = newTex;
		tex.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		sprite = new Sprite(tex);
		sprite.flip(false, true);
		sprite.setRotation(rotationAngle);
		tex.getTextureData().prepare();
		
		setBounds();
	}
	
	public void setTexture(FileHandle dir){
		tex = new Texture(dir);	
		tex.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		sprite = new Sprite(tex);
		sprite.flip(false, true);
		sprite.setRotation(rotationAngle);		
		setBounds();
	}	

	public Texture getTexture(){
		return tex;
	}
	
	public Sprite getSprite(){
		return sprite;		
	}	
	
		
	//Bounding box gets/sets
	protected void setBounds(){
		boundingBox.width = tex.getWidth();
		boundingBox.height = tex.getHeight();
		boundingBox.x = position.x-boundingBox.width/2;
		boundingBox.y = position.y-boundingBox.height/2;		
		sprite.setBounds(boundingBox.x, boundingBox.y, boundingBox.width, boundingBox.height);
		sprite.setRotation(rotationAngle);
		boundingBox=new Rectangle(sprite.getBoundingRectangle());
	}
	
	protected void setNewBounds(Vector2 pos){
		boundingBox.width = tex.getWidth();
		boundingBox.height = tex.getHeight();
		boundingBox.x = pos.x -boundingBox.width/2;
		boundingBox.y = pos.y -boundingBox.height/2;
		sprite.setBounds(boundingBox.x, boundingBox.y, boundingBox.width, boundingBox.height);
		sprite.setRotation(rotationAngle);
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
		boundingBox.x = position.x-boundingBox.width/2;
		boundingBox.y = position.y-boundingBox.height/2;
		sprite.setBounds(boundingBox.x, boundingBox.y, boundingBox.width, boundingBox.height);
	}
	
	public Vector2 getPos(){
		return position;	
	}

}
