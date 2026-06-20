package best;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class EmpLoginController {

  
      @FXML
    private TextField email;

    @FXML
    private Button loginbut;

    @FXML
    private Button main_forms;

    @FXML
    private PasswordField password;

    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;

    public void loginEmp() throws IOException {
        String sql = "SELECT e.id,e.employee_id,d.id as department_id,e.position, e.full_name,e.email, e.password, d.name as department FROM employees e JOIN departments d ON e.department_id = d.id WHERE email = ? and password = ? ";
        connect = database.connectdb();

        try  {
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, email.getText());
            prepare.setString(2, password.getText());

            result = prepare.executeQuery();

            Alert alert;
            if (email.getText().isEmpty() || password.getText().isEmpty()){
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("error message");
                alert.setHeaderText(null);
                alert.setContentText("Fill in all the blank space");
                alert.showAndWait();
            }
            else{
                if (result.next()) {
                getData.username = result.getString("full_name");
                getData.employeeId = result.getInt("id");
                getData.department = result.getString("department");
                getData.position = result.getString("position");
                getData.employeeID = result.getString("employee_id");
                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully login");
                alert.showAndWait();
                App.setRoot("employeeDashboard");

                } else {
                    alert = new Alert(AlertType.ERROR);
                alert.setTitle("error message");
                alert.setHeaderText(null);
                alert.setContentText("wrong username or password");
                alert.showAndWait();
                }
                 
            }

        } catch (SQLException e) {
           
        }

    }



     @FXML
    private void GoBack() throws IOException {
        App.setRoot("login");
    }
  
}
