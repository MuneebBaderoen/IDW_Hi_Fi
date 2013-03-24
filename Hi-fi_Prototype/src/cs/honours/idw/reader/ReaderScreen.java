package cs.honours.idw.reader;
import java.util.LinkedList;
import java.util.ListIterator;

import cs.honours.idw.reader.managers.ScreenManager;
public class ReaderScreen {
	//private GameObject[] screenElements;
	private LinkedList<GameObject> screenElements = new LinkedList<GameObject>();
	private String name;
	private ReaderScreen previousScreen;
	private ScreenManager.screenState previousState;
	
	public ReaderScreen(){
		previousScreen=this;		
	}
	
	public void addScreenElement(GameObject elem){
		screenElements.add(elem);	
	
	}
	
	public ListIterator<GameObject> getScreenElements(){
		return screenElements.listIterator();		
	}
	
	public ReaderScreen getPreviousScreen(){
		return previousScreen;
	}
	
	public  ScreenManager.screenState getPreviousState(){
		return previousState;
	}
	
	
	public void setPreviousScreen(ReaderScreen s){
		 previousScreen = s;
	}
	
	public  void setPreviousState(ScreenManager.screenState s){
		 previousState = s;
	}
}
