package Model;

import java.util.Random;
import java.util.Stack;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Port {
	public static final int MAX_NUM_OF_CONTAINERS = 21;
	private Stack<Container> _stackOfContainers;
	private Stack<Container> _unloadingStack;
	private Stack<Container> _uploadingStack;
	private int _currNumOfContainers, _currNumOfUnload, _currNumOfUpload;
	private int _unloadX, _unloadY;
	private int _truckTop;
	private boolean _isMark, _isUpload;
	
	public Port() {
		_stackOfContainers = new Stack<Container>();
		_unloadingStack = new Stack<Container>();
		_uploadingStack = new Stack<Container>();
		setCurrNumOfContainers(0);
		setCurrNumOfUnloads(0);
		setCurrNumOfUploads(0);
		addAllContainers();
		setIsMark(false);
		setIsUpload(false);
		setUnloadX(790);
		setUnloadY(480);
		setTruckTop(450);
	}

	public Port(Stack<Container> stackOfContainers, Stack<Container> unloadingStack, Stack<Container> uploadingStack,
			int currNumOfContainers, int currNumOfUnload, int currNumOfUpload, int unloadX, int unloadY,
			int truckTop, boolean isMark, boolean isUpload) {
		super();
		this._stackOfContainers = stackOfContainers;
		this._unloadingStack = unloadingStack;
		this._uploadingStack = uploadingStack;
		this._currNumOfContainers = currNumOfContainers;
		this._currNumOfUnload = currNumOfUnload;
		this._currNumOfUpload = currNumOfUpload;
		this._unloadX = unloadX;
		this._unloadY = unloadY;
		this._truckTop = truckTop;
		this._isMark = isMark;
		this._isUpload = isUpload;
	}
	
	public Stack<Container> getStackOfContainers() {
		return _stackOfContainers;
	}
	
	public Stack<Container> getUnloadingStack() {
		return _unloadingStack;
	}
	
	public Stack<Container> getUploadingStack() {
		return _uploadingStack;
	}
	
	public int getCurrNumOfContainers() {
		return _currNumOfContainers;
	}


	public int getCurrNumOfUnload() {
		return _currNumOfUnload;
	}


	public int getCurrNumOfUpload() {
		return _currNumOfUpload;
	}


	public int getUnloadX() {
		return _unloadX;
	}


	public int getUnloadY() {
		return _unloadY;
	}


	public int getTruckTop() {
		return _truckTop;
	}


	public boolean getIsMark() {
		return _isMark;
	}


	public boolean getIsUpload() {
		return _isUpload;
	}
	
	public void setCurrNumOfContainers(int num) {
		_currNumOfContainers = num;
	}

	public void setCurrNumOfUnloads(int num) {
		_currNumOfUnload = num;
	}

	public void setCurrNumOfUploads(int num) {
		_currNumOfUpload = num;
	}

	public void setIsMark(boolean bool) {
		_isMark = bool;
	}

	public void setIsUpload(boolean bool) {
		_isUpload = bool;
	}

	public void setUnloadX(int x) {
		_unloadX = x;
	}

	public void setUnloadY(int y) {
		_unloadY = y;
	}

	public void setTruckTop(int num) {
		_truckTop = num;
	}

	public void addAllContainers() {
		Random rnd = new Random();
		for (int i = 0; i < MAX_NUM_OF_CONTAINERS; i++) {
			Container container = new Container(0, 0, rnd.nextInt(3), rnd.nextInt(3), rnd.nextInt(255));
			setLocation(container);
			_stackOfContainers.push(container);
			_currNumOfContainers++;
		}//for
	}

	public void setLocation(Container curr) {
		switch (_currNumOfContainers) { //create a heap of containers in the port 
		case 0:
			curr.setTop(320);
			curr.setLeft(50);
			break;
		case 1:
			curr.setTop(320);
			curr.setLeft(150);
			break;
		case 2:
			curr.setTop(320);
			curr.setLeft(250);
			break;
		case 3:
			curr.setTop(320);
			curr.setLeft(350);
			break;
		case 4:		
			curr.setTop(320);
			curr.setLeft(450);
			break;
		case 5:
			curr.setTop(320);
			curr.setLeft(550);
			break;
		case 6:
			curr.setTop(280);
			curr.setLeft(100);
			break;
		case 7:
			curr.setTop(280);
			curr.setLeft(200);
			break;
		case 8:
			curr.setTop(280);
			curr.setLeft(300);
			break;
		case 9:
			curr.setTop(280);
			curr.setLeft(400);
			break;
		case 10:
			curr.setTop(280);
			curr.setLeft(500);
			break;
		case 11:
			curr.setTop(240);
			curr.setLeft(150);
			break;
		case 12:
			curr.setTop(240);
			curr.setLeft(250);
			break;
		case 13:
			curr.setTop(240);
			curr.setLeft(350);
			break;
		case 14:
			curr.setTop(240);
			curr.setLeft(450);
			break;
		case 15:
			curr.setTop(200);
			curr.setLeft(200);
			break;
		case 16:
			curr.setTop(200);
			curr.setLeft(300);
			break;
		case 17:
			curr.setTop(200);
			curr.setLeft(400);
			break;
		case 18:
			curr.setTop(160);
			curr.setLeft(250);
			break;
		case 19:
			curr.setTop(160);
			curr.setLeft(350);
			break;
		case 20:
			curr.setTop(120);
			curr.setLeft(300);
			break;
		default:
			break;
		}//switch
	}
	
	public void mark(int x, int y) {
		Stack<Container> tempStack = new Stack<Container>();
		int counter = 0;
		for (int i = 0; i < _currNumOfContainers; i++) { 
			Container curr = _stackOfContainers.peek();
			if( y >= curr.getTop() && x >= curr.getLeft())
			{
				if ( y >= curr.getTop() && x <= curr.getLeft()+100)
				{
					if( y <= curr.getTop()+40 && x <= curr.getLeft()+100)
					{
						if( y <= curr.getTop() + 40 && x >= curr.getLeft()) {
							curr.setFrameRed(255);
							setIsMark(true);
							break;
						}
					}
				}
			}

			tempStack.push(_stackOfContainers.pop());
			counter++;

		}//for

		for (int i = 0; i < counter; i++) {
			_stackOfContainers.push(tempStack.pop());
		}//for
	}
	
	public void move() {
		if (_isUpload) { //We already upload on truck the selected container
			if(_unloadingStack.empty()) { //All the rest just returned to ship
				setIsUpload(false);
				setUnloadY(480);
				return;
			}//if
			Container temp = _unloadingStack.pop();
			_stackOfContainers.push(temp);
			_currNumOfUnload--;
			setLocation(_stackOfContainers.peek());
			_currNumOfContainers++;
			return;
		}//if

		else if( _isMark == false) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Note!");
			alert.setContentText("There's no marked conteiner");
			alert.showAndWait();
			return;
		}//if

		Container curr = _stackOfContainers.pop();
		_currNumOfContainers--;

		if ( curr.getFrameRed() == 255 ) { //Red frame
			curr.setTop(_truckTop);
			curr.setLeft(320);
			curr.setFrameRed(0);
			setIsMark(false);
			_uploadingStack.push(curr);
			_currNumOfUpload++;
			setIsUpload(true);
			_truckTop -= 40;
		}//if

		else {
			curr.setTop(_unloadY);
			curr.setLeft(_unloadX);
			_unloadingStack.push(curr);
			_currNumOfUnload++;
			setUnloadY(_unloadY-40);
		}//else
	}
	
	public void setAllFramesToBlack(int x, int y) {
		if(x <= 65 && y <= 65)
			return; //Because of the location of the "move" button
		Stack<Container> tempStack = new Stack<Container>();
		for (int i = 0; i < _currNumOfContainers; i++) {
			_stackOfContainers.peek().setFrameRed(0);
			tempStack.push(_stackOfContainers.pop());
		}

		for (int i = 0; i < _currNumOfContainers; i++) {
			_stackOfContainers.push(tempStack.pop());
		}
		setIsMark(false);
	}

	public void restart() {
		for (int i = 0; i < _currNumOfContainers; i++) {
			_stackOfContainers.pop();
		}
		for (int i = 0; i < _currNumOfUnload; i++) {
			_unloadingStack.pop();
		}
		for (int i = 0; i < _currNumOfUpload; i++) {
			_uploadingStack.pop();
		}
		setCurrNumOfContainers(0);
		setCurrNumOfUnloads(0);
		setCurrNumOfUploads(0);
		addAllContainers();
		setIsMark(false);
		setIsUpload(false);
		setUnloadX(790);
		setUnloadY(480);
		setTruckTop(450);
	}		
}
