package model;

import java.sql.Date;



public class ReservationBean {
	
	private RoomBean room;
	private Guest guest;
	private Date startDate;
	private Date endDate;
	private boolean isCheckedIn;
	private boolean isCheckedOut;
	private int reservationId;
	
	public ReservationBean(RoomBean room, Guest guest, Date startDate, Date endDate,boolean isCheckedIn,boolean isCheckedOut) {
		this.room = room;
		this.guest = guest;
		this.startDate = startDate;
		this.endDate = endDate;
		this.isCheckedIn=isCheckedIn;
		this.isCheckedOut=isCheckedOut;
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

	public boolean isCheckedIn() {
		return isCheckedIn;
	}

	public void setCheckedIn(boolean isCheckedIn) {
		this.isCheckedIn = isCheckedIn;
	}

	public boolean isCheckedOut() {
		return isCheckedOut;
	}

	public void setCheckedOut(boolean isCheckedOut) {
		this.isCheckedOut = isCheckedOut;
	}

	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}
	
	

}
