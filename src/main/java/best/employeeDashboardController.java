package best;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableCell;


import java.net.URL;

public class employeeDashboardController implements Initializable{
    @FXML
    private Label allowanceLabel;

    @FXML
    private AnchorPane dashboard;

    @FXML
    private Button homeBtn;

    @FXML
    private Label netPayLabel;

    @FXML
    private TableColumn<payslipData, String> payAction;

    @FXML
    private TableColumn<payslipData, String> payMonth;

    @FXML
    private TableColumn<payslipData, Double> payNet;

    @FXML
    private TableColumn<payslipData,String> payStatus;

    @FXML
    private TableView<payslipData> payslip;


    @FXML
    private TableColumn<payslipData, String> payYear;

    @FXML
    private Button paybtn;

    @FXML
    private AnchorPane payslipforms;

    @FXML
    private Button profileBtn;

    @FXML
    private Label salaryLabel;

    @FXML
    private Label totalDeductionLabel;

    @FXML
    private Label usernameLabel;
    


      @FXML
    private Label payEmpAllowance;

    @FXML
    private Label payEmpBasicSalary;

    @FXML
    private Label payEmpID;

    @FXML
    private Label payEmpName;

    @FXML
    private Label payEmpNetPay;

    @FXML
    private Label payEmpOtherDeductions;

    @FXML
    private Label payEmpPosition;

    @FXML
    private Label payEmpTax;

    @FXML
    private Label payEmpTotalDeductions;

    @FXML
    private Label payEmpTotalDeductions1;

    @FXML
    private Label payEmpTotalEarnings;

    @FXML
    private Label payEmpTotalEarnings1;

    @FXML
    private Label payEmpTransport;

    @FXML
    private Label payEmpssnit;

     @FXML
    private Label payEmpDepartment;
    @FXML
    private Button backBtn;
    @FXML
    private AnchorPane profileforms;

    @FXML
    private AnchorPane changePasswordForms;

    @FXML
    private Button profileBtn1;

    @FXML
    private Button chnagePasswordBtn;
    
    @FXML
    private AnchorPane firstpre;
    
    @FXML
    private AnchorPane settingforms;

    @FXML
    private PasswordField confirmNewPasswordField;

    @FXML
    private PasswordField newPasswordField;

    @FXML
    private PasswordField oldPasswordField;

     @FXML
    private TextField emailField;

    @FXML
    private TextField fullNameField;


   private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
  
    @Override
    public void initialize(URL arg0, ResourceBundle args){
      try{
        DisplayName();
      ShowPaySlips();
      } catch(Exception e){
        System.err.println("Failed to load stats during initialization: " + e.getMessage());
        e.printStackTrace();
      }
    }
  
    
    @FXML
    void switchSetting(ActionEvent event){
          if(event.getSource() == profileBtn1){
            profileforms.setVisible(true);
            changePasswordForms.setVisible(false);

            profileBtn1.setStyle("-fx-background-color: linear-gradient(to left,  #8c86ce, #bfbce7);");
            chnagePasswordBtn.setStyle("-fx-background-color: white");
          }
          else if(event.getSource() == chnagePasswordBtn){
            profileforms.setVisible(false);
            changePasswordForms.setVisible(true);

            chnagePasswordBtn.setStyle("-fx-background-color: linear-gradient(to left, #8c86ce, #bfbce7);");
            profileBtn1.setStyle("-fx-background-color: white");
          }
          else if (event.getSource().equals(null)){
             profileforms.setVisible(true);
            changePasswordForms.setVisible(false);

            profileBtn1.setStyle("-fx-background-color: linear-gradient(to left,  #8c86ce, #bfbce7);");
            chnagePasswordBtn.setStyle("-fx-background-color: white");
          }
    }

    
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
      //Display the name of the user logged in
    public void DisplayName(){
      usernameLabel.setText(getData.username);
      payEmpID.setText(getData.employeeID);
      payEmpName.setText(getData.username);
      payEmpPosition.setText(getData.position);
      payEmpDepartment.setText(getData.department);
      fullNameField.setText(getData.username);
      emailField.setText(getData.email);

     }
  
    //Switching forms
    
    @FXML
    void switchforms(ActionEvent event) {
      if(event.getSource()==homeBtn || event.getSource() == backBtn ){
        dashboard.setVisible(true);
        payslipforms.setVisible(false);
        settingforms.setVisible(false);

        homeBtn.setStyle("-fx-background-color: linear-gradient(to left, #3a28ff, #736ad3);");
        profileBtn.setStyle("-fx-background-color: transparent;");

      }
      
      else if (event.getSource().equals(profileBtn)){
        payslipforms.setVisible(false);
        dashboard.setVisible(false);
        settingforms.setVisible(true);

        profileBtn.setStyle("-fx-background-color: linear-gradient(to left, #3a28ff, #736ad3);");
        homeBtn.setStyle("-fx-background-color: transparent;");
        

      }
    }

    public ObservableList<payslipData> getEmployeePayslips() {
    ObservableList<payslipData> payslipList = FXCollections.observableArrayList();
    
    // SQL Query filtering explicitly by the logged in employee's ID
      String sql = "SELECT * FROM payslips WHERE employee_id = ? ORDER BY pay_period_year DESC, pay_period_month DESC";
    
     connect = database.connectdb();
    
    try  {
        prepare = connect.prepareStatement(sql);
        // Bind the uniquely saved ID from our global session state
        prepare.setInt(1, getData.employeeId);
        result = prepare.executeQuery();
         
        
            while (result.next()) {
               
                payslipData payslip = new payslipData(result.getInt("id"),
                 getData.employeeId, 
                 result.getString("pay_period_month"), 
                 result.getString("pay_period_year"), 
                 result.getBigDecimal("basic_salary"),
                  result.getDouble("transport"),
                   result.getDouble("allowance"), 
                   result.getDouble("ssnt"),
                    result.getDouble("tax"), 
                    result.getDouble("other_deductions"),
                     result.getDouble("total_earnings"),
                      result.getDouble("total_deductions"), 
                      result.getDouble("net_pay"),
                       result.getString("status"));
                
                payslipList.add(payslip);
            }
                
    } catch (SQLException e) {
        e.printStackTrace();
    }
  
    return payslipList;
}
    


    private ObservableList<payslipData> payList;
   public void ShowPaySlips(){
        payList = getEmployeePayslips();
        payMonth.setCellValueFactory(new PropertyValueFactory<>("payPeriodMonth"));
        payYear.setCellValueFactory(new PropertyValueFactory<>("payPeriodYear"));
        payNet.setCellValueFactory(new PropertyValueFactory<>("netPay"));
        payStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        
        // Style status cell: green for active, yellow for on leave, red for inactive
        payStatus.setCellFactory(column -> new TableCell<payslipData, String>() {
            @Override
            protected void updateItem(String status, boolean empty) {
                super.updateItem(status, empty);
                if (empty || status == null) {
                    setText(null);
                    setStyle("");
                } else {
                    setText(status);
                    String s = status.toLowerCase().trim();
                    switch (s) {
                        case "paid":
                            setStyle("-fx-background-color: #dff7df; -fx-border-color: #b2ebf2; -fx-border-width: 1; margin: 2px; border-radius: 4px;");
                            setTextFill(Color.web("#0b6623"));
                            break;
                        case "pending":
                            setStyle("-fx-background-color: #ffe5e5; -fx-border-color: #ffcccc; -fx-border-width: 1; padding: 2; border-radius: 4px;");
                            setTextFill(Color.web("#a30000"));
                            break;
                        default:
                            setStyle("");
                            setTextFill(Color.BLACK);
                    }
                }
            }
        });

        // 1. ADDED: Set up the Action Column (Adds a "View" button inside the table itself)
        payAction.setCellFactory(column -> new TableCell<payslipData, String>() {
            private final Button viewButton = new Button("View");

            {
                viewButton.setStyle("-fx-background-color: #3a28ff; -fx-text-fill: white; -fx-cursor: hand;");
                viewButton.setOnAction(event -> {
                    payslipData data = getTableView().getItems().get(getIndex());
                    populatePaySlipSheet(data);
                    
                    // Automatically route them to the form view pane if it's hidden
                    payslipforms.setVisible(true);
                    dashboard.setVisible(false);
                
                    homeBtn.setStyle("-fx-background-color: transparent;");
                });
            }

            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(viewButton);
                }
            }
        });

        // 2. ADDED: Row Selection Listener (Clicking anywhere on the row populates the slip sheet)
        payslip.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                populatePaySlipSheet(newValue);
            }
        });

        payslip.setItems(payList);
        
        // 3. ADDED: Update Dashboard Home summary cards (Displays latest payslip data if available)
        if (!payList.isEmpty()) {
            payslipData latestPayslip = payList.get(0); // Assumes ordered by newest
            salaryLabel.setText(latestPayslip.getBasicSalary().toPlainString());
            allowanceLabel.setText(String.valueOf(latestPayslip.getAllowance()));
            totalDeductionLabel.setText(String.valueOf(latestPayslip.getTotalDeductions()));
            netPayLabel.setText( String.valueOf(latestPayslip.getNetPay()));
            
        }
    }

    // 4. ADDED: Missing fields mapping inside populatePaySlipSheet 
    // This completes mapping all the labels you declared at the top of the file.
    private void populatePaySlipSheet(payslipData payslip){
        if(payslip == null){
            return;
        }
        payEmpBasicSalary.setText(payslip.getBasicSalary().toPlainString());
        payEmpNetPay.setText(String.valueOf(payslip.getNetPay()));
        payEmpOtherDeductions.setText(String.valueOf(payslip.getOtherDeductions()));
        payEmpAllowance.setText(String.valueOf(payslip.getAllowance()));
        payEmpTax.setText(String.valueOf(payslip.getTax()));
        payEmpTotalDeductions1.setText(String.valueOf(payslip.getTotalDeductions()));
        payEmpTotalDeductions.setText(String.valueOf(payslip.getTotalDeductions())); // Form mapping
        payEmpTotalEarnings.setText(String.valueOf(payslip.getTotalEarnings()));
        payEmpTotalEarnings1.setText(String.valueOf(payslip.getTotalEarnings())); // Form mapping alternative
        payEmpTransport.setText(String.valueOf(payslip.getTransport()));
        payEmpssnit.setText(String.valueOf(payslip.getSsnit()));

    }
    



    
public boolean changePassword(int employeeId, String enteredOldPassword, String enteredNewPassword) {
    connect = database.connectdb();
    
    // Step 1: Verify the old password matches the database
    String verificationSql = "SELECT password FROM employees WHERE id = ?";
    try {
        prepare = connect.prepareStatement(verificationSql);
        prepare.setInt(1, employeeId);
        result = prepare.executeQuery();
        
        if (result.next()) {
            String dbPassword = result.getString("password");
            
            // Check if entered old password matches what's in the database
            // Note: If you use encryption (like BCrypt), use BCrypt.checkpw(enteredOldPassword, dbPassword) here instead
            if (!dbPassword.equals(enteredOldPassword)) {
                showAlert(AlertType.ERROR, "Validation Error", "The old password you entered is incorrect.");
                return false;
            }
        } else {
            showAlert(AlertType.ERROR, "Error", "Employee account not found.");
            return false;
        }
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    } finally {
        closeResources();
    }

    // Step 2: Update to the new password
    String updateSql = "UPDATE employees SET password = ? WHERE id = ?";
    try {
        connect = database.connectdb();
        prepare = connect.prepareStatement(updateSql);
        prepare.setString(1, enteredNewPassword); // Hash this in production!
        prepare.setInt(2, employeeId);
        
        int rowsUpdated = prepare.executeUpdate();
        return rowsUpdated > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        showAlert(AlertType.ERROR, "Database Error", "Failed to update password.");
        return false;
    } finally {
        closeResources();
    }
}

@FXML
private void handleUserDetailsSubmit(ActionEvent event){
    String Fullname = fullNameField.getText();
    String email = emailField.getText();
    
    if(Fullname.isEmpty()|| email.isEmpty()){
        showAlert(AlertType.ERROR, "Validation Error", "All fields must be filled");
        return;
    }
    
    int currentEmpId = getData.employeeId;
    boolean updateSuccessful = changeUserData(currentEmpId, Fullname, email);
    
    if(updateSuccessful){
        showAlert(AlertType.INFORMATION, "Success", "Successfully updated user details");
    }
}

@FXML
private void handlePasswordResetSubmit(ActionEvent event) {
    String oldPassword = oldPasswordField.getText();
    String newPassword = newPasswordField.getText();
    String confirmNewPassword = confirmNewPasswordField.getText();

    // 1. Check for empty fields
    if (oldPassword.isEmpty() || newPassword.isEmpty() || confirmNewPassword.isEmpty()) {
        showAlert(AlertType.ERROR, "Validation Error", "All fields must be filled out.");
        return;
    }

    // 2. Check if the two new passwords match each other
    if (!newPassword.equals(confirmNewPassword)) {
        showAlert(AlertType.ERROR, "Validation Error", "New password confirmation does not match.");
        return;
    }
    
    // 3. Optional: Enforce password strength minimum length
    if (newPassword.length() < 6) {
        showAlert(AlertType.ERROR, "Validation Error", "New password must be at least 6 characters long.");
        return;
    }

    // 4. Run database operation using global session data
    int currentEmpId = getData.employeeId; 
    
    boolean updateSuccessful = changePassword(currentEmpId, oldPassword, newPassword);
    
    if (updateSuccessful) {
        showAlert(AlertType.INFORMATION, "Success", "Your password has been changed successfully!");
        
        // Clear UI inputs for security
        oldPasswordField.clear();
        newPasswordField.clear();
        confirmNewPasswordField.clear();
    }
}

public boolean changeUserData(int employeeId, String enteredFullName, String enteredEmail) {

connect = database.connectdb();
    
    // Step 1: Update to the new userdetails
    String updateSql = "UPDATE employees SET full_name = ? ,email = ? WHERE id = ?";
    try {
        connect = database.connectdb();
        prepare = connect.prepareStatement(updateSql);
        prepare.setString(1, enteredFullName); 
        prepare.setString(2,enteredEmail);
        prepare.setInt(3, employeeId);
        
        int rowsUpdated = prepare.executeUpdate();
        return rowsUpdated > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        showAlert(AlertType.ERROR, "Database Error", "Failed to update details.");
        return false;
    } finally {
        closeResources();
    }

}

// Quick helper to close DB connections safely
private void closeResources() {
    try {
        if (result != null) result.close();
        if (prepare != null) prepare.close();
        if (connect != null) connect.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


// Global alert utility method
private void showAlert(AlertType type, String title, String content) {
    Alert alert = new Alert(type);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(content);
    alert.showAndWait();
}
}