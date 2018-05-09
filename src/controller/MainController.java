package controller;

import java.net.URL;
import java.util.ResourceBundle;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXListView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.RoomBean;
import view.ViewFactory;

public class MainController extends AbstractController implements Initializable {
	
	ViewFactory viewfactory = ViewFactory.defaultFactory;
	
	@FXML
    private JFXListView<RoomBean> todaysDeparturesListView;

    @FXML
    private JFXListView<?> todaysArrivalsListView;

    @FXML
    private JFXDatePicker departureDatePicker;

    @FXML
    private JFXButton searchButton;

    @FXML
    private JFXDatePicker arrivalDatePicker;

    @FXML
    private TableView<RoomBean> RoomTable;
    
    @FXML
    private TableColumn<RoomBean, String> roomNumberCol;

    @FXML
    private TableColumn<RoomBean, Integer> roomPriceCol;

    @FXML
    private TableColumn<RoomBean, Integer> bedNumberCol;

    @FXML
    private TableColumn<RoomBean, String> isSmokingCol;

    @FXML
    private TableColumn<RoomBean, String> roomSizeCol;

    @FXML
    private TableColumn<RoomBean, String> viewCol;

    @FXML
    private TableColumn<RoomBean, String> campusCol;

    @FXML
    private TableColumn<RoomBean, String> availabilityCol;

    @FXML
    private JFXButton reserveButton;

    @FXML
    private JFXButton searchReservationButton;

    @FXML
    private JFXButton printBillButton;

    @FXML
    private JFXButton checkOutButton;

    @FXML
    private JFXButton checkInButton;

    @FXML
    private JFXButton searchGuestButton;
    
    @FXML
    private JFXButton managerButton;
    
   
    
    

	
	
	
	
	public MainController(ModelAccess modelAccess) {
		super(modelAccess);
		// TODO Auto-generated constructor stub
	}
	
	@FXML
    void handleReserveRoomContextMenuItem(ActionEvent event) {
		RoomBean selectedRoomForReservation=RoomTable.getSelectionModel().getSelectedItem();
		if(selectedRoomForReservation==null){
			return;
		}
		else{
			System.out.println("Rooooom Nummberrrr"+selectedRoomForReservation.getRoomNumber());
			getModelAccess().setRoom(selectedRoomForReservation);
			
			Scene scene = viewfactory.getCreateReservationScene();
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
			
		}

    }
	
	@FXML
    void handleManagerWindowButton(ActionEvent event) {
		Scene scene = viewfactory.getManagerWindowScene();
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		
		//Open Reserve Button
		reserveButton.setOnAction(e->{
			
			Scene scene = viewfactory.getReservationLayoutScene();
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
		});	;
		
		roomNumberCol.setCellValueFactory(new PropertyValueFactory<RoomBean, String>("roomNumber"));
		roomPriceCol.setCellValueFactory(new PropertyValueFactory<RoomBean, Integer>("roomPrice"));
		bedNumberCol.setCellValueFactory(new PropertyValueFactory<RoomBean, Integer>("bedNumber"));
		isSmokingCol.setCellValueFactory(new PropertyValueFactory<RoomBean, String>("smokingStatus"));
		roomSizeCol.setCellValueFactory(new PropertyValueFactory<RoomBean, String>("roomSize"));
		viewCol.setCellValueFactory(new PropertyValueFactory<RoomBean, String>("view"));
		campusCol.setCellValueFactory(new PropertyValueFactory<RoomBean, String>("campus"));
		
		RoomTable.setItems(getModelAccess().data);
		
		todaysDeparturesListView.getItems().addAll(getModelAccess().data);
		
		
		
	}

}
