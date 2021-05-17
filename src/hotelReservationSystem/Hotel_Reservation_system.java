package hotelReservationSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Hotel_Reservation_system {
	
	private static Hotel lake, bridge, ridge;

    public static void main(String[] args) throws IOException {

    //setting values for lakewood
    lake = new Hotel("Lakewood");
    lake.setRating(3);
    lake.setRegularWeekDay(110);
    lake.setRegularWeekEnd(90);
    lake.setRewardedWeekDay(80);
    lake.setRewardedWeekEnd(80);

    //setting values for bridgewood
    bridge = new Hotel("Bridgewood");
    bridge.setRating(4);
    bridge.setRegularWeekDay(160);
    bridge.setRegularWeekEnd(60);
    bridge.setRewardedWeekDay(110);
    bridge.setRewardedWeekEnd(50);

    //setting values for ridgewood   
    ridge = new Hotel("Ridgewood");
    ridge.setRating(5);
    ridge.setRegularWeekDay(220);
    ridge.setRegularWeekEnd(150);
    ridge.setRewardedWeekDay(100);
    ridge.setRewardedWeekEnd(40);
    
    System.out.println("Enter customer type : date ex.Reward:16Mar2020(mon),15Mar2020(sun)");
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String date = bf.readLine();
    dateValidation(date);
    
    if(dateValidation(date)==true) {
    int index = date.indexOf(":");
    String type = date.substring(0, index);

    int cost_lake = 0, cost_bridge = 0, cost_ridge = 0;
    int day_index_start = 0, day_index_end = 0;

    while (day_index_start != -1) {
	     day_index_start = date.indexOf("(", day_index_start + 1);
	     day_index_end = date.indexOf(")", day_index_end + 1);
	
	     if (day_index_start != -1) {
		     String day = date.substring(day_index_start + 1, day_index_end);
		     if (day.equalsIgnoreCase("sun") || day.equalsIgnoreCase("sat")) {
			     if (type.equalsIgnoreCase("regular")) {
			    	 cost_lake += lake.getRegularWeekEnd();
				     cost_bridge += bridge.getRegularWeekEnd();
				     cost_ridge += ridge.getRegularWeekEnd();
			    	 
			     } else {
			    	 cost_lake += lake.getRewardedWeekEnd();
				     cost_bridge += bridge.getRewardedWeekEnd();
				     cost_ridge += ridge.getRewardedWeekEnd();
			     }
		     } else {
			     if (type.equalsIgnoreCase("regular")) {
			    	 cost_lake += lake.getRegularWeekDay();
				     cost_bridge += bridge.getRegularWeekDay();
				     cost_ridge += ridge.getRegularWeekDay();				     
			     } else {
			    	 cost_lake += lake.getRewardedWeekDay();
				     cost_bridge += bridge.getRewardedWeekDay();
				     cost_ridge += ridge.getRewardedWeekDay();
			     }
		     }
	     }
    }
	     System.out.println("\nLakewood : "+cost_lake+"$");
	     System.out.println("Bridgewood : "+cost_bridge+"$");
	     System.out.println("Ridgewood : "+cost_ridge+"$");
	     
	     int result = Stream.of(cost_lake, cost_bridge, cost_ridge)
			     .min(Comparator.comparing(Integer::valueOf))
			     .get();
		System.out.println("\nCheapestPrice: "+result+"$");
	     
	     String result1 = min(cost_lake, cost_bridge, cost_ridge);
	     System.out.println("\nCheapest price is of "+result1);
    }else
    	System.out.println("Please Enter valid date");
  }

    //implementing the min method
    private static String min(int a, int b, int c) {
	     if (a < b && a < c) {
	    	 return "Hotel :"+lake.getHotelName()+" with rating "+lake.getRating()+" Total Price : "+a+"$";
	     } else if (b < a && b < c) {
	    	 return "Hotel : "+bridge.getHotelName()+" with rating "+bridge.getRating()+" Total Price : "+b+"$";
	     } else if (c < a && c < b) {
	    	 return "Hotel : "+ridge.getHotelName()+" with rating "+ridge.getRating()+" Total Price : "+c+"$";
	     } else if (a == b ) {
	    	 return "Hotel : "+bridge.getHotelName()+" with rating "+bridge.getRating()+" Total Price : "+b+"$";
	     } else if (c == a || b==c) {
	    	 return "Hotel : "+ridge.getHotelName()+" with rating "+ridge.getRating()+" Total Price : "+c+"$";
	     } else {
	    	 return "Hotel : "+lake.getHotelName()+" with rating "+lake.getRating()+" Total Price : "+a+"$";
	     }
    }
    
    public static boolean dateValidation(String date) {
		String datePattern="^[A-Z a-z]{1,}[:][0-9]{1,}[A-Z a-z]{3,}[1-9]{1}[0-9]{3}[(][A-Z a-z]{3}[)][,][0-9]{1,}[A-Z a-z]{3,}[1-9]{1}[0-9]{3}[(][A-Z a-z]{3}[)]$";
		Pattern P=Pattern.compile(datePattern);
        Matcher m=P.matcher(date);
        return m.matches();	
		
	}
}
 
     
     	

 




