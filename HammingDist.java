import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HammingDist {
	
	private static final int NUM_DISTANCES = 5; //the number of distances needed is 0,1,2,3,4 --> so 5
	
	private	ArrayList<String> stations; //ArrayList that holds all the MesoStations from Mesonet.txt
	private int[] distances; //Array that holds the number of MesoStations that share a distance of 0,1,2,3,4
	
	/*
	 * This constructor initializes the ArrayLists and reads in and stores all of the MesoStations into
	 * the ArrayList
	 */
	public HammingDist() throws IOException {
		//initialize ArrayLists and Arrays
		stations = new ArrayList<>();
		distances = new int[NUM_DISTANCES];
		
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
		ArrayList<String> hamDistStations = new ArrayList<String>();
		for (int i = 0; i < stations.size(); ++i) {
			String testStation = stations.get(i);
			if (calcHammingDist(station, testStation) == distance) {
				hamDistStations.add(testStation);
			}
		} return hamDistStations;	
	}
	
	/*
	 * This method calculates the HammingDistance between two given MesoStations
	 */
	public int calcHammingDist(String station1, String station2) {
		int distance = 0;
		
		for (int i = 0; i < 4; ++i) {
			char testChar = station2.charAt(i);
			char station1Char = station1.charAt(i);
			
			if (testChar != station1Char) {
				distance++;
			}
		} return distance;
	}
	
	/*
	 * This method provides the calculations for part 2 of the application
	 */
	public int[] distanceCalc(String station) {
		distances[0] = sameHammingDist(station, 0).size();
		distances[1] = sameHammingDist(station, 1).size();
		distances[2] = sameHammingDist(station, 2).size();
		distances[3] = sameHammingDist(station, 3).size();
		distances[4] = sameHammingDist(station, 4).size();
		return distances;
	}
	
	/*
	 * Method used by HDApplication to access the station's ArrayList
	 */
	public ArrayList<String> getStations() {
		return stations;
	}
}
