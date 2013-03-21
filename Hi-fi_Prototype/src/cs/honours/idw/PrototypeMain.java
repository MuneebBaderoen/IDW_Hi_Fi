package cs.honours.idw;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class PrototypeMain implements ApplicationListener {
	private OrthographicCamera camera;
	private SpriteBatch spriteBatch;
	private Texture texture;
	private Sprite sprite;

	public enum State {Home, Library, Search, Reader}
	public static State currentState = State.Home;
	float viewportWidth, viewportHeight;


	private static final int VIRTUAL_WIDTH = 320;
	private static final int VIRTUAL_HEIGHT = 480;
	private static final float ASPECT_RATIO = (float)VIRTUAL_WIDTH/(float)VIRTUAL_HEIGHT;


	GameObject libtex;




	@Override
	public void create() {		
		viewportWidth = Gdx.graphics.getWidth();
		viewportHeight = Gdx.graphics.getHeight();

		camera = new OrthographicCamera(1, viewportHeight/viewportWidth);
		camera.setToOrtho(true, viewportWidth, viewportHeight);

		spriteBatch = new SpriteBatch();
		spriteBatch.setProjectionMatrix(camera.combined);

		/*
		texture = new Texture(Gdx.files.internal("data/libgdx.png"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		TextureRegion region = new TextureRegion(texture, 0, 0, 512, 275);

		sprite = new Sprite(region);
		sprite.setSize(0.9f, 0.9f * sprite.getHeight() / sprite.getWidth());
		sprite.setOrigin(sprite.getWidth()/2, sprite.getHeight()/2);
		sprite.setPosition(-sprite.getWidth()/2, -sprite.getHeight()/2);
		 */

		libtex=new GameObject(new Vector2(20,50));
		libtex.setTexture(Gdx.files.internal("data/BlueBall.png"));

	}

	@Override
	public void dispose() {


	}

	@Override
	public void render() {		
		update();
		draw();
	}

	public void update(){

		libtex.updatePos(new Vector2(1,1));
		libtex.getSprite().setBounds(libtex.position.x, libtex.position.y, 200, 200);
		Gdx.input.isKeyPressed(Keys.BACK){


		}
	}

	public void draw(){

		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


		spriteBatch.begin();
		libtex.getSprite().draw(spriteBatch);
		spriteBatch.end();
	}

	@Override
	public void resize(int width, int height)
	{
		// calculate new viewport
		float aspectRatio = (float)width/(float)height;
		float scale = 1f;
		Vector2 crop = new Vector2(0f, 0f);

		if(aspectRatio > ASPECT_RATIO)
		{
			scale = (float)height/(float)VIRTUAL_HEIGHT;
			crop.x = (width - VIRTUAL_WIDTH*scale)/2f;
		}
		else if(aspectRatio < ASPECT_RATIO)
		{
			scale = (float)width/(float)VIRTUAL_WIDTH;
			crop.y = (height - VIRTUAL_HEIGHT*scale)/2f;
		}
		else
		{
			scale = (float)width/(float)VIRTUAL_WIDTH;
		}

		float w = (float)VIRTUAL_WIDTH*scale;
		float h = (float)VIRTUAL_HEIGHT*scale;

		Rectangle viewport = new Rectangle(crop.x, crop.y, w, h);
		Gdx.gl.glViewport((int) viewport.x, (int) viewport.y,
				(int) viewport.width, (int) viewport.height);
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
