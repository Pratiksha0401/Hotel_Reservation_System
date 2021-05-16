package hotelReservationSystem;

public class Hotel {
	String hotelName;
    private int regularWeekDay;
    private int regularWeekEnd;
    
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
	public int getRegularWeekEnd() {
		return regularWeekEnd;
	}
	public void setRegularWeekEnd(int regularWeekEnd) {
		this.regularWeekEnd = regularWeekEnd;
	}
	@Override
	public String toString() {
		return "Hotel [hotelName=" + hotelName + ", regularWeekDay=" + regularWeekDay + ", regularWeekEnd="
				+ regularWeekEnd + "]";
	}
	
}
