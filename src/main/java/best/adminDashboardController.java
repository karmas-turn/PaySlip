package best;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;





public class adminDashboardController implements Initializable {
     @FXML
    private ChoiceBox<String> choice1;

    @FXML
    private AnchorPane empforms;

    @FXML
    private Button directBtn;

    @FXML
    private AnchorPane empdirectoryforms;

    @FXML
    private Button empBtn;

    @FXML
    private TextField employee_id;

    @FXML
    private TextField full_name;

    @FXML
    private Button homeBtn;

    @FXML
    private Button payBtn;

    @FXML
    private Label payment;

    @FXML
    private AnchorPane homeform;

    @FXML
    private TextField phone;

    @FXML
    private TextField position;

    @FXML
    private Button reportBtn;

    @FXML
    private TextField basic_salary;

    @FXML
    private Button settingBtn;

    @FXML
    private ChoiceBox<String> stat;

    @FXML
    private Label totalemp;

    @FXML
    private DatePicker hire_date;

    @FXML
    private Button gen;

    @FXML
    private TableColumn<?, ?> recentempDepartment;

    @FXML
    private TableColumn<?, ?> recentempID;

    @FXML
    private TableColumn<?, ?> recentempName;

    @FXML
    private TableColumn<?, ?> recentempSalary;

    @FXML
    private TableColumn<?, ?> recentempStatus;

    @FXML
    private AnchorPane payslipforms;

     @FXML
    private AnchorPane previewforms;

     @FXML
    private AnchorPane firstpre;

    @FXML
    private AnchorPane settingforms;

    @FXML
    private AnchorPane reportforms;

    @FXML
    private PasswordField password;


    //This function helps switch in between the forms
    @FXML 
  void switchform (ActionEvent event) {
     

    if(event.getSource() == homeBtn){
      homeform.setVisible(true);
      empforms.setVisible(false);
      payslipforms.setVisible(false);
      settingforms.setVisible(false);
      empdirectoryforms.setVisible(false);
      reportforms.setVisible(false);


      homeBtn.setStyle("-fx-background-color: linear-gradient(to left, #3a28ff, #736ad3);");
      empBtn.setStyle("-fx-background-color: transparent;");
      payBtn.setStyle("-fx-background-color: transparent;");
      reportBtn.setStyle("-fx-background-color: transparent;");
      settingBtn.setStyle("-fx-background-color: transparent;");
      reportBtn.setStyle("-fx-background-color: transparent;");
      directBtn.setStyle("-fx-background-color: transparent;");

      
    }
    else if(event.getSource() == empBtn){
       homeform.setVisible(false);
      empforms.setVisible(true);
      // firstpre.setVisible(true);
      payslipforms.setVisible(false);
      settingforms.setVisible(false);
      empdirectoryforms.setVisible(false);
      reportforms.setVisible(false);
      
      empBtn.setStyle("-fx-background-color: linear-gradient(to left, #3a28ff, #736ad3);");
      homeBtn.setStyle("-fx-background-color: transparent;");
      payBtn.setStyle("-fx-background-color: transparent;");
      settingBtn.setStyle("-fx-background-color: transparent;");
      reportBtn.setStyle("-fx-background-color: transparent;");
      directBtn.setStyle("-fx-background-color: transparent;");

    }
    else if(event.getSource()==directBtn){
      homeform.setVisible(false);
      empforms.setVisible(false);
     
      payslipforms.setVisible(false);
      settingforms.setVisible(false);
      empdirectoryforms.setVisible(true);
      reportforms.setVisible(false);

      directBtn.setStyle("-fx-background-color: linear-gradient(to left, #3a28ff, #736ad3);");
      homeBtn.setStyle("-fx-background-color: transparent;");
      payBtn.setStyle("-fx-background-color: transparent;");
      settingBtn.setStyle("-fx-background-color: transparent;");
      reportBtn.setStyle("-fx-background-color: transparent;");
      empBtn.setStyle("-fx-background-color: transparent;");

      
    }
    else if (event.getSource() == payBtn){
      homeform.setVisible(false);
      empforms.setVisible(false);
      payslipforms.setVisible(true);
      settingforms.setVisible(false);
      empdirectoryforms.setVisible(false);
      reportforms.setVisible(false);

      payBtn.setStyle("-fx-background-color: linear-gradient(to left, #3a28ff, #736ad3);");
      homeBtn.setStyle("-fx-background-color: transparent;");
      empBtn.setStyle("-fx-background-color: transparent;");
      settingBtn.setStyle("-fx-background-color: transparent;");
      reportBtn.setStyle("-fx-background-color: transparent;");
      directBtn.setStyle("-fx-background-color: transparent;");



  }
    else if (event.getSource() == reportBtn){
      homeform.setVisible(false);
      empforms.setVisible(false);
      payslipforms.setVisible(false);
      settingforms.setVisible(false);
      empdirectoryforms.setVisible(false);
      reportforms.setVisible(true);

      reportBtn.setStyle("-fx-background-color: linear-gradient(to left, #3a28ff, #736ad3);");
      homeBtn.setStyle("-fx-background-color: transparent;");
      empBtn.setStyle("-fx-background-color: transparent;");
      payBtn.setStyle("-fx-background-color: transparent;");
      settingBtn.setStyle("-fx-background-color: transparent;");
      directBtn.setStyle("-fx-background-color: transparent;");


    }
    else if (event.getSource() == settingBtn){
       homeform.setVisible(false);
      empforms.setVisible(false);
      payslipforms.setVisible(false);
      settingforms.setVisible(true);
      empdirectoryforms.setVisible(false);
      reportforms.setVisible(false);

      settingBtn.setStyle("-fx-background-color: linear-gradient(to left, #3a28ff, #736ad3);");
      homeBtn.setStyle("-fx-background-color: transparent;");
      empBtn.setStyle("-fx-background-color: transparent;");
      payBtn.setStyle("-fx-background-color: transparent;");
      reportBtn.setStyle("-fx-background-color: transparent;");
      directBtn.setStyle("-fx-background-color: transparent;");

      
    }

  }
    
    
    //Dropdown items
    private String[] department = {"1. IT", "2. Marketing", "3. Human Resource","4. Finance","5. Operations"};
    private String[] choice2 = {"active", "on leave", "inactive"};
  
    //Dropdown
    @Override
    public void initialize(URL arg0, ResourceBundle args){
      choice1.getItems().addAll(department);
      stat.getItems().addAll(choice2);
    }
    
    

    //DATABASE 
    private Connection connect;
    private Statement statement;
    private PreparedStatement prepare;
    private ResultSet result;

    // public void addEmployee(employeeData emp, String plainPassword){
    //     String sql = " INSERT INTO employees(employee_id, full_name, email, phone, department_id,position, basic_salary, hire_date, status, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    //     connect = database.connectdb();
    //     try {
    //       prepare = connect.prepareStatement(sql);

    //      prepare.setString(1, emp.getEmployeeId());
    //        prepare.setString(2, emp.getFullName());
    //        prepare.setString(3, emp.getEmail());
    //        prepare.setString(4, emp.getPhone());
    //        prepare.setInt   (5, emp.getDepartmentId());
    //        prepare.setString(6, emp.getPosition());
    //        prepare.setBigDecimal(7, emp.getBasicSalary());
    //        prepare.setDate  (8, emp.getHireDate() != null
    //                 ? Date.valueOf(emp.getHireDate()) : null);
    //        prepare.setString(9, emp.getStatus());
    //         // Hash password in production: BCrypt.hashpw(plainPassword, BCrypt.gensalt())
    //        prepare.setString(10, plainPassword);

    //        prepare.execute();

    //     } catch (Exception e) {
          
    //     }

    // }


    @FXML
    private void switchReport(){
    
      // firstpre.setVisible(false);
      previewforms.setVisible(true);
    }
    

    //This helps out to logout
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

    
}
