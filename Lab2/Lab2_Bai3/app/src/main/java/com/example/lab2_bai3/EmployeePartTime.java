// EmployeePartTime.java
package com.example.lab2_bai3;

public class EmployeePartTime extends Employee {
    @Override
    public double tinhLuong() {
        // Implement the salary calculation logic for part-time employees
        return 150; // Example value
    }
    @Override
    public String toString() {
        return getId() + " - " + getName() + "-->PartTime=" + tinhLuong();
    }
}