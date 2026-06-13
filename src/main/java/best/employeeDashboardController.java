package best;

import java.io.IOException;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;

public class employeeDashboardController {
  @FXML
    private Button homeBtn;

    @FXML
    private Button paybtn;

    @FXML
    private Button profileBtn;

    @FXML
    private AnchorPane payslipforms;

  //Logout function
   @FXML
    private void logout() throws IOException{
      Alert alert = new Alert(AlertType.CONFIRMATION);
      alert.setTitle("Logout confirmation");
      alert.setHeaderText(null);
      alert.setContentText("Are you sure you want to logout?");
      Optional <ButtonType> option = alert.showAndWait();

      try {
        if (option.isPresent() && option.get().equals(ButtonType.OK)){
        App.setRoot("login");
      }
      } catch (Exception e) {
        // TODO: handle exception
      }
      
    }
  
    //Switching forms
    
    @FXML
    void switchforms(ActionEvent event) {
      if(event.getSource()==homeBtn){
        payslipforms.setVisible(false);

        homeBtn.setStyle("-fx-background-color: linear-gradient(to left, #3a28ff, #736ad3);");
        paybtn.setStyle("-fx-background-color: transparent;");
        profileBtn.setStyle("-fx-background-color: transparent;");

      }
      else if(event.getSource().equals(paybtn)){
        payslipforms.setVisible(true);


        paybtn.setStyle("-fx-background-color: linear-gradient(to left, #3a28ff, #736ad3);");
        homeBtn.setStyle("-fx-background-color: transparent;");
        profileBtn.setStyle("-fx-background-color: transparent;");
      }
      else if (event.getSource().equals(profileBtn)){
        payslipforms.setVisible(false);

        profileBtn.setStyle("-fx-background-color: linear-gradient(to left, #3a28ff, #736ad3);");
        homeBtn.setStyle("-fx-background-color: transparent;");
        paybtn.setStyle("-fx-background-color: transparent;");

      }
    }

}
