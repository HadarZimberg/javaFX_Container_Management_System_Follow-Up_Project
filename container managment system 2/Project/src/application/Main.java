package application;
	
import Model.Model;
import View.MainView;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		MainView view = new MainView(stage);
		Model model = new Model();
		Controller controller = new Controller(view, model);
	}
}
