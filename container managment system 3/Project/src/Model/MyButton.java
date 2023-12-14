package Model;

import java.util.Objects;

import javafx.scene.control.Button;

public class MyButton extends Button implements Observer {
	
	private Button button;
	
	public MyButton(String msg) {
		button = new Button(msg);
		button.setVisible(false);
		button.setDisable(true);
	}
	
	public Button getButton() {
		return button;
	}

	public void setButton(Button button) {
		this.button = button;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(button);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyButton other = (MyButton) obj;
		return Objects.equals(button, other.button);
	}

	@Override
	public void update(MyArrayList<?> list) {
		// TODO Auto-generated method stub
		button.setVisible(true);
		button.setDisable(false);
	}

	@Override
	public void update2(MyArrayList<?> list) {
		// TODO Auto-generated method stub
		button.setVisible(false);
		button.setDisable(true);
	}
}
