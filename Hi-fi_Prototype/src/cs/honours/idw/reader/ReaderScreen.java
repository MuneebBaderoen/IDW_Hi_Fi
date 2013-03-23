package cs.honours.idw.reader;
import java.util.LinkedList;
import java.util.ListIterator;
public class ReaderScreen {
	//private GameObject[] screenElements;
	private LinkedList<GameObject> screenElements = new LinkedList<GameObject>();
	private String name;
	
	public ReaderScreen(){
		
		
	}
	
	public void addScreenElement(GameObject elem){
		screenElements.add(elem);	
	
	}
	
	public ListIterator<GameObject> getScreenElements(){
		return screenElements.listIterator();		
	}
}
