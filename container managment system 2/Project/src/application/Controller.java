package application;

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
		
		MyArrayList<Container> list = new MyArrayList<Container>(_model.getHashSet());
		list.attach(_view.getMyButton());
		list.attach(_view.getMyLabel());

		_view.getMove().setOnAction(e -> {
			_model.getPort().move();
			_view.clear();
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
			_view.show(_model.getPort());
		});

		_view.getRestart().setOnAction(e -> {
			_model.getPort().restart();
			list.clickRestart();
			_view.clear();
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
			_view.show(_model.getPort());
		});

		_view.getAddToCollection1().setOnAction(e -> {
			_model.copyContainersToColl1();
			_view.clear();
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
			_view.show(_model.getPort());
		});
		
		_view.getAddToCollection2().setOnAction(e -> {
			_model.copyContainersToColl2();
			_view.clear();
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
			_view.show(_model.getPort());
		});
		
		_view.getMyArrayList().setOnAction(e -> {
			_model.copyContainersToMyArrayList();
			list.click();
			_view.clear();
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
			_view.show(_model.getPort());
		});
		
		_view.getJavaArrayList().setOnAction(e -> {
			_model.copyContainersToJavaArrayList();
			_view.clear();
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
			_view.show(_model.getPort());
		});
		
		_view.getRemove1().setOnAction(e -> {
			_model.removeContainers1();
			_view.clear();
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
			_view.show(_model.getPort());
		});
		
		_view.getRemove2().setOnAction(e -> {
			_model.removeContainers2();
			_view.clear();
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
			_view.show(_model.getPort());
		});
		
		_view.getMyButton().getButton().setOnAction(e -> {
			_model.getIterator(list);
			_view.clear();
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
			_view.show(_model.getPort());
		});
	}
}
