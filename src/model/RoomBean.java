package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class RoomBean {
	
	private SimpleStringProperty roomNumber;
	private SimpleIntegerProperty roomPrice;
	private SimpleIntegerProperty bedNumber;
	private SimpleStringProperty smokingStatus;
	private SimpleStringProperty roomSize;
	private SimpleStringProperty view;
	private SimpleStringProperty campus;
	private SimpleStringProperty adjointsTo;
	
	public RoomBean(String roomNumber,int roomPrice,int bedNumber,String smokingStatus,String roomSize,String view,String campus,String adjointsTo ){
		this.roomNumber=new SimpleStringProperty(roomNumber);
		this.roomPrice=new SimpleIntegerProperty(roomPrice);
		this.bedNumber=new SimpleIntegerProperty(bedNumber);
		this.smokingStatus=new SimpleStringProperty(smokingStatus);
		this.roomSize=new SimpleStringProperty(roomSize);
		this.view=new SimpleStringProperty(view);
		this.campus=new SimpleStringProperty(campus);
		this.adjointsTo=new SimpleStringProperty(adjointsTo);
		
	}

	public String getCampus() {
		return campus.get();
	}

	public void setCampus(String campus) {
		this.campus = new SimpleStringProperty(campus);
	}

	public String getRoomNumber() {
		return roomNumber.get();
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = new SimpleStringProperty(roomNumber);
	}

	public int getRoomPrice() {
		return roomPrice.get();
	}

	public void setRoomPrice(int roomPrice) {
		this.roomPrice = new SimpleIntegerProperty(roomPrice);
	}

	public int getBedNumber() {
		return bedNumber.get();
	}

	public void setBedNumber(int bedNumber) {
		this.bedNumber = new SimpleIntegerProperty(bedNumber);
	}

	public String getSmokingStatus() {
		return smokingStatus.get();
	}

	public void setSmokingStatus(String smokingStatus) {
		this.smokingStatus = new SimpleStringProperty(smokingStatus);
	}

	public String getRoomSize() {
		return roomSize.get();
	}

	public void setRoomSize(String roomSize) {
		this.roomSize = new SimpleStringProperty(roomSize);
	}

	public String getView() {
		return view.get();
	}

	public void setView(String view) {
		this.view = new SimpleStringProperty(view);
	}
	
	public String getAdjointsTo(){
		return adjointsTo.get();
	}
	
	public void setAdjointsTo(String adjointsTo){
		this.adjointsTo=new SimpleStringProperty(adjointsTo);
	}
	
	@Override
	public String toString() {
		
		return this.roomNumber.get();
	}

	

}
