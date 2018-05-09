package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.RoomBean;
import view.ViewFactory;

public class ManagerWindowController extends AbstractController implements Initializable {
	ViewFactory viewfactory = ViewFactory.defaultFactory;
	
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
    void handleAddRoomAction(ActionEvent event) {
    	RoomBean roomToAdd=RoomTable.getSelectionModel().getSelectedItem();
		if(roomToAdd==null){
			//TODO Create room and db op
			getModelAccess().setRoom(null);
			Scene scene = viewfactory.getAddEditRoomWindow();
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
		}

    }

    @FXML
    void handleDeleteAction(ActionEvent event) {
    	RoomBean selectedRoomToDelete=RoomTable.getSelectionModel().getSelectedItem();
		if(selectedRoomToDelete==null){
			return;
		}else{
			//TODO delete room and db op
			getModelAccess().data.remove(selectedRoomToDelete);
			
			
		}

    }

    @FXML
    void handleEditRoomAction(ActionEvent event) {
    	RoomBean selectedRoomToEdit=RoomTable.getSelectionModel().getSelectedItem();
		if(selectedRoomToEdit==null){
			return;
		}else{
			//TODO Edit room and db op
			getModelAccess().setRoom(selectedRoomToEdit);
			Scene scene = viewfactory.getAddEditRoomWindow();
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
			
		}

    }

	public ManagerWindowController(ModelAccess modelAccess) {
		super(modelAccess);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		roomNumberCol.setCellValueFactory(new PropertyValueFactory<RoomBean, String>("roomNumber"));
		roomPriceCol.setCellValueFactory(new PropertyValueFactory<RoomBean, Integer>("roomPrice"));
		bedNumberCol.setCellValueFactory(new PropertyValueFactory<RoomBean, Integer>("bedNumber"));
		isSmokingCol.setCellValueFactory(new PropertyValueFactory<RoomBean, String>("smokingStatus"));
		roomSizeCol.setCellValueFactory(new PropertyValueFactory<RoomBean, String>("roomSize"));
		viewCol.setCellValueFactory(new PropertyValueFactory<RoomBean, String>("view"));
		campusCol.setCellValueFactory(new PropertyValueFactory<RoomBean, String>("campus"));
		RoomTable.setItems(getModelAccess().data);
		
	}

}
