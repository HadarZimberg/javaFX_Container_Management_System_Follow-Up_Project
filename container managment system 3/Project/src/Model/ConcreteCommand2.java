package Model;

import Model.Model;

public class ConcreteCommand2 implements Command {

	private Model model;
	
	public ConcreteCommand2(Model model) {
		this.model = model;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		model.getPort().restart();
	}

}
