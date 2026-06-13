package best;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;

import java.io.IOException;
import java.net.URL;
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
    private TextField empID;

    @FXML
    private TextField fullname;

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
    private TextField salary;

    @FXML
    private Button settingBtn;

    @FXML
    private ChoiceBox<String> stat;

    @FXML
    private Label totalemp;

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




    //This function helps switch in between the forms
    @FXML 
  void switchform (ActionEvent event) {
    

    if(event.getSource() == homeBtn){
      homeform.setVisible(true);
      empforms.setVisible(false);
      payslipforms.setVisible(false);
      settingforms.setVisible(false);
      empdirectoryforms.setVisible(false);


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
      firstpre.setVisible(false);
      payslipforms.setVisible(false);
      settingforms.setVisible(false);
      empdirectoryforms.setVisible(true);

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
      previewforms.setVisible(false);
      settingforms.setVisible(false);
      empdirectoryforms.setVisible(false);

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

      settingBtn.setStyle("-fx-background-color: linear-gradient(to left, #3a28ff, #736ad3);");
      homeBtn.setStyle("-fx-background-color: transparent;");
      empBtn.setStyle("-fx-background-color: transparent;");
      payBtn.setStyle("-fx-background-color: transparent;");
      reportBtn.setStyle("-fx-background-color: transparent;");
      directBtn.setStyle("-fx-background-color: transparent;");

      
    }

  }
    
    
    //Dropdown items
    private String[] department = {"IT", "Marketing", "Human Resource"};
    private String[] choice2 = {"active", "inactive"};
  
    //Dropdown
    @Override
    public void initialize(URL arg0, ResourceBundle args){
      choice1.getItems().addAll(department);
      stat.getItems().addAll(choice2);
    }
    
    @FXML
    void saveEmp(ActionEvent event) {

    }

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
