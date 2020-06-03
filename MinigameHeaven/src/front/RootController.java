package front;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.stage.Stage;

public class RootController implements Initializable {
	private Stage primaryStage;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

}
