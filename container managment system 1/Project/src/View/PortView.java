package View;

import java.util.Stack;
import Model.Container;
import Model.Port;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

public class PortView {
	
	public static final int MAX_NUM_OF_CONTAINERS = 21;
	private Stack<Container> _stackOfContainers;
	private Stack<Container> _unloadingStack;
	private Stack<Container> _uploadingStack;
	private int _currNumOfContainers, _currNumOfUnload, _currNumOfUpload;
	private int _unloadX, _unloadY;
	private int _truckTop;
	private boolean _isMark, _isUpload;

	public PortView(Port port) {
		_stackOfContainers = port.getStackOfContainers();
		_unloadingStack = port.getUnloadingStack();
		_uploadingStack = port.getUploadingStack();
		_currNumOfContainers = port.getCurrNumOfContainers();
		_currNumOfUnload = port.getCurrNumOfUnload();
		_currNumOfUpload = port.getCurrNumOfUpload();
		port.addAllContainers();
		_isMark = port.getIsMark();
		_isUpload = port.getIsUpload();
		_unloadX = port.getUnloadX();
		_unloadY = port.getUnloadY();
		_truckTop = port.getTruckTop();
	}
	
	public void show(Group root) {
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
		root.getChildren().add(ship);
		
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
		
		root.getChildren().addAll(wharf, truck, wheel1, wheel2, wheel3);
	}
	
}
