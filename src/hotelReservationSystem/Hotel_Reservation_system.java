package hotelReservationSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hotel_Reservation_system {
	
	 private static Hotel lake, bridge, ridge;

     public static void main(String[] args) throws IOException {
    
    	 System.out.println("Enter date  ex. 16Mar2020(mon)");
         BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
         String date = bf.readLine();

 		
 		//setting values for lakewood
 	    lake = new Hotel("Lakewood");
 	    lake.setRating(3);
 	    lake.setRegularWeekDay(110);
 	    lake.setRegularWeekEnd(90);
 		 		
 		//setting values for bridgewood
 	    bridge = new Hotel("Bridgewood");
 	    bridge.setRating(4);
 	    bridge.setRegularWeekDay(150);
 	    bridge.setRegularWeekEnd(50);
 				
 		//setting values for ridgewood   
 	    ridge = new Hotel("Ridgewood");
 	    ridge.setRating(5);
 	    ridge.setRegularWeekDay(220);
 	    ridge.setRegularWeekEnd(150);
 		
 		 //int index = date.indexOf(":");
 	     //String type = date.substring(0, index);
 	     int cost_lake = 0, cost_bridge = 0, cost_ridge = 0;
 	     int day_index_start = 0, day_index_end = 0;
 	     
 	    while (day_index_start != -1) {
 		     day_index_start = date.indexOf("(", day_index_start + 1);
 		     day_index_end = date.indexOf(")", day_index_end + 1);
 		
 		     if (day_index_start != -1) {
 			     String day = date.substring(day_index_start + 1, day_index_end);
 				    
 					     cost_lake += lake.getRegularWeekDay()+lake.getRegularWeekEnd();
 					     cost_bridge += bridge.getRegularWeekDay()+bridge.getRegularWeekEnd();
 					     cost_ridge += ridge.getRegularWeekDay()+ridge.getRegularWeekEnd();
 				     
 			     }
 		     }  
 	    
 	     System.out.println("\nLakewood : "+cost_lake+"$");
	     System.out.println("Bridgewood : "+cost_bridge+"$");
	     System.out.println("Ridgewood : "+cost_ridge+"$");
	
	     String result = min(cost_lake, cost_bridge, cost_ridge);
	     System.out.println("Cheapest price is of "+result);
     	}
     	
   //implementing the min method
     public static  String min(int a, int b, int c) {
 		if(a < c && a < c) {
 			return lake.getHotelName();
 		}else if(b<a && b < c) {
 			return bridge.getHotelName();
 		}else if(a==b ) {
 			return (lake.getHotelName()+" "+bridge.getHotelName());
 		}else if(b==c) {
 			return (bridge.getHotelName()+" "+ridge.getHotelName());
 		}else if(a==c) {
 			return (lake.getHotelName()+" "+ridge.getHotelName());
 		}
 		else {
 			return ridge.getHotelName();
 		}
 	}
}
 




