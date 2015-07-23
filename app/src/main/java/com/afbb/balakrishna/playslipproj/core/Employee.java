package com.afbb.balakrishna.playslipproj.core;

public class Employee {
    String empId;
    String name;
    String dept;
    String designation;
    String panNo;
    String accountNo;
    String branch;
    String DOJ;
    String DOR;

    public Employee(String empId, String name, String dept, String designation, String panNo, String accountNo, String branch, String DOJ, String DOR) {
        this.empId = empId;
        this.name = name;
        this.dept = dept;
        this.designation = designation;
        this.panNo = panNo;
        this.accountNo = accountNo;
        this.branch = branch;
        this.DOJ = DOJ;
        this.DOR = DOR;
    }

    public String getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public String getDept() {
        return dept;
    }

    public String getDesignation() {
        return designation;
    }

    public String getPanNo() {
        return panNo;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public String getBranch() {
        return branch;
    }

    public String getDOJ() {
        return DOJ;
    }

    public String getDOR() {
        return DOR;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId='" + empId + '\'' +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", designation='" + designation + '\'' +
                ", panNo='" + panNo + '\'' +
                ", accountNo='" + accountNo + '\'' +
                ", branch='" + branch + '\'' +
                ", DOJ='" + DOJ + '\'' +
                ", DOR='" + DOR + '\'' +
                '}';
    }
}
