package problems.list;


import java.util.ArrayList;
import java.util.Collections;
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
		Flight flight2=new Flight("BLR", "MUMBAI", 1000);
		Flight flight3=new Flight("MUMBAI", "HYD", 7000);
		
		mFlights.add(flight1);
		mFlights.add(flight2);
		mFlights.add(flight3);

		ArrayList<ArrayList<Flight>> connectingFlights = getAllConnectingFlights(departure,arrival);
		System.out.println("connectingFlights:"+connectingFlights);
		ArrayList<Flight> directFlights = getAllDirectFlights(departure, arrival);
		System.out.println("directFlights:"+directFlights);
		
		final HashMap<Integer, String> map=new HashMap<Integer, String>();
		for(ArrayList<Flight> item:connectingFlights){
			map.put(getAllConnectingFlightsTotalPrice(item),getAllConnectingFlightsTotalString(item));
		}
		for(Flight item:directFlights){
			map.put(item.getPrice(),getAllDirectFlightTotalString(item));
		}

		Set<Integer> keyset = map.keySet();
		ArrayList<Integer> keys = new ArrayList<Integer>(keyset);
		Collections.sort(keys);

		for(Integer intValue:keys){
			System.out.print(intValue +" " +map.get(intValue));
		}
		
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
					if (jFlight.departure.equals(iFlight.arrival)) {
						connectingFlights.add(k++,iFlight);
						connectingFlights.add(k++,jFlight);
					}
					if (jFlight.arrival.equals(iFlight.departure)) {
						connectingFlights.add(k++,iFlight);
						connectingFlights.add(k++,iFlight);					
					}
				}
			}
			
			boolean isConnectingFlights = false;
			for (int i = 0; i < connectingFlights.size(); i++) {
				Flight flight = connectingFlights.get(i);
				if (departure.equals(flight.departure)) {
					connectingFlights.set(0, flight);
					isConnectingFlights = true;
				}
				if (arrival.equals(flight.arrival)) {
					connectingFlights.set(k - 1, flight);
					if (!isConnectingFlights) {
						isConnectingFlights = true;
					}
				}
			}
//			System.out.println("1.connectingFlights:"+connectingFlights);
			if(!allConnectingFlights.contains(connectingFlights)){
				allConnectingFlights.add(connectingFlights);		
			}					
		}
//		System.out.println("2.allConnectingFlights:"+allConnectingFlights);
		return allConnectingFlights.size() > 0 ? allConnectingFlights : null;
	}
	
	private static int getAllConnectingFlightsTotalPrice(ArrayList<Flight> connectingFlights){
		int cost = 0;
		for (Flight flight : connectingFlights) {
			 cost = flight.getPrice();
		}
		return cost;
	}
	private static String getAllConnectingFlightsTotalString(ArrayList<Flight> connectingFlights){
		StringBuilder stringBuilder=new StringBuilder();
		for (int i = 0; i < connectingFlights.size() - 1; i++) {
			for (int j = i+1; j < connectingFlights.size(); j++) {
				Flight jFlight= connectingFlights.get(j);
				Flight iFlight= connectingFlights.get(i);
//				System.out.println("Comparing " + jFlight +" with "+ iFlight);
				if (jFlight.departure.equals(iFlight.arrival)) {
					stringBuilder.append(jFlight.departure);
					stringBuilder.append(iFlight.arrival);
				}
				if (jFlight.arrival.equals(iFlight.departure)) {
					stringBuilder.append(iFlight.departure);
					stringBuilder.append(jFlight.arrival);
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
