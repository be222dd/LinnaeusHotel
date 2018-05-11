package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXListView;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Pair;
import model.ReservationBean;
import model.RoomBean;
import view.ViewFactory;

public class MainController extends AbstractController implements Initializable {
	
	ViewFactory viewfactory = ViewFactory.defaultFactory;
	/*
	@FXML
    private JFXListView<String> todaysDeparturesListView;

    @FXML
    private JFXListView<?> todaysArrivalsListView;
    */

	@FXML
    private TableView<ReservationBean> checkInTable;

    @FXML
    private TableColumn<ReservationBean, String> checkInGuestName;

    @FXML
    private TableColumn<ReservationBean, String> checkInRoomNumber;
    
    @FXML
    private TableView<ReservationBean> checkOutTable;

    @FXML
    private TableColumn<ReservationBean, String> checkOutGuestName;

    @FXML
    private TableColumn<ReservationBean, String> checkOutRoomNumber;

	
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
    private TableColumn<RoomBean, String> adjointsToCol;

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
    void handleCheckInContextMenuItem(ActionEvent event) {
		ReservationBean resToCheckIn=checkInTable.getSelectionModel().getSelectedItem();
		if(resToCheckIn==null){
			return;
		}else{
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation for Check In");
			alert.setHeaderText("Confirm");
			alert.setContentText("Do you want to confirm the check In operation");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK){
				getModelAccess().checkInData.remove(resToCheckIn);
				System.out.println("Removed check in");
			} else {
			    return;
			}
			
		}

    }

    @FXML
    void handleCheckOutContextMenuItem(ActionEvent event) {
    	
    	ReservationBean resToCheckOut=checkOutTable.getSelectionModel().getSelectedItem();
    	if(resToCheckOut==null){
    		return;
    	}else{
    		
    		Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation for Check Out");
			alert.setHeaderText("Confirm");
			alert.setContentText("Do you want to confirm the check Out operation");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK){
				getModelAccess().checkOutData.remove(resToCheckOut);
				System.out.println("Removed check out");
			} else {
			    return;
			}
    		
    	}

    }
	
	@FXML
    void handleManagerWindowButton(ActionEvent event) {
		
		// Create the custom dialog.
		Dialog<Pair<String, String>> dialog = new Dialog<>();
		dialog.setTitle("Login Dialog");
		dialog.setHeaderText("Look, a Custom Login Dialog");

		

		// Set the button types.
		ButtonType loginButtonType = new ButtonType("Login", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

		// Create the username and password labels and fields.
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 150, 10, 10));

		TextField username = new TextField();
		username.setPromptText("Username");
		PasswordField password = new PasswordField();
		password.setPromptText("Password");

		grid.add(new Label("Username:"), 0, 0);
		grid.add(username, 1, 0);
		grid.add(new Label("Password:"), 0, 1);
		grid.add(password, 1, 1);

		// Enable/Disable login button depending on whether a username was entered.
		Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
		loginButton.setDisable(true);

		// Do some validation (using the Java 8 lambda syntax).
		username.textProperty().addListener((observable, oldValue, newValue) -> {
		    loginButton.setDisable(newValue.trim().isEmpty());
		});

		dialog.getDialogPane().setContent(grid);

		// Request focus on the username field by default.
		Platform.runLater(() -> username.requestFocus());

		// Convert the result to a username-password-pair when the login button is clicked.
		dialog.setResultConverter(dialogButton -> {
		    if (dialogButton == loginButtonType) {
		        return new Pair<>(username.getText(), password.getText());
		    }
		    return null;
		});

		Optional<Pair<String, String>> result = dialog.showAndWait();

		result.ifPresent(usernamePassword -> {
		    System.out.println("Username=" + usernamePassword.getKey() + ", Password=" + usernamePassword.getValue());
		    //toDo
		    if(usernamePassword.getKey().equals("abc")){
		    	Scene scene = viewfactory.getManagerWindowScene();
				Stage stage = new Stage();
				stage.setScene(scene);
				stage.show();
		    	
		    }
		});
		
		
		/*
		Scene scene = viewfactory.getManagerWindowScene();
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();
		*/
    }
	
	@FXML
    void handleSearchReservationButton(ActionEvent event) {
		Scene scene = viewfactory.getSearchReservationWindow();
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
		adjointsToCol.setCellValueFactory(new PropertyValueFactory<RoomBean, String>("adjointsTo"));
		
		RoomTable.setItems(getModelAccess().getRoomList());
		
		
		
		
		//Trial for checkInTable and checkoutTable
		
		checkInGuestName.setCellValueFactory(new PropertyValueFactory<ReservationBean, String>("guest"));
		checkInRoomNumber.setCellValueFactory(new PropertyValueFactory<ReservationBean, String>("room"));
		checkInTable.setItems(getModelAccess().checkInData);
		
		checkOutGuestName.setCellValueFactory(new PropertyValueFactory<ReservationBean, String>("guest"));
		checkOutRoomNumber.setCellValueFactory(new PropertyValueFactory<ReservationBean, String>("room"));
		checkOutTable.setItems(getModelAccess().checkOutData);
		
		
		
		
		
	}
	
	

}
