package Model;

import java.util.Objects;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class MyLabel extends Label implements Observer {
	
	private Label label;
	
	public MyLabel(String msg) {
		label = new Label(msg);
		label.setVisible(false);
	}
	
	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(label);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyLabel other = (MyLabel) obj;
		return Objects.equals(label, other.label);
	}

	@Override
	public void update(MyArrayList<?> list) {
		// TODO Auto-generated method stub
		label.setTextFill(Color.GREEN);
		label.setVisible(true);
	}

	@Override
	public void update2(MyArrayList<?> list) {
		// TODO Auto-generated method stub
		label.setVisible(false);
	}
}
