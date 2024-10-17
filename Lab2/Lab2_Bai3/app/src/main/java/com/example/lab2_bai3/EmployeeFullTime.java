
// EmployeeFullTime.java
package com.example.lab2_bai3;

public class EmployeeFullTime extends Employee {
    @Override
    public double tinhLuong() {
        // Implement the salary calculation logic for full-time employees
        return 500; // Example value
    }

    @Override
    public String toString() {
        return getId() + " - " + getName() + "-->FullTime=" + tinhLuong();
    }
}
