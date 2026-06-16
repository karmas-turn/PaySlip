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
import javafx.scene.layout.HBox;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableCell;
import javafx.scene.paint.Color;





public class adminDashboardController implements Initializable {
    @FXML
    private TableColumn<employeeData,String> allDataDepartment;

    @FXML
    private TableColumn<employeeData,String> allDataID;

    @FXML
    private TableColumn<employeeData, String> allDataName;

    @FXML
    private TableColumn<employeeData,String> allDataPosition;

    @FXML
    private TableColumn<employeeData, String> allDataStatus;

    @FXML
    private TableView<employeeData> allDataTable;

    @FXML
    private TableColumn<employeeData, String> allDataactivites;

    @FXML
    private ChoiceBox<String> choice1;

    @FXML
    private AnchorPane empforms;

    @FXML
    private Button directBtn;

      @FXML
    private Label deptments_no;

    @FXML
    private AnchorPane empdirectoryforms;

    @FXML
    private Button empBtn;

    @FXML
    private TextField employee_id;

    @FXML
    private TextField email;

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
    private Button addEmployeeBtn;

    @FXML
    private Button updateBtn;

    @FXML
    private ChoiceBox<String> stat;

    @FXML
    private Label totalemp;

    @FXML
    private DatePicker hire_date;

    @FXML
    private Button gen;

    @FXML
    private TableView<employeeData> recentEmp;

    @FXML
    private TableColumn<employeeData, String> recentempDepartment;

    @FXML
    private TableColumn<employeeData, String> recentempID;

    @FXML
    private TableColumn<employeeData,String> recentempName;

    @FXML
    private TableColumn<employeeData, BigDecimal> recentempSalary;
    
    @FXML
    private TableColumn<employeeData, String> recentempStatus;
    
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

     @FXML
    private Button update;
    
    //DATABASE 
    private Connection connect;
    private Statement statement;
    private PreparedStatement prepare;
    private ResultSet result;

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
      try {
        loadStats();
        addEmployeeShowList();
        showemployeeList();
      } catch (Exception e) {
        System.err.println("Failed to load stats during initialization: " + e.getMessage());
        e.printStackTrace();
      }
      choice1.getItems().addAll(department);
      stat.getItems().addAll(choice2);
    }

    public ObservableList <employeeData> allEmployeeData(){
        ObservableList<employeeData> AllData = FXCollections.observableArrayList();
        String Sql= "SELECT e.id, e.employee_id, e.full_name, e.email, e.phone, e.department_id, d.name AS dept_name, e.position, e.basic_salary, e.hire_date, e.status FROM employees e LEFT JOIN departments d ON e.department_id = d.id ORDER BY e.id";

        connect = database.connectdb();
        try {
            prepare = connect.prepareStatement(Sql);
            result = prepare.executeQuery();
            while (result.next()) {
                employeeData employeeD2 = new employeeData(
                  0,
                  result.getString("employee_id"),
                  result.getString("full_name"),
                  result.getString("email"),
                  result.getString("phone"),
                  result.getInt("department_id"),
                  result.getString("dept_name"),
                  result.getString("position"),
                  result.getBigDecimal("basic_salary"),
                  result.getDate("hire_date") != null ? result.getDate("hire_date").toLocalDate() : null,
                  result.getString("status")
                );
                AllData.add(employeeD2);
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
        return AllData;
    }
        
         
    private ObservableList<employeeData> allEmployeeList;
    private int selectedEmployeeId = -1;

    public void showemployeeList(){
        allEmployeeList = allEmployeeData();
        allDataID.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        allDataName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        allDataPosition.setCellValueFactory(new PropertyValueFactory<>("position"));
        allDataStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
      // Style status cell: green for active, yellow for on leave, red for inactive
      allDataStatus.setCellFactory(column -> new TableCell<employeeData, String>() {
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
              case "active":
              case "active ":
                setStyle("-fx-background-color: #dff7df; -fx-border-color: #b2ebf2; -fx-border-width: 1; margin: 2px; border-radius: 4px;");
                setTextFill(Color.web("#0b6623"));
                break;
              case "inactive":
              case "inactive ":
                setStyle("-fx-background-color: #ffe5e5; -fx-border-color: #ffcccc; -fx-border-width: 1; padding: 2; border-radius: 4px;");
                setTextFill(Color.web("#a30000"));
                break;
              case "on leave":
              case "onleave":
              case "on leave ":
                setStyle("-fx-background-color: #fff8cc; -fx-border-color: #ffeb3b; -fx-border-width: 1; padding: 2; border-radius: 4;");
                setTextFill(Color.web("#8a6d00"));
                break;
              default:
                setStyle("");
                setTextFill(Color.BLACK);
            }
          }
        }
      });
        allDataDepartment.setCellValueFactory(new PropertyValueFactory<>("departmentName"));
        allDataactivites.setCellFactory(column -> new TableCell<employeeData, String>() {
          private final Button editButton = new Button("Edit");
          private final Button updateButton = new Button("Update");
          private final HBox buttons = new HBox(6, editButton, updateButton);

          {
            editButton.setStyle("-fx-background-color: #3498db; -fx-text-fill: white; -fx-background-radius: 4px;");
            updateButton.setStyle("-fx-background-color: #27ae60; -fx-text-fill: white; -fx-background-radius: 4px;");

            editButton.setOnAction(event -> {
              employeeData employee = getTableView().getItems().get(getIndex());
              if (employee != null) {
                empforms.setVisible(true);
                homeform.setVisible(false);
                payslipforms.setVisible(false);
                settingforms.setVisible(false);
                empdirectoryforms.setVisible(false);
                reportforms.setVisible(false);
                populateEmployeeForm(employee);
                
              }
            });

            updateButton.setOnAction(event -> {
              employeeData employee = getTableView().getItems().get(getIndex());

              if (employee != null) {
                selectedEmployeeId = employee.getId();
                if (updateEmployeeFromForm()) {
                  clearEmployeeForm();
                  showemployeeList();
                  addEmployeeShowList();
                }
              }
            });
          }

          @Override
          protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            if (empty) {
              setGraphic(null);
            } else {
              setGraphic(buttons);
            }
          }
        });

        allDataTable.setItems(allEmployeeList);
    }

    private void populateEmployeeForm(employeeData employee) {
        if (employee == null) {
            return;
        }
        selectedEmployeeId = employee.getId();
        employee_id.setText(employee.getEmployeeId());
        full_name.setText(employee.getFullName());
        email.setText(employee.getEmail());
        phone.setText(employee.getPhone());
        position.setText(employee.getPosition());
        basic_salary.setText(employee.getBasicSalary() != null ? employee.getBasicSalary().toPlainString() : "");
        choice1.setValue(employee.getDepartmentName());
        stat.setValue(employee.getStatus());
        hire_date.setValue(employee.getHireDate());
        if (updateBtn != null) {
            updateBtn.setVisible(true);
        }
        if (addEmployeeBtn != null) {
            addEmployeeBtn.setVisible(false);
        }
    }

    @FXML
    private void handleUpdateEmployee() {
        if (updateEmployeeFromForm()) {
            clearEmployeeForm();
            loadStats();
            showemployeeList();
            addEmployeeShowList();
        }
    }

    private boolean updateEmployeeFromForm() {
        if (selectedEmployeeId <= 0) {
            showAlert("Error", "No employee selected for update.");
            return false;
        }
        try {
            String sql = "UPDATE employees SET employee_id = ?, full_name = ?, email = ?, phone = ?, department_id = ?, position = ?, basic_salary = ?, hire_date = ?, status = ? WHERE id = ?";
            connect = database.connectdb();
            if (connect == null) {
                showAlert("Error", "Database connection failed.");
                return false;
            }
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, employee_id.getText().trim());
            prepare.setString(2, full_name.getText().trim());
            prepare.setString(3, email.getText().trim());
            prepare.setString(4, phone.getText().trim());
            prepare.setInt(5, parseDepartmentId(choice1.getValue()));
            prepare.setString(6, position.getText().trim());
            prepare.setBigDecimal(7, new BigDecimal(basic_salary.getText().trim()));
            prepare.setDate(8, hire_date.getValue() != null ? Date.valueOf(hire_date.getValue()) : null);
            prepare.setString(9, stat.getValue());
            prepare.setInt(10, selectedEmployeeId);
            int rows = prepare.executeUpdate();
            if (rows > 0) {
                showAlert("Success", "Employee updated successfully.");
                selectedEmployeeId = -1;
                return true;
            } else {
                showAlert("Error", "No employee record was updated.");
            }
        } catch (Exception e) {
            showAlert("Error", "Update failed: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    //Get recent employee list
    public ObservableList<employeeData> addEmployeeListData(){
        ObservableList<employeeData> ListData = FXCollections.observableArrayList();
        String Sql = "SELECT e.employee_id, e.full_name, d.name AS department, d.id AS department_id, e.status, e.basic_salary FROM employees e JOIN departments d ON e.department_id = d.id ORDER BY e.employee_id DESC ";
        
        
        connect = database.connectdb();
        try {
            prepare = connect.prepareStatement(Sql);
            result = prepare.executeQuery();
            employeeData employeeD;
           

            while (result.next() ){
            employeeD = new employeeData(
              0,
              result.getString("employee_id"),
              result.getString("full_name"),
              "", // email not selected here
              "", // phone not selected here
              result.getInt("department_id"),
              result.getString("department"),
              "", // position not selected here
              result.getBigDecimal("basic_salary"),
              null,
              result.getString("status")
            );

             ListData.add(employeeD);
                    
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListData;
    }
    
    private ObservableList<employeeData> addEmployeeList;
    public void addEmployeeShowList(){
        addEmployeeList = addEmployeeListData();
        recentempID.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        recentempName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        recentempSalary.setCellValueFactory(new PropertyValueFactory<>("basicSalary"));
      recentempStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
      // Style status cell: green for active, yellow for on leave, red for inactive
      recentempStatus.setCellFactory(column -> new TableCell<employeeData, String>() {
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
              case "active":
              case "active ":
                setStyle("-fx-background-color: #dff7df; -fx-border-color: #b2ebf2; -fx-border-width: 1; margin: 2px; border-radius: 4px;");
                setTextFill(Color.web("#0b6623"));
                break;
              case "inactive":
              case "inactive ":
                setStyle("-fx-background-color: #ffe5e5; -fx-border-color: #ffcccc; -fx-border-width: 1; padding: 2; border-radius: 4px;");
                setTextFill(Color.web("#a30000"));
                break;
              case "on leave":
              case "onleave":
              case "on leave ":
                setStyle("-fx-background-color: #fff8cc; -fx-border-color: #ffeb3b; -fx-border-width: 1; padding: 2; border-radius: 4;");
                setTextFill(Color.web("#8a6d00"));
                break;
              default:
                setStyle("");
                setTextFill(Color.BLACK);
            }
          }
        }
      });
        recentempDepartment.setCellValueFactory(new PropertyValueFactory<>("departmentName"));

        recentEmp.setItems(addEmployeeList);
    }
    
    //Get form data and create employeeData object
    private employeeData getFormData() {
        String empId = employee_id.getText().trim();
        String fullName = full_name.getText().trim();
        String email = getEmailFromForm();
        String phone = this.phone.getText().trim();
        String position = this.position.getText().trim();
        String basicSalaryStr = basic_salary.getText().trim();
        String department = choice1.getValue();
        String status = stat.getValue();
        
        int departmentId = parseDepartmentId(department);
        java.math.BigDecimal basicSalary = new java.math.BigDecimal(basicSalaryStr);
        java.time.LocalDate hireDate = hire_date.getValue();
        
        return new employeeData(0, empId, fullName, email, phone, departmentId, department, position, basicSalary, hireDate, status);
    }
    
    //Get email field from form
    private String getEmailFromForm() {
        return email.getText().trim();
    }
    
    //Parse department ID from department name (e.g., "1. IT" -> 1)
    private int parseDepartmentId(String department) {
        if (department == null || department.isEmpty()) return 0;
        try {
            String[] parts = department.split("\\.");
            return Integer.parseInt(parts[0].trim());
        } catch (Exception e) {
            return 0;
        }
    }
    
    //Clear form fields after successful submission
    private void clearEmployeeForm() {
        employee_id.clear();
        full_name.clear();
        email.clear();
        position.clear();
        basic_salary.clear();
        password.clear();
        choice1.setValue(null);
        stat.setValue(null);
        hire_date.setValue(null);
        selectedEmployeeId = -1;
        if (updateBtn != null) {
            updateBtn.setVisible(false);
        }
        if (addEmployeeBtn != null) {
            addEmployeeBtn.setVisible(true);
        }
    }
    
    //Handle Add Employee button click
    @FXML
    private void handleAddEmployee() {
        try {
            String password = this.password.getText();
            employeeData emp = getFormData();
            
            if (addEmployee(emp, password)) {
                clearEmployeeForm();
                loadStats();
                addEmployeeShowList();
            }
        } catch (NumberFormatException e) {
            showAlert("Error", "Invalid salary amount. Please enter a valid number.");
        } catch (Exception e) {
            showAlert("Error", "Error processing form: " + e.getMessage());
        }
    }
    
    


    public void loadStats(){
      connect = database.connectdb();
      String deptsql = "SELECT COUNT(name) as total FROM departments";
      String Salsql = "SELECT SUM(basic_salary) as total FROM employees ";
      String Nosql = "SELECT COUNT(*) as total FROM employees";

      try {
        prepare = connect.prepareStatement(Nosql);
        ResultSet rs1 = prepare.executeQuery();
        if(rs1.next()){
          int count = rs1.getInt("total");
          totalemp.setText(String.valueOf(count));
        }

        prepare = connect.prepareStatement(deptsql);
        ResultSet rs2 = prepare.executeQuery();
        if(rs2.next()){
          int count2 = rs2.getInt("total");
          deptments_no.setText(String.valueOf(count2));
        }

        
        PreparedStatement prepare3 = connect.prepareStatement(Salsql);
        ResultSet rs3 = prepare3.executeQuery();
        if(rs3.next()){
          float count3 = rs3.getFloat("total");
          payment.setText(String.valueOf(count3));
        }


      } catch (Exception e) {
        System.err.println("Error loading stats: " + e.getMessage());
        e.printStackTrace();
        totalemp.setText("0");
        deptments_no.setText("0");
        payment.setText("0");
      }

    }

    public boolean addEmployee(employeeData emp, String plainPassword){
        String validationError = validateEmployeeData(emp, plainPassword);
        if (validationError != null) {
            showAlert("Validation Error", validationError);
            return false;
        }

        String sql = "INSERT INTO employees(employee_id, full_name, email, phone, department_id, position, basic_salary, hire_date, status, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        connect = database.connectdb();
        
        if (connect == null) {
            showAlert("Error", "Database connection failed");
            return false;
        }
        
        try {
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, emp.getEmployeeId());
            prepare.setString(2, emp.getFullName());
            prepare.setString(3, emp.getEmail());
            prepare.setString(4, emp.getPhone());
            prepare.setInt(5, emp.getDepartmentId());
            prepare.setString(6, emp.getPosition());
            prepare.setBigDecimal(7, emp.getBasicSalary());
            prepare.setDate(8, emp.getHireDate() != null ? Date.valueOf(emp.getHireDate()) : null);
            prepare.setString(9, emp.getStatus());
            prepare.setString(10, plainPassword);

            prepare.execute();
            showAlert("Success", "Employee added successfully");
            return true;

        } catch (Exception e) {
            showAlert("Error", "Failed to add employee: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (connect != null) connect.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private String validateEmployeeData(employeeData emp, String password) {
        if (emp.getEmployeeId() == null || emp.getEmployeeId().trim().isEmpty()) {
            return "Employee ID is required";
        }
        if (emp.getFullName() == null || emp.getFullName().trim().isEmpty()) {
            return "Full name is required";
        }
        if (emp.getEmail() == null || !emp.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            return "Valid email is required";
        }
        if (emp.getPhone() == null || !emp.getPhone().matches("\\d{10}")) {
            return "Valid phone number (10 digits) is required";
        }
        if (emp.getDepartmentId() <= 0) {
            return "Valid department is required";
        }
        if (emp.getPosition() == null || emp.getPosition().trim().isEmpty()) {
            return "Position is required";
        }
        if (emp.getBasicSalary() == null || emp.getBasicSalary().signum() <= 0) {
            return "Basic salary must be greater than 0";
        }
        if (emp.getHireDate() == null) {
            return "Hire date is required";
        }
        if (emp.getStatus() == null || emp.getStatus().trim().isEmpty()) {
            return "Status is required";
        }
        if (password == null || password.length() < 6) {
            return "Password must be at least 6 characters";
        }
        return null;
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
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
