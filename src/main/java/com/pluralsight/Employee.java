package com.pluralsight;

import java.time.Duration;
import java.time.LocalDateTime;

public class Employee {
    private int employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    private boolean isClockedIn;
    private LocalDateTime clockedInAt;

    public Employee(int employeeId, String name, String department, double payRate, double hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getRegularHours() {
        return (hoursWorked > 40) ? 40 : hoursWorked;
    }

    public double getOvertimeHours() {
        return (hoursWorked > 40) ? hoursWorked - 40 : 0;
    }

    public double getTotalPay() {
        return this.payRate * (this.getRegularHours() + this.getOvertimeHours() * 1.5);
    }

    public void punchIn(LocalDateTime time) {
        this.clockedInAt = time;
        this.isClockedIn = true;
    }

    public void punchIn() {
        this.clockedInAt = LocalDateTime.now();
        this.isClockedIn = true;
    }

    public void punchOut(LocalDateTime time) {
        Duration duration = Duration.between(this.clockedInAt, time);
        double hours = duration.toMinutes() / 60.00;
        this.hoursWorked += hours;
        this.isClockedIn = false;
    }

    public void punchOut() {
        Duration duration = Duration.between(this.clockedInAt, LocalDateTime.now());
        double hours = duration.toMinutes() / 60.00;
        this.hoursWorked += hours;
        this.isClockedIn = false;
    }

    public void punchTimeCard() {
        if (isClockedIn) {
            this.isClockedIn = false;
            Duration duration = Duration.between(this.clockedInAt, (LocalDateTime.now()));
            double hours = duration.toMinutes() / 60.00;
            this.hoursWorked += hours;
        }
        else {
            this.clockedInAt = LocalDateTime.now();
            isClockedIn = true;
        }
    }

    // overloaded constructor for punchTimeCard for manually entering in time
    public void punchTimeCard(LocalDateTime start, LocalDateTime end) {
        Duration duration = Duration.between(start, end);
        double hours = duration.toMinutes() / 60.00;
        this.hoursWorked += hours;
    }
}
