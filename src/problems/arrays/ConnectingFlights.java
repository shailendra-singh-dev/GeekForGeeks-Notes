package problems.arrays;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;


public class ConnectingFlights {

	/**
	 * Flights should be in sorted order.
	 * inputs: source destination 
	 * output:
	 * direct or connecting flights based on price decreasing order.
	 * e.g BLR-HYD
	 * 1. BLR- HYD 10000
	 * 2. BLR - MUMBAI- HYD 10000
	 * 3. BLR - PUNE - MUMBAI - HYD 7000
	 * 4. BLR- HYD 5000
	 * 5. BLR- HYD 4000
	 */
	
	private final static ArrayList<Flight> mFlights = new ArrayList<Flight>();

	public static void test() {
		insertAndFetchFligts();
	}

	private static void insertAndFetchFligts() {
		String departure = "BLR";
		String arrival = "HYD";
		
		Flight flight1=new Flight("BLR", "HYD", 10000);
		Flight flight2=new Flight("BLR", "HYD", 20000);
		
		Flight flight3=new Flight("BLR", "MUMBAI", 1000);
		Flight flight4=new Flight("MUMBAI", "HYD", 7000);
		
		Flight flight5=new Flight("BLR", "PUNE", 2000);
		Flight flight6=new Flight("PUNE", "HYD", 8000);
		
		mFlights.add(flight1);
		mFlights.add(flight2);
		mFlights.add(flight3);
		mFlights.add(flight4);
		mFlights.add(flight5);
		mFlights.add(flight6);

		ArrayList<Flight> directFlights = getAllDirectFlights(departure, arrival);
		System.out.println("directFlights:"+directFlights);
		
		ArrayList<ArrayList<Flight>> connectingFlights = getAllConnectingFlights(departure,arrival);
		System.out.println("connectingFlights:"+connectingFlights);
		
		final HashMap<Integer, String> map=new HashMap<Integer, String>();
		for(ArrayList<Flight> item:connectingFlights){
			map.put(getAllConnectingFlightsTotalPrice(item),getAllConnectingFlightsTotalString(item));
		}
		for(Flight item:directFlights){
			map.put(item.getPrice(),getAllDirectFlightTotalString(item));
		}

		Set<Integer> keyset = map.keySet();
		ArrayList<Integer> keys = new ArrayList<Integer>(keyset);

		keys = getDecreasingIntArrayFromList(keys);
		
		for(Integer intValue:keys){
			System.out.print(intValue +" " +map.get(intValue));
			System.out.println();
		}
		
	}
	
	private static ArrayList<Integer> getDecreasingIntArrayFromList(ArrayList<Integer> list) {
		int[] array = new int[list.size()];
		int i = 0;
		for (int value : list) {
			array[i++] = value;
		}
		
		int[] sortedArray = data_structures.arrays.SelectionSort.selectionSortDecreasingOrder(array);		
		ArrayList<Integer> newList = new ArrayList<Integer>();
		for (int value : sortedArray) {
			newList.add(value);
		}
		return newList;
	}
	

	private static ArrayList<ArrayList<Flight>> getAllConnectingFlights(String departure,
			String arrival) {
		ArrayList<ArrayList<Flight>> allConnectingFlights = new ArrayList<ArrayList<Flight>>();
		
		for(int l=0;l<mFlights.size();l++){
			ArrayList<Flight> connectingFlights = new ArrayList<Flight>();
			int k=0;
			for (int i = 0; i < mFlights.size() - 1; i++) {
				for (int j = i+1; j < mFlights.size(); j++) {
					Flight jFlight= mFlights.get(j);
					Flight iFlight= mFlights.get(i);
//					System.out.println("Comparing " + jFlight +" with "+ iFlight);
					if (iFlight.departure.equals(jFlight.arrival) && iFlight.departure.equals(departure)) {
						connectingFlights.set(k++, iFlight);
					}
					if (iFlight.departure.equals(jFlight.arrival) && iFlight.departure.equals(departure)) {
						connectingFlights.set(k++, iFlight);
					}
				}
			}
			
//			System.out.println("1.connectingFlights:"+connectingFlights);
			if(!allConnectingFlights.contains(connectingFlights)){
				mFlights.removeAll(connectingFlights);
				allConnectingFlights.add(connectingFlights);		
			}					
		}
//		System.out.println("2.allConnectingFlights:"+allConnectingFlights);
		return allConnectingFlights.size() > 0 ? allConnectingFlights : null;
	}
	
	private static int getAllConnectingFlightsTotalPrice(ArrayList<Flight> connectingFlights){
		int cost = 0;
		for (Flight flight : connectingFlights) {
			 cost += flight.getPrice();
		}
		return cost;
	}
	private static String getAllConnectingFlightsTotalString(ArrayList<Flight> connectingFlights){
		StringBuilder stringBuilder=new StringBuilder();
		for (int i = 0; i < connectingFlights.size() - 1; i++) {
			for (int j = i+1; j < connectingFlights.size(); j++) {
				Flight jFlight= connectingFlights.get(j);
				Flight iFlight= connectingFlights.get(i);
				System.out.println("Comparing " + jFlight +" with "+ iFlight);
				if (iFlight.arrival.equals(jFlight.departure)) {
					stringBuilder.append(iFlight.departure);
					stringBuilder.append(" ");
					stringBuilder.append(iFlight.arrival);
					stringBuilder.append(" ");
					stringBuilder.append(jFlight.arrival);
				}
				if (jFlight.arrival.equals(iFlight.departure)) {
					stringBuilder.append(jFlight.departure);
					stringBuilder.append(" ");
					stringBuilder.append(jFlight.arrival);
					stringBuilder.append(" ");
					stringBuilder.append(iFlight.arrival);
				}
			}
		}
		return stringBuilder.toString();
	}
	private static ArrayList<Flight> getAllDirectFlights(String departure,String arrival){
		ArrayList<Flight> directFlights = new ArrayList<Flight>();
		for (Flight flight : mFlights) {
			if ((flight.arrival.equals(arrival) && flight.departure.equals(departure))) {
				directFlights.add(flight);
			}
		}
		return directFlights;	
	}
	private static String getAllDirectFlightTotalString(Flight flight){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(flight.departure + " "+ flight.arrival);
		return stringBuilder.toString();	
	}
	

	private static class Flight implements Comparable<Flight> {
		private String departure;
		private String arrival;
		private int price;

		public Flight(String departure, String arrival, int price) {
			super();
			this.departure = departure;
			this.arrival = arrival;
			this.price = price;
		}

		public String getDeparture() {
			return departure;
		}

		public void setDeparture(String departure) {
			this.departure = departure;
		}

		public String getArrival() {
			return arrival;
		}

		public void setArrival(String arrival) {
			this.arrival = arrival;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		public int compareTo(Flight o) {
			if (this.price != o.price) {
				return this.price <= o.price ? this.price : o.price;
			}
			return 0;
		}
		
		@Override
		public boolean equals(Object obj) {
			if(!(obj instanceof Flight)){
				return false;
			}
			Flight flighObj =(Flight)obj;
			return this.price == flighObj.price && 
			    this.arrival.equals(flighObj.arrival) &&
			    this.departure.equals(flighObj.departure);
		}
		
		@Override
		public String toString() {
			return "["+departure+" "+arrival+" "+price+"]";
		}
	}
}
