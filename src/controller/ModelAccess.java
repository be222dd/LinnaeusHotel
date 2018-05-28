package controller;

import java.sql.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.AppDAO;
import model.Guest;
import model.ReservationBean;
import model.RoomBean;

public class ModelAccess {
	
	private RoomBean selectedRoom;
	
	public AppDAO appDao=new AppDAO();
	
	//Dum trial Data
    final static ObservableList<RoomBean> data=FXCollections.observableArrayList(
    		new RoomBean("101", 100, 2, "Non Smoking Room", "Big Room", "View", "Vaxjo","none",1),
    		new RoomBean("102", 100, 2, "Non Smoking Room", "Big Room", "View", "Vaxjo","103",2),
    		new RoomBean("103", 100, 2, "Non Smoking Room", "Small Room", "Without View", "Vaxjo","none",3)
    		);
    
    final static ObservableList<ReservationBean> checkInData=FXCollections.observableArrayList(
    		new ReservationBean(new RoomBean("101", 100, 2, "Non Smoking Room", "Big Room", "View", "Vaxjo","none",1), new Guest("alex","Son",null,null,null,null,null), null, null,false,false),
    		new ReservationBean(new RoomBean("102", 100, 2, "Non Smoking Room", "Big Room", "View", "Kalmar","103",2), new Guest("beysim","eryalmaz",null,null,null,null,null), null, null,false,false)

    		);
    
    final static ObservableList<ReservationBean> checkOutData=FXCollections.observableArrayList(
    		new ReservationBean(new RoomBean("104", 100, 2, "Non Smoking Room", "Big Room", "View", "Vaxjo","none",4), new Guest("Johan","Svensson",null,null,null,null,null), null, null,false,false),
    		new ReservationBean(new RoomBean("105", 100, 2, "Non Smoking Room", "Big Room", "View", "Kalmar","103",5), new Guest("Kemal","Ata",null,null,null,null,null), null, null,false,false)

    		);
	

	public RoomBean getSelectedRoom() {
		return selectedRoom;
	}

	public void setRoom(RoomBean room) {
		this.selectedRoom = room;
	}
	
	public ObservableList<RoomBean> getRoomList(){
		@SuppressWarnings("deprecation")
		Date sDate=new Date(2018, 9, 27);
		@SuppressWarnings("deprecation")
		Date eDate=new Date(2018, 9, 30);
		
		try {
			ReservationBean res=appDao.getReservationByGuestNameandDates("Carl", "Petersson", "923456781","2018-10-15", "2018-10-20");
			res.setRoom(new RoomBean("105", 100, 2, "Non Smoking Room", "Big Room", "View", "Kalmar","103",1));
			appDao.makeReservation(res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return appDao.getAllRooms();
		
	}

}
