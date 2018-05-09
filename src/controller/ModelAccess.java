package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Guest;
import model.ReservationBean;
import model.RoomBean;

public class ModelAccess {
	
	private RoomBean selectedRoom;
	
	//Dum trial Data
    final static ObservableList<RoomBean> data=FXCollections.observableArrayList(
    		new RoomBean("101", 100, 2, "Non Smoking Room", "Big Room", "View", "Vaxjo","none"),
    		new RoomBean("102", 100, 2, "Non Smoking Room", "Big Room", "View", "Vaxjo","103"),
    		new RoomBean("103", 100, 2, "Non Smoking Room", "Small Room", "Without View", "Vaxjo","102")
    		);
    
    final static ObservableList<ReservationBean> checkInData=FXCollections.observableArrayList(
    		new ReservationBean(new RoomBean("101", 100, 2, "Non Smoking Room", "Big Room", "View", "Vaxjo","none"), new Guest("alex","andre",null,null,null,null,null), null, null,false,false),
    		new ReservationBean(new RoomBean("102", 100, 2, "Non Smoking Room", "Big Room", "View", "Kalmar","103"), new Guest("beysim","andre",null,null,null,null,null), null, null,false,false)

    		);
	

	public RoomBean getSelectedRoom() {
		return selectedRoom;
	}

	public void setRoom(RoomBean room) {
		this.selectedRoom = room;
	}

}
