package cs.honours.idw.books;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

import cs.honours.idw.reader.GameObject;

public class Book extends GameObject{
	public String title;
	public String author;
	public Sprite cover;
	
	public Book(Vector2 position, String t, String a, Texture tex){
		super(position, tex);
		title= new String(t);
		author = new String(a);	
		cover = new Sprite(tex);
	}
	
	
}
