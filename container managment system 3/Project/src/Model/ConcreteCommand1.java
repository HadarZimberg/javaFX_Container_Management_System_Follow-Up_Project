package Model;

import javafx.scene.Scene;
import javafx.scene.paint.Color;

public class ConcreteCommand1 implements Command {
	
	private Scene scene;
	
	public ConcreteCommand1(Scene scene) {
		this.scene = scene;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		scene.setFill(Color.color(Math.random(), Math.random(), Math.random()));
	}

}
