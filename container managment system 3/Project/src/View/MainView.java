package View;

import java.util.Stack;

import Model.Command;
import Model.Container;
import Model.MyButton;
import Model.MyLabel;
import Model.Port;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;

public class MainView {
	private Stage _stage;
	private Group _root;
	private Scene _scene;
	private Button _move, _restart, _addToCollection1, _addToCollection2;
	private Button _myArrayList, _javaArrayList, _remove1, _remove2;
	private MyButton _myButton;
	private Button _command, _startPosition;
	private MyLabel _myLabel;
	private Port _port;

	public MainView(Stage stage) {
		_stage = stage;
		_root = new Group();
		_scene = new Scene(_root, 900, 600,Color.LIGHTBLUE);
		_stage.setScene(_scene);
		_stage.setResizable(false);
		_stage.show();

		_port = new Port();

		_move = new Button("move");
		_move.setLayoutX(20);
		_move.setLayoutY(20);
		_move.setPrefHeight(40);

		_restart = new Button("restart");
		_restart.setLayoutX(20);
		_restart.setLayoutY(70);
		_restart.setPrefHeight(40);
		
		_addToCollection1 = new Button("add to collection 1");
		_addToCollection1.setLayoutX(20);
		_addToCollection1.setLayoutY(150);
		_addToCollection1.setPrefHeight(40);
		
		_addToCollection2 = new Button("add to collection 2");
		_addToCollection2.setLayoutX(20);
		_addToCollection2.setLayoutY(200);
		_addToCollection2.setPrefHeight(40);
		
		_myArrayList = new Button("My Array List");
		_myArrayList.setLayoutX(110);
		_myArrayList.setLayoutY(20);
		_myArrayList.setPrefHeight(40);
		
		_javaArrayList = new Button("Java Array List");
		_javaArrayList.setLayoutX(210);
		_javaArrayList.setLayoutY(20);
		_javaArrayList.setPrefHeight(40);
		
		_remove1 = new Button("remove 1");
		_remove1.setLayoutX(110);
		_remove1.setLayoutY(70);
		_remove1.setPrefHeight(40);
		
		_remove2 = new Button("remove 2");
		_remove2.setLayoutX(230);
		_remove2.setLayoutY(70);
		_remove2.setPrefHeight(40);
		
		_myButton = new MyButton("observer");
		_myButton.getButton().setLayoutX(350);
		_myButton.getButton().setLayoutY(20);
		_myButton.getButton().setPrefHeight(40);
		
		_myLabel = new MyLabel("Iterator Has Been Created");
		_myLabel.getLabel().setLayoutX(330);
		_myLabel.getLabel().setLayoutY(60);
		_myLabel.getLabel().setTextFill(Color.GREEN);
		
		_command = new Button("change background");
		_command.setLayoutX(550);
		_command.setLayoutY(20);
		_command.setPrefHeight(40);
		
		_startPosition = new Button("get start position of containers");
		_startPosition.setLayoutX(550);
		_startPosition.setLayoutY(70);
		_startPosition.setPrefHeight(40);
	}

	public Button getMove() {
		return _move;
	}

	public Button getRestart() {
		return _restart;
	}
	
	public Button getAddToCollection1() {
		return _addToCollection1;
	}
	
	public Button getAddToCollection2() {
		return _addToCollection2;
	}
	
	public Button getMyArrayList() {
		return _myArrayList;
	}
	
	public Button getJavaArrayList() {
		return _javaArrayList;
	}
	
	public Button getRemove1() {
		return _remove1;
	}
	
	public Button getRemove2() {
		return _remove2;
	}
	
	public MyButton getMyButton() {
		return _myButton;
	}
	
	public MyLabel getMyLabel() {
		return _myLabel;
	}
	
	public Button getCommand() {
		return _command;
	}
	
	public Button getStartPosition() {
		return _startPosition;
	}

	public void addEventHandler(EventHandler<MouseEvent> event) {
		_scene.addEventHandler(MouseEvent.MOUSE_CLICKED, event);
	}

	public void addMoveButton() {
		_root.getChildren().add(_move);
	}

	public void addRestartButton() {
		_root.getChildren().add(_restart);
	}
	
	public void add_addToCollection1Button() {
		_root.getChildren().add(_addToCollection1);
	}
	
	public void add_addToCollection2Button() {
		_root.getChildren().add(_addToCollection2);
	}
	
	public void addMyArrayListButton() {
		_root.getChildren().add(_myArrayList);
	}
	
	public void addJavaArrayListButton() {
		_root.getChildren().add(_javaArrayList);
	}
	
	public void addRemove1Button() {
		_root.getChildren().add(_remove1);
	}
	
	public void addRemove2Button() {
		_root.getChildren().add(_remove2);
	}
	
	public void addMyButton() {
		_root.getChildren().add(_myButton.getButton());
	}
	
	public void addMyLabel() {
		_root.getChildren().add(_myLabel.getLabel());
	}
	
	public void addCommand() {
		_root.getChildren().add(_command);
	}
	
	public void addStartPosition() {
		_root.getChildren().add(_startPosition);
	}

	public void clear() {
		_root.getChildren().clear();
	}

	public Group getRoot() {
		return _root;
	}
	
	public Scene getScene() {
		return _scene;
	}

	public void show(Port port) {
		Polygon ship = new Polygon();
		ship.getPoints().addAll(new Double[] {
				25.0, 520.0,
				780.0, 520.0,
				880.0, 360.0,
				10.0, 360.0
		});
		ship.setFill(Color.DARKRED);
		ship.setStroke(Color.BLACK);
		ship.setStrokeWidth(1);
		_root.getChildren().add(ship);
		
		Rectangle wharf = new Rectangle();
		//sizes according to the window size:
		wharf.setX(0);
		wharf.setY(520);
		wharf.setWidth(900);
		wharf.setHeight(80);
		wharf.setFill(Color.GREY);
		wharf.setStroke(Color.BLACK);
		wharf.setStrokeWidth(1);
		
		Polygon truck = new Polygon();
		truck.getPoints().addAll(new Double[] {
				300.0, 450.0,
				250.0, 450.0,
				250.0, 510.0,
				300.0, 510.0,
				300.0, 500.0,
				500.0, 500.0,
				500.0, 490.0,
				300.0, 490.0
		});
		truck.setFill(Color.LIGHTGOLDENRODYELLOW);
		truck.setStroke(Color.ROSYBROWN);
		truck.setStrokeWidth(3);
		truck.setStrokeType(StrokeType.INSIDE);

		Circle wheel1 = new Circle();
		wheel1.setCenterX(280);
		wheel1.setCenterY(510);
		wheel1.setRadius(10);
		Circle wheel2 = new Circle();
		wheel2.setCenterX(440);
		wheel2.setCenterY(510);
		wheel2.setRadius(10);
		Circle wheel3 = new Circle();
		wheel3.setCenterX(470);
		wheel3.setCenterY(510);
		wheel3.setRadius(10);
		
		_root.getChildren().addAll(wharf, truck, wheel1, wheel2, wheel3);

		Stack<Container> tempStack = new Stack<Container>();
		for (int i = 0; i < port.getCurrNumOfContainers(); i++) { //Show the containers
			Container curr = port.getStackOfContainers().pop();
			ContainerView c1 = new ContainerView(curr);
			c1.show(_root);
			tempStack.push(curr);
		}
		for (int i = 0; i < port.getCurrNumOfContainers(); i++) {
			port.getStackOfContainers().push(tempStack.pop());
		}

		for (int i = 0; i < port.getCurrNumOfUnload(); i++) { //Show the containers
			Container curr = port.getUnloadingStack().pop();
			ContainerView c2 = new ContainerView(curr);
			c2.show(_root);
			tempStack.push(curr);
		}
		for (int i = 0; i < port.getCurrNumOfUnload(); i++) {
			port.getUnloadingStack().push(tempStack.pop());
		}

		for (int i = 0; i < port.getCurrNumOfUpload(); i++) { //Show the containers
			Container curr = port.getUploadingStack().pop();
			ContainerView c3 = new ContainerView(curr);
			c3.show(_root);
			tempStack.push(curr);
		}
		for (int i = 0; i < port.getCurrNumOfUpload(); i++) {
			port.getUploadingStack().push(tempStack.pop());
		}	
	}

}
