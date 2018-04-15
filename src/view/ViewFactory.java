package view;



import javax.naming.OperationNotSupportedException;

import controller.AbstractController;
import controller.MainController;
import controller.ModelAccess;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class ViewFactory {
	
	public static ViewFactory defaultFactory=new ViewFactory();
	
	private static boolean mainViewInitiliazed=false;
	
	private ModelAccess modelAccess=new ModelAccess();
	
	private MainController mainController;
	
	
	private final String DEFAULT_CSS="style.css";
	
	private final String MAIN_SCREEN_FXML="MainLayout.fxml";
	
	
	public Scene getMainScene() throws OperationNotSupportedException{
		if (!mainViewInitiliazed) {
			mainViewInitiliazed=true;
			mainController = new MainController(modelAccess);
			return initializeScene(MAIN_SCREEN_FXML, mainController);
		}else{
			throw new OperationNotSupportedException("Main Scene Already Initiliazed");
		}
		
	}
	
	
	private Scene initializeScene(String fxmlPath,AbstractController controller){
		FXMLLoader loader;
		Parent parent;
		Scene scene;
		
		try {
			loader=new FXMLLoader(getClass().getResource(fxmlPath));
			loader.setController(controller);
			parent=loader.load();
			
		} catch (Exception e) {
			return null;
		}
		
		scene=new Scene(parent);
		//scene.getStylesheets().add(getClass().getResource(DEFAULT_CSS).toExternalForm());
		return scene;
	}

}
