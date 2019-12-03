import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HammingDist {
	
	private	ArrayList<String> stations; //ArrayList that holds all the station ID's from Mesonet.txt
	
	/*
	 * This constructor initializes the ArrayList and reads in and stores all of the MesoStations into
	 * the ArrayList
	 */
	public HammingDist() throws IOException{
		
		stations = new ArrayList<>(); //initialize the station array
		
		//Create BufferedReader to read in the MesoStations
		BufferedReader br = new BufferedReader(new FileReader("Mesonet.txt"));
		String dataLine = br.readLine();
		
		//add stations to the ArrayList
		while(dataLine != null) {
			stations.add(dataLine);
			dataLine = br.readLine();
		}
	}
	
	
}
