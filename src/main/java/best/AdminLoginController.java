package best;

import java.io.IOException;

import javafx.fxml.FXML;

public class AdminLoginController {

     @FXML
    private void GoBack() throws IOException {
        App.setRoot("login");
    }
}
