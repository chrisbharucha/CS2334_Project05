import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HDApplication extends Application implements EventHandler<ActionEvent>{

	Button showStation;
	Slider slider;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(javafx.stage.Stage primaryStage) throws Exception {
		primaryStage.setTitle("HammingDistance");
		
		//initializing the showStation button
		showStation = new Button("Show Station");
		showStation.setOnAction(this);
		
		//initializing the slider
		slider = new Slider(0, 4, 1);
		slider.setShowTickMarks(true);
		slider.setShowTickLabels(true);
		slider.setMajorTickUnit(1);
		slider.setSnapToTicks(true);
		
		//creating the layout for the stage and adding the components to it
		GridPane gridpane = new GridPane();
		gridpane.getChildren().add(showStation);
		gridpane.getChildren().add(slider);
		
		
		Scene scene = new Scene(gridpane, 500, 600);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@Override
	public void handle(ActionEvent event) {
		if (event.getSource() == showStation) {
			System.out.println("FIX");
		}
	}
	
	
}
