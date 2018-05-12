package controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import model.RoomBean;

public class ManagerAddEditWindowController extends AbstractController implements Initializable {
	
	RoomBean selectedRoom;
	
	@FXML
    private JFXTextField roomPriceTextField;

    @FXML
    private JFXTextField roomNumberTextField;

    @FXML
    private JFXTextField bedNumberTextField;
    
    @FXML
    private JFXTextField adjointsToTextField;


    @FXML
    private ChoiceBox<String> campusChoiceBox;

    @FXML
    private ChoiceBox<String> viewChoiceBox;

    @FXML
    private ChoiceBox<String> roomSizeChoiceBox;

    @FXML
    private ChoiceBox<String> smokingChoiceBox;

    @FXML
    private JFXButton addButton;

    @FXML
    private JFXButton editButton;

	public ManagerAddEditWindowController(ModelAccess modelAccess) {
		super(modelAccess);
		// TODO Auto-generated constructor stub
	}
	
	 	@FXML
	    void handleAddRoomRequest(ActionEvent event) {
	 		RoomBean room=new RoomBean(roomNumberTextField.getText(), Integer.parseInt(roomPriceTextField.getText()), Integer.parseInt(bedNumberTextField.getText()), smokingChoiceBox.getValue(), roomSizeChoiceBox.getValue(), viewChoiceBox.getValue(), campusChoiceBox.getValue(),adjointsToTextField.getText(),2);
	    }

	    @FXML
	    void handleEditRoomRequest(ActionEvent event) {
	    	RoomBean room=getModelAccess().getSelectedRoom();
	    	room.setRoomNumber(roomNumberTextField.getText());
	    	room.setRoomPrice(Integer.parseInt(roomPriceTextField.getText()));
	    	room.setBedNumber(Integer.parseInt(bedNumberTextField.getText()));
	    	room.setSmokingStatus(smokingChoiceBox.getValue());
	    	room.setRoomSize(roomSizeChoiceBox.getValue());
	    	room.setView(viewChoiceBox.getValue());
	    	room.setCampus(campusChoiceBox.getValue());
	    	
	    	System.out.println(Integer.parseInt(roomPriceTextField.getText()));
	    	

	    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
				selectedRoom=getModelAccess().getSelectedRoom();
				if(selectedRoom!=null){
					//RoomNumberFieldInitilaze
					roomNumberTextField.setText(selectedRoom.getRoomNumber());
					
					//RoomPriceFieldInitilaze
					roomPriceTextField.setText(String.valueOf(selectedRoom.getRoomPrice()));
					
					//ViewChoiceBox Initilaze
					viewChoiceBox.setValue(selectedRoom.getView());
					viewChoiceBox.getItems().addAll("View","Without View");
					
					//roomSizeChoiceBox Initilaze
					roomSizeChoiceBox.setValue(selectedRoom.getRoomSize());
					roomSizeChoiceBox.getItems().addAll("Big Room","Small Room");
					
					//smokingChoiceBox Initilaze
					smokingChoiceBox.setValue(selectedRoom.getSmokingStatus());
					smokingChoiceBox.getItems().addAll("Smoking Room","Non Smoking Room");
					
					//campusChoiceBox Initilaze
					campusChoiceBox.setValue(selectedRoom.getCampus());
					campusChoiceBox.getItems().addAll("Vaxjo","Kalmar");
					
					
					
				}
				
		
	}

}
