package View;

import Model.Container;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

public class ContainerView {

	public static final int WIDTH = 100, HEIGHT = 40; //The containers have a uniform size
	private int _top, _left; //Determine the location of the container
	private int _width, _height; //Sizes
	private int _red, _green, _blue; //Determine the color of the container in RGB scale
	private int _frameRed, _frameGreen, _frameBlue; //Determine the color of the frame in RGB scale
	
	public ContainerView(Container container) {
		_top = container.getTop();
		_left = container.getLeft();
		_width = container.getWidth();
		_height = container.getHeight();
		_red = container.getRed();
		_green = container.getGreen();
		_blue = container.getBlue();
		_frameRed = container.getFrameRed();
		_frameGreen = container.getFrameGreen();
		_frameBlue = container.getFrameBlue();
	}
	
	public void show(Group root) {
		Rectangle container = new Rectangle(_left, _top, _width, _height);
		container.setFill(Color.rgb(_red, _green, _blue));
		container.setStroke(Color.rgb(_frameRed, _frameGreen, _frameBlue));
		container.setStrokeWidth(2);
		container.setStrokeType(StrokeType.INSIDE);
		root.getChildren().addAll(container);
	}
}
