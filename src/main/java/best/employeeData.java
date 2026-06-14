package best;

import java.math.BigDecimal;
import java.time.LocalDate;

public class employeeData {
  
    private int       id;
    private String    employeeId;   // EMP001
    private String    fullName;
    private String    email;
    private String    phone;
    private int       departmentId;
    private String    departmentName;
    private String    position;
    private BigDecimal basicSalary;
    private LocalDate hireDate;
    private String    status; 


    public employeeData(int id, String employeeId, String fullName, String email, String phone, int departmentId, String departmentName, String position, BigDecimal basicSalary, LocalDate hireDate, String status) {
        this.id             = id;
        this.employeeId     = employeeId;
        this.fullName       = fullName;
        this.email          = email;
        this.phone          = phone;
        this.departmentId   = departmentId;
        this.departmentName = departmentName;
        this.position       = position;
        this.basicSalary    = basicSalary;
        this.hireDate       = hireDate;
        this.status         = status;

    }

    public int       getId()              { return id; }
    public void      setId(int id)        { this.id = id; }

    public String    getEmployeeId()      { return employeeId; }
    public void      setEmployeeId(String v) { this.employeeId = v; }

    public String    getFullName()        { return fullName; }
    public void      setFullName(String v){ this.fullName = v; }

    public String    getEmail()           { return email; }
    public void      setEmail(String v)   { this.email = v; }

    public String    getPhone()           { return phone; }
    public void      setPhone(String v)   { this.phone = v; }

    public int       getDepartmentId()    { return departmentId; }
    public void      setDepartmentId(int v){ this.departmentId = v; }

    public String    getDepartmentName()  { return departmentName; }
    public void      setDepartmentName(String v){ this.departmentName = v; }

    public String    getPosition()        { return position; }
    public void      setPosition(String v){ this.position = v; }

    public BigDecimal getBasicSalary()    { return basicSalary; }
    public void      setBasicSalary(BigDecimal v){ this.basicSalary = v; }

    public LocalDate getHireDate()        { return hireDate; }
    public void      setHireDate(LocalDate v){ this.hireDate = v; }

    public String    getStatus()          { return status; }
    public void      setStatus(String v)  { this.status = v; }


}
