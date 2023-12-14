package Model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

public class Model {
	private Port _port;
	private Stack<Container.Memento> _stack;
	public static final int MAX_NUM_OF_CONTAINERS = 21;

	public Model() {
		_port = new Port();
		_stack = new Stack<>();
	}

	public Port getPort() {
		return _port;
	}

	public Stack<Container> getStackOfContainers() {
		return _port.getStackOfContainers();
	}

	public Stack<Container> getUnloadingStack() {
		return _port.getUnloadingStack();
	}

	public Stack<Container> getUploadingStack() {
		return _port.getUploadingStack();
	}

	public void addAllContainers() {
		_port.addAllContainers();
	}

	public void setLocation(Container curr) {
		_port.setLocation(curr);
	}

	public int getCurrNumOfContainers() {
		return _port.getCurrNumOfContainers();
	}


	public int getCurrNumOfUnload() {
		return _port.getCurrNumOfUnload();
	}


	public int getCurrNumOfUpload() {
		return _port.getCurrNumOfUpload();
	}


	public int getUnloadX() {
		return _port.getUnloadX();
	}


	public int getUnloadY() {
		return _port.getUnloadX();
	}


	public int getTruckTop() {
		return _port.getTruckTop();
	}


	public boolean getIsMark() {
		return _port.getIsMark();
	}


	public boolean getIsUpload() {
		return _port.getIsUpload();
	}

	public void setCurrNumOfContainers(int num) {
		_port.setCurrNumOfContainers(num);
	}

	public void setCurrNumOfUnloads(int num) {
		_port.setCurrNumOfUnloads(num);
	}

	public void setCurrNumOfUploads(int num) {
		_port.setCurrNumOfUploads(num);
	}

	public void setIsMark(boolean bool) {
		_port.setIsMark(bool);
	}

	public void setIsUpload(boolean bool) {
		_port.setIsUpload(bool);
	}

	public void setUnloadX(int x) {
		_port.setUnloadX(x);
	}

	public void setUnloadY(int y) {
		_port.setUnloadY(y);
	}

	public void setTruckTop(int num) {
		_port.setTruckTop(num);
	}

	public void mark(int x, int y) {
		_port.mark(x, y);
	}

	public void move() {
		_port.move();
	}

	public void setAllFramesToBlack(int x, int y) {
		_port.setAllFramesToBlack(x, y);
	}

	public void restart() {
		_port.restart();

	}




	/*________________Additions for course 10119________________*/
	
	
	/////////////___Part 1___/////////////

	public void copyContainersToColl1() {
		
		Set<Container> set = getTreeSet(); //getTreeSet() down in line 160
		//print with iterator:
		print(set);
	}

	public void copyContainersToColl2() {

		Set<Container> set = new HashSet<Container>(getTreeSet());
		//print with iterator:
		print(set);
		
	}

	public void print(Set<?> set) {
		Iterator<?> it = set.iterator();
		while (it.hasNext())
			System.out.println(it.next());
		System.out.println();
	}

	public TreeSet<Container> getTreeSet() {
		
		Stack<Container> copyStack = new Stack<Container>();
		Stack<Container> tempStack = new Stack<Container>();

		//copy the data from the original stack to local stack:
		for (int i = 0; i < getCurrNumOfContainers(); i++) { 
			copyStack.push(getStackOfContainers().peek());
			tempStack.push(getStackOfContainers().pop());
		}
		for (int i = 0; i < getCurrNumOfContainers(); i++) {
			getStackOfContainers().push(tempStack.pop());
		}

		//create collection that sorted by left coordinate:
		Set<Container> set = new TreeSet<>(new Comparator<Container>() {

			@Override
			public int compare(Container c1, Container c2) {
				// TODO Auto-generated method stub
				if(c2.getLeft() - c1.getLeft() == 0 && c2.getLeft() - c1.getLeft() == 0)
					return c2.toString().compareTo(c1.toString());
				return c2.getLeft() - c1.getLeft();
			}
		});

		//add containers to set:
		while (!copyStack.isEmpty()) {
			set.add(copyStack.pop());
		}

		return (TreeSet<Container>)set;
	}
	
	
	
	/////////////___Part 2___/////////////
	
	
	public HashSet<Container> getHashSet() {
		Set<Container> set = new HashSet<Container>(getTreeSet());
		return (HashSet<Container>)set;
	}
	
	public void copyContainersToMyArrayList() {
		
		MyArrayList<Container> list = new MyArrayList<Container>(getHashSet());
		printMyList(list);
	}
	
	public void copyContainersToJavaArrayList() {
		ArrayList<Container> list = new ArrayList<Container>(getHashSet());
		printList(list);
	}
	
	public void removeContainers1() {
		MyArrayList<Container> list = new MyArrayList<Container>(getHashSet());
		removeList1(list);
		printMyList(list);
	}
	
	public void removeContainers2() {
		ArrayList<Container> list = new ArrayList<Container>(getHashSet());
		removeList2(list);
		printList(list);
	}
	
	public void printMyList(MyArrayList<Container> list) {
		Iterator<?> it = list.iterator();
		while (it.hasNext())
			System.out.println(it.next());
		System.out.println();
	}
	
	public void printList(ArrayList<Container> list) {
		Iterator<?> it = list.iterator();
		while (it.hasNext())
			System.out.println(it.next());
		System.out.println();
	}
	
	public void removeList1(MyArrayList<Container> list) {
		Iterator<?> it = list.iterator();
		while (it.hasNext()) {
			Container container = (Container)it.next();
			if(container.getRed() == 0)
				it.remove();
		}
	}
	
	public void removeList2(ArrayList<Container> list) {
		Iterator<?> it = list.iterator();
		while (it.hasNext()) {
			Container container = (Container)it.next();
			if(container.getRed() == 0)
				it.remove();
		}
	}
	
	public void getIterator(MyArrayList<Container> list) {
		MyArrayList<Container> alist = new MyArrayList<Container>(getHashSet());
		printMyList(alist);
	}	
	
	
	/////////////___Part 3___/////////////
	
	
	public void copyStartPosition() {
		Stack<Container> tempStack = new Stack<Container>();

		for (int i = 0; i < MAX_NUM_OF_CONTAINERS; i++) { 
			Container.Memento m = getStackOfContainers().peek().createMemento();
			_stack.push(m);
			tempStack.push(getStackOfContainers().pop());
		}
		for (int i = 0; i < MAX_NUM_OF_CONTAINERS; i++) {
			getStackOfContainers().push(tempStack.pop());
		}
	}
	
	public void printStartPosition() {
		Stack<Container.Memento> tempStack = new Stack<>();

		for (int i = 0; i < MAX_NUM_OF_CONTAINERS; i++) { 
			Container.Memento m = _stack.pop();
			System.out.println(m.toString());
			tempStack.push(m);
		}
		System.out.println();
		for (int i = 0; i < MAX_NUM_OF_CONTAINERS; i++) {
			_stack.push(tempStack.pop());
		}
	}
	
	
}
