package model;

import java.sql.Date;



public class ReservationBean {
	
	private RoomBean room;
	private Guest guest;
	private Date startDate;
	private Date endDate;
	
	public ReservationBean(RoomBean room, Guest guest, Date startDate, Date endDate) {
		this.room = room;
		this.guest = guest;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public RoomBean getRoom() {
		return room;
	}

	public void setRoom(RoomBean room) {
		this.room = room;
	}

	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	

}
