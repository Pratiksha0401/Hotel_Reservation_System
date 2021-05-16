package hotelReservationSystem;

public class Hotel {
	String hotelName;
    private int regularWeekDay;
    
	public Hotel(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public int getRegularWeekDay() {
		return regularWeekDay;
	}
	public void setRegularWeekDay(int regularWeekDay) {
		this.regularWeekDay = regularWeekDay;
	}
	
}
