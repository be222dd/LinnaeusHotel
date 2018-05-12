package model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AppDAO {
DBConnect con = new DBConnect();


public void makeReservation(ReservationBean reservation){
	//TODO: guestID in Guest.java, RoomID in RoomBean
	Guest guest=reservation.getGuest();
	RoomBean room=reservation.getRoom();
	
	int hotelId = 0;
	Date reservationDate = new Date(System.currentTimeMillis());
		
	
	if (room.getCampus() == "Kalmar") {
		hotelId = 1;
	} else if (room.getCampus() == "Växjö") {
		hotelId = 2;
	}
	System.out.println("what is this"+reservation.isCheckedIn());
	
	String reservation_query = "INSERT INTO reservation (hotel_id, guest_id, arrival_date, departure_date, room_id, reservation_date, isCheckedIN, isCheckedOut) "
			+ "VALUES ('" + hotelId + "','" + guest.getGuestId() + "','"+ reservation.getStartDate() + "','" + reservation.getEndDate() + "','"+ room.getRoomId() + "','"+ convertStringToDate(reservationDate) + "','"+ reservation.isCheckedIn() + "','"+ reservation.isCheckedOut() +"')";
	
	try {
		con.updateData(reservation_query);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
	
	public ObservableList<RoomBean> getAllRooms() {
				
		ObservableList<RoomBean> list = FXCollections.observableArrayList();
		
		String get_rooms_query = "SELECT hotel.city, room.room_id, room.room_number, room.price, room.beds, room.smoking, room.room_size, room.view, room.adjointsTo "
				+ "FROM room "
				+ "JOIN hotel ON hotel.hotel_id = room.hotel_id "
				+ "ORDER BY hotel.city"; 
		
		ResultSet res;
		
		try {
			
			res = con.retrieveData(get_rooms_query);
			while(res.next()){
	
	           list.add(new RoomBean(res.getString("room_number"), res.getInt("price"), res.getInt("beds"), res.getString("smoking"), res.getString("room_size"), res.getString("view"), res.getString("city"), res.getString("adjointsTo"),res.getInt("room_id")));
	            
	        }
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		return list;
	}
	
	public ObservableList<RoomBean> getRoomsWithCriteria(int bedNumber,String smokingStatus,String roomSize,String view, String campus) {
	
		ObservableList<RoomBean> list = FXCollections.observableArrayList();
		
		String get_room_query = "SELECT hotel.city, room.room_number, room.price, room.beds, room.smoking, room.room_size, room.view, room.adjointsTo "
				+ "FROM room "
				+ "JOIN hotel ON hotel.hotel_id = room.hotel_id "
				+ "WHERE beds = '" + bedNumber + "' AND " + "smoking = '" + smokingStatus + "' AND " + "room_size = '" + roomSize + "' AND " + "view = '" + view + "' AND " + "city = '" + campus + "' ";
		
		ResultSet res;
		try {
			res = con.retrieveData(get_room_query);
			
			while(res.next()){
				
				list.add(new RoomBean(res.getString("room_number"), res.getInt("price"), res.getInt("beds"), res.getString("smoking"), res.getString("room_size"), res.getString("view"), res.getString("city"), res.getString("adjointsTo"),res.getInt("room_id")));
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return list; 
	}
	
	public ObservableList<ReservationBean> getReservationsByDate(String start, String end) throws Exception{
		
		ObservableList<ReservationBean> reservationList = FXCollections.observableArrayList();
		
		String get_reservations_query = "SELECT guest.first_name, guest.last_name, guest.date_of_birth, guest.email, guest.phone, guest.id_type, "
				+ "guest.id_number, hotel.city, room.room_number, room.price, room.beds, room.smoking, room.room_size, room.view, room.adjointsTo, "
				+ "arrival_date, departure_date, isCheckedIN, isCheckedOut "
				+ "FROM reservation "
				+ "JOIN guest ON guest.guest_id = reservation.guest_id "
				+ "JOIN hotel ON hotel.hotel_id = reservation.hotel_id "
				+ "JOIN room ON room.room_id = reservation.room_id "
				+ "WHERE reservation.arrival_date >= '" + start + "' AND " + "reservation.departure_date <= '" + end + "' "
						+ "ORDER BY reservation.arrival_date";
		
		ResultSet res;
		try {
			res = con.retrieveData(get_reservations_query);
			
			while(res.next()){
				System.out.println();
				
				RoomBean room = new RoomBean(res.getString("room_number"), res.getInt("price"), res.getInt("beds"), res.getString("smoking"), res.getString("room_size"), res.getString("view"), res.getString("city"), res.getString("adjointsTo"),1);
				Guest guest = new Guest(res.getString("first_name"), res.getString("last_name"),res.getDate("date_of_birth"), res.getString("email"), res.getString("phone"), res.getString("id_type"), res.getString("id_number"));
				
				reservationList.add(new ReservationBean(room, guest, res.getDate("arrival_date"), res.getDate("departure_date"), res.getBoolean("isCheckedIN"), res.getBoolean("isCheckedOut")));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(reservationList.size()+"???????????????????");
	
		return reservationList; 
		
	}
	
	
	public Guest findGuest(String guestName,String surname,String idNumber) throws Exception{
		
		String guest_search_query = "SELECT first_name, last_name, date_of_birth, email, phone, id_type, id_number "
				+ "FROM guest WHERE first_name = '" + guestName + "' AND " + "last_name = '" + surname + "' AND " + "id_number = '" + idNumber + "'";	
		
		ArrayList<Object> guestArrList = con.getArrData(guest_search_query);
		
		String firstName = (String) guestArrList.get(0);
		String lastName = (String) guestArrList.get(1);
		Date dateOfBirth = (Date) guestArrList.get(2);
		String email = (String) guestArrList.get(3);
		String phoneNumber = (String) guestArrList.get(4);
		String idType = (String) guestArrList.get(5);
		String idNum = (String) guestArrList.get(6);
				
		Guest guest = new Guest(firstName, lastName, dateOfBirth, email, phoneNumber, idType, idNum);
		
		return guest;
	}
	
	public void createRoom(RoomBean room){
		//here instead of a campus property, for the database's sake better to make hotel ID (int hotelId = 1 for Kalmar, int hotelId = 2 for Växjö)
		//so we need to add additional field or selection for the hotel ID, also updating and deleting rooms requires room ID that gets automatically 
		//assigned to a room after it's been created
		
		int hotelId;
		if(room.getCampus()=="Kalmar"){
			hotelId=1;
		}else{
			hotelId=2;
		}
		
		
		
		String create_room_query = "INSERT INTO room (hotel_id, room_number, price, beds, smoking, room_size, view) "
				+ "VALUES ('" + hotelId + "','" + room.getRoomNumber() + "','"+ room.getRoomPrice() + "','" + room.getBedNumber() + "','"+ room.getSmokingStatus() + "','"+ room.getRoomSize() + "','" + room.getView() + "','"+ room.getAdjointsTo() +"')";
		
		try {
			con.updateData(create_room_query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void updateRoom(RoomBean room){
		
		// updating rooms requires the room ID's value (TODO: room.getRoomId() in RoomBean)
		
		String update_room_query = "UPDATE room SET room_number = '" + room.getRoomNumber() + "', price = '" + room.getRoomPrice() + "', "
				+ "beds = '" + room.getBedNumber() + "', smoking = '" + room.getSmokingStatus() + "', room_size = '" + room.getRoomSize() + "', view = '" + room.getView() + "', adjointsTo = '" + room.getAdjointsTo() +"'"
									+ "WHERE room_id = '"+ room.getRoomId() + "'"; 
		
		try {
			con.updateData(update_room_query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	}
	
	public void deleteRoom(RoomBean room){
		
		// deleting rooms requires the room ID's value (TODO: room.getRoomId() in RoomBean)
		
		String delete_room_query = "DELETE FROM room WHERE room_id = " + room.getRoomId();
		try {
			con.updateData(delete_room_query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public ReservationBean getReservationByGuestNameandDates(String guestName,String surname,String idNumber,String start,String end) throws Exception{
		//TODO: how to handle if no reservation found (there are no matches)
		
				//String startDate = convertStringToDate(start);
				//String endDate = convertStringToDate(end);
				System.out.println(start);
				System.out.println(end);
				//String get_reservation_query = "SELECT * FROM room";
				
				String get_reservation_query = "SELECT room.room_id, room.room_number, room.price, room.beds, room.smoking, room.room_size, room.view, hotel.name, room.adjointsTo, "
						+ "guest.first_name, guest.last_name, guest.date_of_birth, guest.email, guest.phone, guest.id_type, guest.id_number, "
						+ "reservation.arrival_date, reservation.departure_date, reservation.isCheckedIn, reservation.isCheckedOut "
						+ "FROM reservation "
						+ "JOIN guest ON guest.guest_id = reservation.guest_id "
						+ "JOIN hotel ON hotel.hotel_id = reservation.hotel_id "
						+ "JOIN room ON room.room_id = reservation.room_id "
						+ "WHERE first_name = '" + guestName + "' AND " + "last_name = '" + surname + "' AND " + "id_number = '" + idNumber + "' AND " + "arrival_date = '" + start + "' AND " + "departure_date = '" + end + "'";
				
			
				ArrayList<Object> reservationArrList = con.getArrData(get_reservation_query);
				
				for (int i = 0; i < reservationArrList.size(); i++) {
			        System.out.println(reservationArrList.get(i));
			    }
				
				int roomId = (int) reservationArrList.get(0);
				String roomNumber = reservationArrList.get(1).toString();
				int roomPrice = (int) reservationArrList.get(2);
				int bedNumber = (int) reservationArrList.get(3);
				String smokingStatus = (String) reservationArrList.get(4);
				String roomSize = (String) reservationArrList.get(5);
				String view = (String) reservationArrList.get(6);
				String campus = (String) reservationArrList.get(7);
				String adjointsTo = (String) reservationArrList.get(8);
				
				String firstName = (String) reservationArrList.get(9);
				String lastName = (String) reservationArrList.get(10);
				Date dateOfBirth = (Date) reservationArrList.get(11);
				String email = (String) reservationArrList.get(12);
				String phoneNumber = (String) reservationArrList.get(13);
				String idType = (String) reservationArrList.get(14);
				String idNum = (String) reservationArrList.get(15);
				Date start_date = (Date) reservationArrList.get(16);
				Date end_date = (Date) reservationArrList.get(17);
				boolean isCheckedIn = (boolean) reservationArrList.get(18);
				boolean isCheckedOut = (boolean) reservationArrList.get(19);
				
				RoomBean room = new RoomBean(roomNumber, roomPrice, bedNumber, smokingStatus, roomSize, view, campus, adjointsTo,1);
				Guest guest = new Guest(firstName, lastName, dateOfBirth, email, phoneNumber, idType, idNum);
				
				ReservationBean reservation = new ReservationBean(room, guest, start_date, end_date, isCheckedIn, isCheckedOut);
				return reservation;	
	}
	
	public String convertStringToDate(Date date)
	{
	   String dateString = null;
	   SimpleDateFormat sdfr = new SimpleDateFormat("yyyy-MM-dd");
	   
	   try{
		   
		dateString = sdfr.format( date );

	   }catch (Exception ex ){
		System.out.println(ex);
	   }
	   return dateString;
	}
	

}
