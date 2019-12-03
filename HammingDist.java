import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HammingDist {
	
	private	ArrayList<String> stations; //ArrayList that holds all the station ID's from Mesonet.txt
	private ArrayList<String> hammDistStations;
	
	/*
	 * This constructor initializes the ArrayLists and reads in and stores all of the MesoStations into
	 * the ArrayList
	 */
	public HammingDist() throws IOException {
		//initialize ArrayLists
		stations = new ArrayList<>();
		hammDistStations = new ArrayList<>();
		
		//Create BufferedReader to read in the MesoStations
		BufferedReader br = new BufferedReader(new FileReader("Mesonet.txt"));
		String dataLine = br.readLine();
		
		//add stations to the ArrayList
		while(dataLine != null) {
			stations.add(dataLine);
			dataLine = br.readLine();
		}
	}
	
	/*
	 * This method provides the calculations for part 1 of the application
	 */
	public ArrayList<String> sameHammingDist(String station, int distance) {
		
		for (int i = 0; i < stations.size(); ++i) {
			String testStation = stations.get(i);
			
			if (calcHammingDist(station, testStation) == distance) {
				hammDistStations.add(testStation);
			}
		}
		return hammDistStations;	
	}
	
	/*
	 * This method calculates the HammingDistance between two MesoStations
	 */
	public int calcHammingDist(String station1, String station2) {
		
		int distance = 0;
		
		for (int i = 0; i < 4; ++i) {
			char testChar = station2.charAt(i);
			char station1Char = station1.charAt(i);
			
			if (testChar != station1Char) {
				distance++;
			}
		}
		return distance;
	}
	
	
	
}
