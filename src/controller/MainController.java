package controller;

import java.net.URL;
import java.util.ResourceBundle;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXListView;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import view.ViewFactory;

public class MainController extends AbstractController implements Initializable {
	
	@FXML
    private JFXListView<?> todaysDeparturesListView;

    @FXML
    private JFXListView<?> todaysArrivalsListView;

    @FXML
    private JFXDatePicker departureDatePicker;

    @FXML
    private JFXButton searchButton;

    @FXML
    private JFXDatePicker arrivalDatePicker;

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
    private JFXButton reserveButton;

    @FXML
    private JFXButton reportButton;

    @FXML
    private JFXButton printBillButton;

    @FXML
    private JFXButton checkOutButton;

    @FXML
    private JFXButton checkInButton;

    @FXML
    private JFXButton searchGuestButton;

	
	
	
	
	public MainController(ModelAccess modelAccess) {
		super(modelAccess);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		ViewFactory viewfactory = ViewFactory.defaultFactory;
		
		//Open Reserve Button
		reserveButton.setOnAction(e->{
			
			Scene scene = viewfactory.getCreateReservationScene();
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
			
			System.out.println("clicked");
		});	;
		
	}

}
