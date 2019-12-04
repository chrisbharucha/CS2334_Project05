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
	private Button calcHD;
	private Label distance0;
	private TextField distance0Text;
	private Label distance1;
	private TextField distance1Text;
	private Label distance2;
	private TextField distance2Text;
	private Label distance3;
	private TextField distance3Text;
	private Label distance4;
	private TextField distance4Text;
	private Button addStation;
	private TextField stationText;
	
	
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
		
		//calcHD button
		calcHD = new Button("Calculate HD");
		GridPane.setConstraints(calcHD, 0, 6);
		calcHD.setOnAction(this);
		
		//distance0 label
		distance0 = new Label("Distance 0");
		GridPane.setConstraints(distance0, 0, 7);
		
		//distance0Text
		distance0Text = new TextField();
		distance0Text.setEditable(false);
		distance0Text.setPrefWidth(25);
		GridPane.setConstraints(distance0Text, 1, 7);
		
		//distance1 label
		distance1 = new Label("Distance 1");
		GridPane.setConstraints(distance1, 0, 8);
		
		//distance1Text
		distance1Text = new TextField();
		distance1Text.setEditable(false);
		distance1Text.setPrefWidth(25);
		GridPane.setConstraints(distance1Text, 1, 8);
		
		//distance2 label
		distance2 = new Label("Distance 2");
		GridPane.setConstraints(distance2, 0, 9);
		
		//distance2Text
		distance2Text = new TextField();
		distance2Text.setEditable(false);
		distance2Text.setPrefWidth(25);
		GridPane.setConstraints(distance2Text, 1, 9);
		
		//distance3 label
		distance3 = new Label("Distance 3");
		GridPane.setConstraints(distance3, 0, 10);
		
		//distance3Text
		distance3Text = new TextField();
		distance3Text.setEditable(false);
		distance3Text.setPrefWidth(25);
		GridPane.setConstraints(distance3Text, 1, 10);
		
		//distance4 label
		distance4 = new Label("Distance 4");
		GridPane.setConstraints(distance4, 0, 11);
		
		//distance4Text
		distance4Text = new TextField();
		distance4Text.setEditable(false);
		distance4Text.setPrefWidth(25);
		GridPane.setConstraints(distance4Text, 1, 11);
		
		//addStation button
		addStation = new Button("Add Station");
		GridPane.setConstraints(addStation, 0, 12);
		addStation.setOnAction(this);
		
		//stationText
		stationText = new TextField();
		stationText.setPrefWidth(25);
		GridPane.setConstraints(stationText, 1, 12);
		
		//adding everything to the grid
		grid.getChildren().addAll(hammDistLabel, hammDistText, slider, showStation
				, list, compareWith, choiceBox, calcHD, distance0, distance0Text, distance1, 
				distance1Text, distance2, distance2Text, distance3, distance3Text, distance4
				, distance4Text, addStation, stationText);
		
		//creating the scene
		Scene scene = new Scene(grid, 550, 650);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/*
	 * These handle the cases of when the button is pressed
	 */
	@Override
	public void handle(ActionEvent event) {
		if (event.getSource() == showStation) {
			int distance = Integer.parseInt(hammDistText.textProperty().getValue());
			ArrayList<String>listStations = hammDist.sameHammingDist(choiceBox.getValue(), distance);
			list.getItems().clear();
			list.getItems().addAll(listStations);
		}
		else if (event.getSource() == calcHD) {
			int[] distances = hammDist.distanceCalc(choiceBox.getValue());
			distance0Text.textProperty().setValue(String.valueOf(distances[0]));
			distance1Text.textProperty().setValue(String.valueOf(distances[1]));
			distance2Text.textProperty().setValue(String.valueOf(distances[2]));
			distance3Text.textProperty().setValue(String.valueOf(distances[3]));
			distance4Text.textProperty().setValue(String.valueOf(distances[4]));
		}
		else if (event.getSource() == addStation) {
			String station = stationText.textProperty().getValue().toUpperCase();
			if (station.equals("")) {
			}
			else {
				choiceBox.getItems().add(station);
				stationText.clear();
			}
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
