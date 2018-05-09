package model;

import java.sql.Date;

import javafx.collections.ObservableList;

public class AppDAO {
	
	public ObservableList<RoomBean> getAllRooms(){
		//should get and return all rooms as observable list
		return null;
	}
	
	public ObservableList<RoomBean> getRoomsWithCriteria(int bedNumber,String smokingStatus,String roomSize,String view,String campus){
		//this can wait its quite hard query we can think about it later
		return null; 
	}
	
	public ObservableList<ReservationBean> getReservationsByDate(Date start,Date end){
		/*should get any reservations between or exactly those dates
		 keep in mind reservationBean object contains roomBean and Guest objects too
		 so to create and return it those object should be created too*/
		
		return null;
	}
	
	public ReservationBean getReservationByGuestNameandDates(String guestName,String surname,String idNumber,Date start,Date end){
		//getReservationByGuestNameandDates and return the object
		return null;
	}
	
	public Guest findGuest(String guestName,String surname,String idNumber){
		//should find and return the guest object
		return null;
	}
	
	public void createRoom(RoomBean room){
		//create room in db
	}
	
	public void updateRoom(RoomBean room){
		//find and update the room in db
	}
	
	public void deleteRoom(RoomBean room){
		//find and delete the room in db
	}
}
