import com.iteration3.view.StatusView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class StatusViewTest extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		StatusView view = new StatusView();
		Scene scene =  new Scene(view,500,500);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Test StatusView");
		primaryStage.show();
		
		view.setTerrainType("Pasture");
		view.setRiverType("None");
		view.setRotateOption("Rotate River Use left and right arrow keys");
		
		view.highlightTerrainOption();
		
		
	}

	public static void main(String[] args) {
		Application.launch(args);
		
	}
}
