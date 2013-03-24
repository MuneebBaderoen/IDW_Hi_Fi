package cs.honours.idw.reader.managers;
import java.util.ListIterator;

import sun.org.mozilla.javascript.internal.ast.SwitchStatement;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.*;
import com.badlogic.gdx.utils.IntIntMap;

import cs.honours.idw.PrototypeMain;
import cs.honours.idw.reader.GameObject;

public class InputManager implements GestureListener{

	public InputManager(){


	}

	public enum InputState{Tap,SwipeLeft,SwipeRight,LongPress};
	public static boolean isTouchDown = false;
	public Vector2 initialTouch = new Vector2();
	public Vector2 currentTouch = new Vector2();
	public Vector2 swipeVelocity = new Vector2();
	public static InputState currentInputState = null;

	@Override
	public boolean touchDown(float x, float y, int pointer, int button) {
		Vector3 touch = new Vector3(x,y,0);			
		PrototypeMain.camera.unproject(touch,PrototypeMain.viewport.x, PrototypeMain.viewport.y, PrototypeMain.viewport.width, PrototypeMain.viewport.height);
		initialTouch = new Vector2(touch.x, touch.y);
		
		if(!isTouchDown){
			System.out.println("Initial touch Down:"+touch);
			isTouchDown=true;
		}

		return false;
	}

	@Override
	public boolean tap(float x, float y, int count, int button) {
		Vector3 touch = new Vector3(x,y,0);			
		PrototypeMain.camera.unproject(touch,PrototypeMain.viewport.x, PrototypeMain.viewport.y, PrototypeMain.viewport.width, PrototypeMain.viewport.height);
		initialTouch = new Vector2(touch.x, touch.y);
		currentInputState=InputState.Tap;
		screenSwitch(currentInputState);

		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean longPress(float x, float y) {
		Vector3 touch = new Vector3(x,y,0);			
		PrototypeMain.camera.unproject(touch,PrototypeMain.viewport.x, PrototypeMain.viewport.y, PrototypeMain.viewport.width, PrototypeMain.viewport.height);
		initialTouch = new Vector2(touch.x, touch.y);
		currentInputState=InputState.LongPress;
		screenSwitch(currentInputState);

		

		return false;
	}

	@Override
	public boolean fling(float velocityX, float velocityY, int button) {
		swipeVelocity=new Vector2(velocityX, velocityY);
		if(swipeVelocity.x>0)
			currentInputState=InputState.SwipeRight;
		else
			currentInputState=InputState.SwipeLeft;
		screenSwitch(currentInputState);

		return false;
	}

	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean zoom(float initialDistance, float distance) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2,
			Vector2 pointer1, Vector2 pointer2) {
		// TODO Auto-generated method stub
		return false;
	}

	public void screenSwitch(InputState state){

		ListIterator<GameObject> iter = ScreenManager.currentScreen.getScreenElements();

		while(iter.hasNext()){
			GameObject g = iter.next();
			if(g.getBounds().contains(initialTouch.x, initialTouch.y)){
				switch(state)
				{
				case Tap:
					g.onTap();
					break;
				case SwipeLeft:
					g.onSwipeLeft();
					break;
				case SwipeRight:
					g.onSwipeRight();
					break;
				case LongPress:
					g.onLongPress();
					break;
					
				}
			}
		}
	}

}


