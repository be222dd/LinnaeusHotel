package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;


public class SearchReservationController extends AbstractController  {

	public SearchReservationController(ModelAccess modelAccess) {
		super(modelAccess);
		
	}
	
	@FXML
    private JFXTextField guestNameTextField;

    @FXML
    private JFXTextField guestSurnameTextField;

    @FXML
    private JFXDatePicker startDatePicker;

    @FXML
    private JFXDatePicker endDatePicker;

    @FXML
    private JFXButton searchButton;

    @FXML
    private JFXTextField guestIDNumTextField;

    @FXML
    void handleSearchButtonAction(ActionEvent event) {
    	
    	//todo find the  reservation set it in the modelAccess and open the delete or edit res screen
    
    	

    }

}
