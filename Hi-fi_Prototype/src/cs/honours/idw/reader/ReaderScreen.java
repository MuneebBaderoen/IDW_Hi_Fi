package cs.honours.idw.reader;
import java.util.LinkedList;
import java.util.ListIterator;
public class ReaderScreen {
	//private GameObject[] screenElements;
	private LinkedList<GameObject> screenElements = new LinkedList<GameObject>();
	private String name;
	private ReaderScreen previousScreen;
	
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
}
