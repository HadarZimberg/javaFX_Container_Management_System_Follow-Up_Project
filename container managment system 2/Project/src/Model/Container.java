package Model;

public class Container {
	
	public static final int WIDTH = 100, HEIGHT = 40; //The containers have a uniform size
	private int _top, _left; //Determine the location of the container
	private int _width, _height; //Sizes
	private int _red, _green, _blue; //Determine the color of the container in RGB scale
	private int _frameRed, _frameGreen, _frameBlue; //Determine the color of the frame in RGB scale
	
	public Container(int top, int left, int red, int green, int blue) {
		setTop(top);
		setLeft(left);
		setWidth();
		setHeight();
		setRed(red);
		setGreen(green);
		setBlue(blue);
		setFrameRed(0);
		setFrameGreen(0);
		setFrameBlue(0);
	}
	
	public int getTop() {
		return _top;
	}
	
	public int getLeft() {
		return _left;
	}
	
	public int getWidth() {
		return _width;
	}
	
	public int getHeight() {
		return _height;
	}
	
	public int getRed() {
		return _red;
	}
	
	public int getGreen() {
		return _green;
	}
	
	public int getBlue() {
		return _blue;
	}
	
	public int getFrameRed() {
		return _frameRed;
	}
	
	public int getFrameGreen() {
		return _frameGreen;
	}
	
	public int getFrameBlue() {
		return _frameBlue;
	}
	
	public void setTop(int top) {
		_top = top;
	}
	
	public void setLeft(int left) {
		_left = left;
	}
	
	public void setWidth() {
		_width = WIDTH;
	}
	
	public void setHeight() {
		_height = HEIGHT;
	}
	
	public void setRed(int red) {
		if( !(isValid(red)) ) {
			_red = 0;
			return;
		}
		_red = red;
	}
	
	public void setGreen(int green) {
		if( !(isValid(green)) ) {
			_green = 0;
			return;
		}
		_green = green;
	}
	
	public void setBlue(int blue) {
		if( !(isValid(blue)) ) {
			_blue = 0;
			return;
		}
		_blue = blue;
	}
	
	public void setFrameRed(int red) {
		if( !(isValid(red)) ) {
			_frameRed = 0;
			return;
		}
		_frameRed = red;
	}
	
	public void setFrameGreen(int green) {
		if( !(isValid(green)) ) {
			_frameGreen = 0;
			return;
		}
		_frameGreen = green;
	}
	
	public void setFrameBlue(int blue) {
		if( !(isValid(blue)) ) {
			_frameBlue = 0;
			return;
		}
		_frameBlue = blue;
	}
	
	public boolean isValid(int num) { //Check if the number that accepts as a parameter is in range 0-255
		if (num < 0 || num > 255)
			return false;
		return true;
	}
	
	public String toString() {
		return "top: " + getTop() + "\t" +
				"left: " + getLeft() + "\t" +
				"R: " + getRed() + "\t" +
				"G: " + getGreen() + "\t" +
				"B: " + getBlue();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + _red;
		result = prime * result + _green;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Container other = (Container) obj;
		if (_red != other.getRed())
			return false;
		if (_green != other.getGreen())
			return false;
		return true;
	}

}
