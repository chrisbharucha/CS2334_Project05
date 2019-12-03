import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HDApplication extends Application implements EventHandler<ActionEvent>{
	
	private HammingDist hammDist;
	
	private Label hammDistLabel;
	private TextField hammDistText;
	private Button showStation;
	private Slider slider;
	private ListView<String> list;
	private Label compareWith;
	private ChoiceBox<String> choiceBox;
	
	
	public static void main(String[] args) throws IOException {
		launch(args);
	}

	@Override
	public void start(javafx.stage.Stage primaryStage) throws Exception {
		//Creating a HammingDist object to use the classes' methods
		hammDist = new HammingDist();
		
		primaryStage.setTitle("HammingDistance");
		
		//creating the layout for the stage
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(10, 10, 10, 10));
		
		
		//hammDistLabel
		hammDistLabel = new Label("Enter Hamming Dist:");
		GridPane.setConstraints(hammDistLabel, 0, 0);
		
		//hammDistText
		hammDistText = new TextField("1");
		hammDistText.setEditable(false);
		hammDistText.setPrefWidth(25);
		GridPane.setConstraints(hammDistText, 1, 0);
		
		//slider
		initSlider();
		slider.valueProperty().addListener(new ChangeListener<Number>() {	
			@Override
			public void changed(ObservableValue<? extends Number> observableValue, 
	                   Number oldValue, Number newValue) {
				hammDistText.textProperty().setValue(String.valueOf(newValue.intValue()));
			}
		});
		
		//showStation button
		showStation = new Button("Show Station");
		GridPane.setConstraints(showStation, 0, 2);
		showStation.setOnAction(this);
		
		//list
		list = new ListView<>();
		GridPane.setConstraints(list, 0, 4);
		list.setEditable(false);
		list.setPrefWidth(50);
		list.setPrefHeight(128);
		
		//compareWith label
		compareWith = new Label("Compare with:");
		GridPane.setConstraints(compareWith, 0, 5);
		
		//choiceBox 
		choiceBox = new ChoiceBox<>();
		GridPane.setConstraints(choiceBox, 1, 5);
		ArrayList<String> stations = hammDist.getStations();
		choiceBox.getItems().addAll(stations);
		choiceBox.setValue("ACME");
		
		
		//adding everything to the grid
		grid.getChildren().addAll(hammDistLabel, hammDistText, slider, showStation
				, list, compareWith, choiceBox);
		
		//creating the scene
		Scene scene = new Scene(grid, 550, 650);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@Override
	public void handle(ActionEvent event) {
		if (event.getSource() == showStation) {
			int distance = Integer.parseInt(hammDistText.textProperty().getValue());
			ArrayList<String>listStations = hammDist.sameHammingDist(choiceBox.getValue(), distance);
			list.getItems().clear();
			list.getItems().addAll(listStations);
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
