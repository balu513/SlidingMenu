package com.afbb.balakrishna.playslipproj.core;

import android.os.Parcel;
import android.os.Parcelable;

public class PayslipBean implements Parcelable {
    private String empId;
    private String userId;
    private String toDate;
    private String fromDate;
    private float grossSal;
    private float basicSal;
    private float hra;


    private float medicalSal;
    private float convSal;
    private float specialSal;
    private float leaves;
    private float pfTax;
    private float tds;
    private float advSalary;
    private float otherDeductions;
    private float net;
    private String accNum;
    private String name;
    private String deptName;
    private String doj;
    private String dor;
    private String panNum;
    private String designation;

    @Override
    public String toString() {
        return "PayslipBean{" +
                "empId='" + empId + '\'' +
                ", userId='" + userId + '\'' +
                ", toDate='" + toDate + '\'' +
                ", fromDate='" + fromDate + '\'' +
                ", grossSal=" + grossSal +
                ", basicSal=" + basicSal +
                ", hra=" + hra +
                ", medicalSal=" + medicalSal +
                ", convSal=" + convSal +
                ", specialSal=" + specialSal +
                ", leaves=" + leaves +
                ", pfTax=" + pfTax +
                ", tds=" + tds +
                ", advSalary=" + advSalary +
                ", otherDeductions=" + otherDeductions +
                ", net=" + net +
                ", accNum='" + accNum + '\'' +
                ", name='" + name + '\'' +
                ", deptName='" + deptName + '\'' +
                ", doj='" + doj + '\'' +
                ", panNum='" + panNum + '\'' +
                ", designation='" + designation + '\'' +
                ", branch='" + branch + '\'' +
                '}';
    }

    private String branch;

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public float getHra() {
        return hra;
    }

    public void setHra(float hra) {
        this.hra = hra;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public float getGrossSal() {
        return grossSal;
    }

    public void setGrossSal(float grossSal) {
        this.grossSal = grossSal;
    }

    public float getBasicSal() {
        return basicSal;
    }

    public void setBasicSal(float basicSal) {
        this.basicSal = basicSal;
    }

    public float getNet() {
        return net;
    }

    public void setNet(float net) {
        this.net = net;
    }

    public float getMedicalSal() {
        return medicalSal;
    }

    public void setMedicalSal(float medicalSal) {
        this.medicalSal = medicalSal;
    }

    public float getConvSal() {
        return convSal;
    }

    public void setConvSal(float convSal) {
        this.convSal = convSal;
    }

    public float getSpecialSal() {
        return specialSal;
    }

    public void setSpecialSal(float specialSal) {
        this.specialSal = specialSal;
    }

    public float getLeaves() {
        return leaves;
    }

    public void setLeaves(float leaves) {
        this.leaves = leaves;
    }

    public float getPfTax() {
        return pfTax;
    }

    public void setPfTax(float pfTax) {
        this.pfTax = pfTax;
    }

    public float getTds() {
        return tds;
    }

    public void setTds(float tds) {
        this.tds = tds;
    }

    public float getAdvSalary() {
        return advSalary;
    }

    public void setAdvSalary(float advSalary) {
        this.advSalary = advSalary;
    }

    public float getOtherDeductions() {
        return otherDeductions;
    }

    public void setOtherDeductions(float otherDeductions) {
        this.otherDeductions = otherDeductions;
    }

    public String getAccNum() {
        return accNum;
    }

    public void setAccNum(String accNum) {
        this.accNum = accNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }

    public String getPanNum() {
        return panNum;
    }

    public void setPanNum(String panNum) {
        this.panNum = panNum;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getDor() {
        return dor;
    }

    public void setDor(String dor) {
        this.dor = dor;
    }


    public String display() {
        String html = "<html>" +
                "<head>" +
                "        <style type=\"text/css\">" +
                "            #fixedheight {" +
                "                table-layout: fixed;" +
                "            }" +
                "" +
                "            #fixedheight td {" +
                "                height: 20px;" +
                "                overflow: hidden;" +
                "                width: 25%;" +
                "            }" +
                "        </style>" +
                "    </head>" +
                "    " +
                "<body>" +
                "<table width=\"1000px\" border=\"1\" cellpadding=\"0\" cellspacing=\"0\"  style=\"border-collapse:collapse;\" rules=\"none\">" +
                "<tr>" +
                "<td width=\"20%\">Name</td>" +
                "<td width=\"30%\">" + getName() +
                "</td>" +
                "<td width=\"20%\">Emp ID</td>" +
                "<td width=\"30%\">" + getEmpId() +
                "</td>" +
                "</tr>" +
                "<tr>" +
                "<td>Pay period</td>" +
                "<td>" + getFromDate() +
                " to " + getToDate() +
                "</td>" +
                "<td>Account Number</td>" +
                "<td>" + getAccNum() +
                "</td>" +
                "</tr>" +
                "<tr>" +
                "<td>PAN Card Number</td>" +
                "<td>" + getPanNum() +
                "</td>" +
                "<td>Branch</td>" +
                "<td>" + getBranch() +
                "</td>" +
                "</tr>" +
                "</table>" +
                "" +
                "<br/><br/>" +
                "<table width=\"1000px\" id=\"fixedheight\" border=\"1\" cellpadding=\"0\" cellspacing=\"0\"  style=\"border-collapse:collapse;\" >" +
                "<col width=\"250\"/>" +
                "<col width=\"200\"/>" +
                "<col width=\"250\"/>" +
                "<col width=\"200\"/>" +
                "<tr>" +
                "<th colspan=\"2\">EARNINGS</th>" +
                "" +
                "<th colspan=\"2\">DEDUCTIONS</th>" +
                "" +
                "</tr>" +
                "" +
                "<tr>" +
                "<td width=\"20%\">BASICS</td>" +
                "<td width=\"30%\">" + getBasicSal() +
                "</td>" +
                "<td width=\"20%\">PROFESSIONAL TAX</td>" +
                "<td width=\"30%\">" + getPfTax() +
                "</td>" +
                "</tr>" +
                "<tr>" +
                "<td>HRA</td>" +
                "<td>" + getHra() +
                "</td>" +
                "<td>TDS</td>" +
                "<td>" + getTds() +
                "</td>" +
                "</tr>" +
                "" +
                "<tr>" +
                "<td>CONVAYANCES ALLOWANCES</td>" +
                "<td>" + getConvSal() +
                "</td>" +
                "<td>LEAVES</td>" +
                "<td>" + getLeaves() +
                "</td>" +
                "</tr>" +
                "<tr>" +
                "<td>MEDICAL ALLOWANCES</td>" +
                "<td>" + getMedicalSal() +
                "</td>" +
                "<td>SALARY ADVANCE</td>" +
                "<td>" + getAdvSalary() +
                "</td>" +
                "</tr>" +
                "<tr>" +
                "<td>SPECIAL ALLOWANCES</td>" +
                "<td>" + getSpecialSal() +
                "</td>" +
                "<td>TDS</td>" +
                "<td>" + getTds() +
                "</td>" +
                "</tr>" +
                "<tr>" +
                "<td><b>GROSS EARNINGS</b></td>" +
                "<td>" + getGrossSal() +
                "</td>" +
                "<td><b>TOTAL DEDUCTIONS</b></td>" +
                "<td>" + getOtherDeductions() +
                "</td>" +
                "</tr>" +
                "<tr>" +
                "<td colspan=\"4\">" +
                "</td>" +
                "</tr>" +
                "" +
                "<tr>" +
                "<td>NET SALARY</td><td colspan=\"3\">1000</td>" +
                "</tr>" +
                "" +
                "</table>" +
                "</body>" +
                "</html>";

        return html;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.empId);
        dest.writeString(this.userId);
        dest.writeString(this.toDate);
        dest.writeString(this.fromDate);
        dest.writeFloat(this.grossSal);
        dest.writeFloat(this.basicSal);
        dest.writeFloat(this.hra);
        dest.writeFloat(this.medicalSal);
        dest.writeFloat(this.convSal);
        dest.writeFloat(this.specialSal);
        dest.writeFloat(this.leaves);
        dest.writeFloat(this.pfTax);
        dest.writeFloat(this.tds);
        dest.writeFloat(this.advSalary);
        dest.writeFloat(this.otherDeductions);
        dest.writeFloat(this.net);
        dest.writeString(this.accNum);
        dest.writeString(this.name);
        dest.writeString(this.deptName);
        dest.writeString(this.doj);
        dest.writeString(this.dor);
        dest.writeString(this.panNum);
        dest.writeString(this.designation);
        dest.writeString(this.branch);
    }

    public PayslipBean() {
    }

    protected PayslipBean(Parcel in) {
        this.empId = in.readString();
        this.userId = in.readString();
        this.toDate = in.readString();
        this.fromDate = in.readString();
        this.grossSal = in.readFloat();
        this.basicSal = in.readFloat();
        this.hra = in.readFloat();
        this.medicalSal = in.readFloat();
        this.convSal = in.readFloat();
        this.specialSal = in.readFloat();
        this.leaves = in.readFloat();
        this.pfTax = in.readFloat();
        this.tds = in.readFloat();
        this.advSalary = in.readFloat();
        this.otherDeductions = in.readFloat();
        this.net = in.readFloat();
        this.accNum = in.readString();
        this.name = in.readString();
        this.deptName = in.readString();
        this.doj = in.readString();
        this.dor = in.readString();
        this.panNum = in.readString();
        this.designation = in.readString();
        this.branch = in.readString();
    }

    public static final Parcelable.Creator<PayslipBean> CREATOR = new Parcelable.Creator<PayslipBean>() {
        public PayslipBean createFromParcel(Parcel source) {
            return new PayslipBean(source);
        }

        public PayslipBean[] newArray(int size) {
            return new PayslipBean[size];
        }
    };
}
