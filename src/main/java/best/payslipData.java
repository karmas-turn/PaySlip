package best;

import java.math.BigDecimal;

public class payslipData {
    private int id;
    private int employeeId;
    private String payPeriodMonth;
    private String payPeriodYear;
    private BigDecimal basicSalary;
    private double transport;
    private double allowance;
    private double ssnit;
    private double tax;
    private double otherDeductions;
    private double totalEarnings;
    private double totalDeductions;
    private double netPay;
    private String status;

  

    // Full Constructor (Useful for populating from a database ResultSet)
    public payslipData(int id, int employeeId, String payPeriodMonth, String payPeriodYear,  BigDecimal basicSalary, double transport, double allowance,  double ssnit, double tax, double otherDeductions,  double totalEarnings, double totalDeductions, double netPay, String status) {
        this.id = id;
        this.employeeId = employeeId;
        this.payPeriodMonth = payPeriodMonth;
        this.payPeriodYear = payPeriodYear;
        this.basicSalary = basicSalary;
        this.transport = transport;
        this.allowance = allowance;
        this.ssnit = ssnit;
        this.tax = tax;
        this.otherDeductions = otherDeductions;
        this.totalEarnings = totalEarnings;
        this.totalDeductions = totalDeductions;
        this.netPay = netPay;
        this.status = status;
    }

    // --- Getters and Setters ---

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getEmployeeId() { return employeeId; }
    public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }

    public String getPayPeriodMonth() { return payPeriodMonth; }
    public void setPayPeriodMonth(String payPeriodMonth) { this.payPeriodMonth = payPeriodMonth; }

    public String getPayPeriodYear() { return payPeriodYear; }
    public void setPayPeriodYear(String payPeriodYear) { this.payPeriodYear = payPeriodYear; }

    public BigDecimal getBasicSalary() { return basicSalary; }
    public void setBasicSalary(BigDecimal basicSalary) { this.basicSalary = basicSalary; }

    public double getTransport() { return transport; }
    public void setTransport(double transport) { this.transport = transport; }

    public double getAllowance() { return allowance; }
    public void setAllowance(double allowance) { this.allowance = allowance; }

    public double getSsnit() { return ssnit; }
    public void setSsnit(double ssnit) { this.ssnit = ssnit; }

    public double getTax() { return tax; }
    public void setTax(double tax) { this.tax = tax; }

    public double getOtherDeductions() { return otherDeductions; }
    public void setOtherDeductions(double otherDeductions) { this.otherDeductions = otherDeductions; }

    public double getTotalEarnings() { return totalEarnings; }
    public void setTotalEarnings(double totalEarnings) { this.totalEarnings = totalEarnings; }

    public double getTotalDeductions() { return totalDeductions; }
    public void setTotalDeductions(double totalDeductions) { this.totalDeductions = totalDeductions; }

    public double getNetPay() { return netPay; }
    public void setNetPay(double netPay) { this.netPay = netPay; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    
}
