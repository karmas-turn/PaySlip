package best;

import java.io.IOException;

import javafx.fxml.FXML;

public class loginController {
   
     @FXML
    private void GoAdmin() throws IOException {
        App.setRoot("adminLogin");
    }
    
    @FXML
    private void  GoEmp() throws IOException{
    App.setRoot("empLogin");
  }
}
