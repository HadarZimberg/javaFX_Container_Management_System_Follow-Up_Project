package Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import javafx.scene.control.Button;

public class MyArrayList<Container> {

	private Set<Container> _set;
	private ArrayList<Container> _arrayList;
	private HashSet<Observer> _obSet = new HashSet<>();
	
	public MyArrayList(Set<Container> set) {
		_set = new HashSet<Container>(set);
		_arrayList = new ArrayList<>(_set);
	}

	public void add(Container container) {
		_arrayList.add(container);
	}

	public Iterator<Container> iterator() {
		return new MyIt();
	}

	private class MyIt implements Iterator<Container> {
		private int cur = 0;
		
		@Override
		public boolean hasNext() {
			return cur < _arrayList.size();
		}

		@Override
		public Container next() {
			if (!hasNext())
				throw new NoSuchElementException();
			Container tmp = _arrayList.get(cur);
			cur++;
			return tmp;
		}
		
		@Override
		public void remove() {
			cur--;
			_arrayList.remove(cur);
		}
	}
	
	public void attach(Observer o) {
		_obSet.add(o);
	}
	
	public void dettach(Observer o) {
		_obSet.remove(o);
	}
	
	public void click() {
		myNotify();
	}
	
	public void myNotify() {
		for(Observer o : _obSet)
			o.update(this);
	}
	
	public void clickRestart() {
		myNotify2();
	}
	
	public void myNotify2() {
		for(Observer o : _obSet) {
			o.update2(this);
		}
	}
}
