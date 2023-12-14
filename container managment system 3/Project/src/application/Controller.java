package application;

import Model.Command;
import Model.ConcreteCommand1;
import Model.ConcreteCommand2;
import Model.ConcreteCommand3;
import Model.Container;
import Model.Model;
import Model.MyArrayList;
import View.MainView;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class Controller {
	private MainView _view;
	private Model _model;

	public Controller(MainView mainView, Model model) {
		_view = mainView;
		_model = model;
		_view.show(_model.getPort());

		EventHandler<MouseEvent> click = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				int x = (int)event.getX();
				int y = (int)event.getY();
				_model.getPort().setAllFramesToBlack(x, y);
				if (event.getButton() == MouseButton.PRIMARY) {
					_model.getPort().mark(x, y);
					_view.show(_model.getPort());
				}
			} 
		}; //event handler

		_view.addEventHandler(click);
		_view.addMoveButton();
		_view.addRestartButton();
		_view.add_addToCollection1Button();
		_view.add_addToCollection2Button();
		_view.addMyArrayListButton();
		_view.addJavaArrayListButton();
		_view.addRemove1Button();
		_view.addRemove2Button();
		_view.addMyButton();
		_view.addMyLabel();
		_view.addCommand();
		_view.addStartPosition();
		
		MyArrayList<Container> list = new MyArrayList<Container>(_model.getHashSet());
		list.attach(_view.getMyButton());
		list.attach(_view.getMyLabel());
		
		Command cmd1 = new ConcreteCommand1(_view.getScene());
		Command cmd2 = new ConcreteCommand2(_model);
		Command cmd3 = new ConcreteCommand3(_view);
		
		_model.copyStartPosition();

		_view.getMove().setOnAction(e -> {
			_model.getPort().move();
			cmd3.execute();
			_view.show(_model.getPort());
		});

		_view.getRestart().setOnAction(e -> {
			cmd2.execute();
			list.clickRestart();
			cmd3.execute();
			_view.show(_model.getPort());
		});

		_view.getAddToCollection1().setOnAction(e -> {
			_model.copyContainersToColl1();
			cmd3.execute();
			_view.show(_model.getPort());
		});
		
		_view.getAddToCollection2().setOnAction(e -> {
			_model.copyContainersToColl2();
			cmd3.execute();
			_view.show(_model.getPort());
		});
		
		_view.getMyArrayList().setOnAction(e -> {
			_model.copyContainersToMyArrayList();
			list.click();
			cmd3.execute();
			_view.show(_model.getPort());
		});
		
		_view.getJavaArrayList().setOnAction(e -> {
			_model.copyContainersToJavaArrayList();
			cmd3.execute();
			_view.show(_model.getPort());
		});
		
		_view.getRemove1().setOnAction(e -> {
			_model.removeContainers1();
			cmd3.execute();
			_view.show(_model.getPort());
		});
		
		_view.getRemove2().setOnAction(e -> {
			_model.removeContainers2();
			cmd3.execute();
			_view.show(_model.getPort());
		});
		
		_view.getMyButton().getButton().setOnAction(e -> {
			_model.getIterator(list);
			cmd3.execute();
			_view.show(_model.getPort());
		});
		
		_view.getCommand().setOnAction(e -> {
			cmd1.execute();
		});
		
		_view.getStartPosition().setOnAction(e -> {
			_model.printStartPosition();
			cmd3.execute();
			_view.show(_model.getPort());
		});
	}
}
