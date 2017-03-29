import com.iteration3.controller.ControlDispatch;
import com.iteration3.model.GameModel;
import com.iteration3.view.GameWindow;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class StatusCyclingTest extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		GameModel model = new GameModel();
		GameWindow window = new GameWindow(1221,1000);
		ControlDispatch control = new ControlDispatch(model,window);
		
		 Scene scene = new Scene(window, 800, 800);
	        primaryStage.setScene(scene);
	        primaryStage.setTitle("Map Editor");
	        primaryStage.show();
		
	}

	public static void main(String args[]) {
		Application.launch(args);
	}
}
