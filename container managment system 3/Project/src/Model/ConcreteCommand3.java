package Model;

import View.MainView;

public class ConcreteCommand3 implements Command {

	private MainView view;
	
	public ConcreteCommand3(MainView view) {
		this.view = view;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		view.clear();
		view.addMoveButton();
		view.addRestartButton();
		view.add_addToCollection1Button();
		view.add_addToCollection2Button();
		view.addMyArrayListButton();
		view.addJavaArrayListButton();
		view.addRemove1Button();
		view.addRemove2Button();
		view.addMyButton();
		view.addMyLabel();
		view.addCommand();
		view.addStartPosition();
	}

}
