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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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

     }
  
// Population Payslipsheet;
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
  payEmpTotalEarnings.setText(String.valueOf(payslip.getTotalEarnings()));
  ////

}

    //Switching forms
    
    @FXML
    void switchforms(ActionEvent event) {
      if(event.getSource()==homeBtn){
        dashboard.setVisible(true);
        payslipforms.setVisible(false);

        homeBtn.setStyle("-fx-background-color: linear-gradient(to left, #3a28ff, #736ad3);");
        paybtn.setStyle("-fx-background-color: transparent;");
        profileBtn.setStyle("-fx-background-color: transparent;");

      }
      else if(event.getSource().equals(paybtn)){
        payslipforms.setVisible(true);
        dashboard.setVisible(false);

        paybtn.setStyle("-fx-background-color: linear-gradient(to left, #3a28ff, #736ad3);");
        homeBtn.setStyle("-fx-background-color: transparent;");
        profileBtn.setStyle("-fx-background-color: transparent;");
      }
      else if (event.getSource().equals(profileBtn)){
        payslipforms.setVisible(false);
        dashboard.setVisible(false);

        profileBtn.setStyle("-fx-background-color: linear-gradient(to left, #3a28ff, #736ad3);");
        homeBtn.setStyle("-fx-background-color: transparent;");
        paybtn.setStyle("-fx-background-color: transparent;");

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
              case "paid ":
                setStyle("-fx-background-color: #dff7df; -fx-border-color: #b2ebf2; -fx-border-width: 1; margin: 2px; border-radius: 4px;");
                setTextFill(Color.web("#0b6623"));
                break;
              case "pending":
              case "pending ":
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
        


        payslip.setItems(payList);
    }

}
