package controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class SerachReservationController extends AbstractController implements Initializable {
	
	@FXML
    private TextField roomNumberTextField;

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
    private ChoiceBox<String> idTypeChoceBox;

    @FXML
    private JFXDatePicker dateOfBirthDatePicker;

    @FXML
    private Button submitButton;

    @FXML
    private Button cancelButton;

    @FXML
    private TableView<?> RoomTable;

    @FXML
    private TableColumn<?, ?> roomNumberCol;

    @FXML
    private TableColumn<?, ?> roomPriceCol;

    @FXML
    private TableColumn<?, ?> bedNumberCol;

    @FXML
    private TableColumn<?, ?> isSmokingCol;

    @FXML
    private TableColumn<?, ?> roomSizeCol;

    @FXML
    private TableColumn<?, ?> viewCol;

    @FXML
    private TableColumn<?, ?> campusCol;

    @FXML
    private TableColumn<?, ?> availabilityCol;

    @FXML
    private JFXDatePicker arrivalDatePicker;

    @FXML
    private JFXDatePicker DepartureDatePicker;

    @FXML
    private JFXButton searchButton;

    @FXML
    private ChoiceBox<String> campusChoiceBox;

    @FXML
    private ChoiceBox<String> viewChoiceBox;

    @FXML
    private ChoiceBox<String> smokingChoiceBox;

    @FXML
    private ChoiceBox<String> roomSizeChoiceBox;

	public SerachReservationController(ModelAccess modelAccess) {
		super(modelAccess);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		//ViewChoiceBox Initilaze
		viewChoiceBox.setValue("View");
		viewChoiceBox.getItems().addAll("View","Without View");
		
		//roomSizeChoiceBox Initilaze
		roomSizeChoiceBox.setValue("Big Room");
		roomSizeChoiceBox.getItems().addAll("Big Room","Small Room");
		
		//smokingChoiceBox Initilaze
		smokingChoiceBox.setValue("Smoking Room");
		smokingChoiceBox.getItems().addAll("Smoking Room","Non Smoking Room");
		
		//campusChoiceBox Initilaze
		campusChoiceBox.setValue("Vaxjo");
		campusChoiceBox.getItems().addAll("Vaxjo","Kalmar");
	}

}
