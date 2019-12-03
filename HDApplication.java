import java.io.IOException;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HDApplication extends Application implements EventHandler<ActionEvent>{

	Button showStation;
	Slider slider;
	Label hammDistLabel;
	
	public static void main(String[] args) throws IOException {
		launch(args);
	}

	@Override
	public void start(javafx.stage.Stage primaryStage) throws Exception {
		//Creating a HammingDist object to use the classes' methods
		HammingDist hammDist = new HammingDist();
		
		primaryStage.setTitle("HammingDistance");
		
		//creating the layout for the stage
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(10, 10, 10, 10));
		
		
		//hammDistLabel
		Label hammDistLabel = new Label("Enter Hamming Dist:");
		GridPane.setConstraints(hammDistLabel, 0, 0);
		
		//hammDistText
		TextField hammDistText = new TextField();
		hammDistText.setEditable(false);
		GridPane.setConstraints(hammDistText, 1, 0);
		
		
		//showStation button
		showStation = new Button("Show Station");
		GridPane.setConstraints(showStation, 0, 2);
		showStation.setOnAction(this);
		
		//slider
		initSlider();
		slider.valueProperty().addListener(new ChangeListener<Number>() {	
			@Override
			public void changed(ObservableValue<? extends Number> observableValue, 
	                   Number oldValue, Number newValue) {
				hammDistText.textProperty().setValue(String.valueOf(newValue.intValue()));
			}
		});
		
		
		grid.getChildren().addAll(hammDistLabel, hammDistText, showStation, slider);
		
		
		//creating the scene
		Scene scene = new Scene(grid, 550, 650);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@Override
	public void handle(ActionEvent event) {
		if (event.getSource() == showStation) {
			System.out.println("FIX");
		}
	}
	
	
	/*
	 * initializes the slider
	 */
	public void initSlider() {
		slider = new Slider(0, 4, 1);
		slider.setShowTickMarks(true);
		slider.setShowTickLabels(true);
		slider.setMajorTickUnit(1);
		slider.setMinorTickCount(0);
		slider.setSnapToTicks(true);
		
		
		
		GridPane.setConstraints(slider, 0, 1);
	}
	
	
	
}
