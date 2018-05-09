package controller;

import java.io.ObjectInputStream.GetField;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXDatePicker;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.RoomBean;

public class CreateReservatinController extends AbstractController implements Initializable {
	RoomBean room;
	
	@FXML
    private Label roomNumberLabel;

    @FXML
    private Label arrivalDateLabel;

    @FXML
    private Label departureDateLabel;

    @FXML
    private TextField guestNameTextField;

    @FXML
    private TextField guestLastnameTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField phoneTextField;

    @FXML
    private TextField idNumberTextField;

    @FXML
    private ChoiceBox<?> idTypeChoceBox;

    @FXML
    private JFXDatePicker dateOfBirthDatePicker;

    @FXML
    private Button submitButton;


	public CreateReservatinController(ModelAccess modelAccess) {
		super(modelAccess);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		room=getModelAccess().getSelectedRoom();
		roomNumberLabel.setText(room.getRoomNumber());
		
		
		
	}
	
	

}
