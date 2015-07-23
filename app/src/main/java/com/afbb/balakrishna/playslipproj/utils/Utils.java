package com.afbb.balakrishna.playslipproj.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.afbb.balakrishna.playslipproj.core.Employee;
import com.afbb.balakrishna.playslipproj.interfaces.Constants;

public final class Utils {

    private Context context;
    private static Utils instance;

    public Utils(Context context) {
        this.context = context;
    }

    public static Utils getInstance(Context context) {
        if (instance == null) {
            instance = new Utils(context);
        }
        return instance;
    }


    public void saveUserInPreference(Employee employee) {
        SharedPreferences preferences = context.getSharedPreferences(Constants.PREFF_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor edit = preferences.edit();
        edit.putString(Constants.KEY_EMP_ID, employee.getEmpId());
        edit.putString(Constants.KEY_NAME, employee.getName());
        edit.putString(Constants.KEY_ACCOUNT_NUMBER, employee.getAccountNo());
        edit.putString(Constants.KEY_PAN_NUMBER, employee.getPanNo());
        edit.putString(Constants.KEY_BRANCH, employee.getBranch());
        edit.putString(Constants.KEY_DEPARTMENT, employee.getDept());
        edit.putString(Constants.KEY_DESIGNATION, employee.getDesignation());
        edit.putString(Constants.KEY_DOJ, employee.getDOJ());
        edit.putString(Constants.KEY_DOR, employee.getDOR());
        edit.commit();
    }

    public Employee getEmployeePreference() {
        SharedPreferences preferences = context.getSharedPreferences(Constants.PREFF_NAME, context.MODE_PRIVATE);
        String empID = preferences.getString(Constants.KEY_EMP_ID, null);
        String name = preferences.getString(Constants.KEY_NAME, null);
        String acco = preferences.getString(Constants.KEY_ACCOUNT_NUMBER, null);
        String pan = preferences.getString(Constants.KEY_PAN_NUMBER, null);
        String branch = preferences.getString(Constants.KEY_BRANCH, null);
        String dept = preferences.getString(Constants.KEY_DEPARTMENT, null);
        String designation = preferences.getString(Constants.KEY_DESIGNATION, null);
        String doj = preferences.getString(Constants.KEY_DOJ, null);
        String dor = preferences.getString(Constants.KEY_DOR, null);

        Employee employee = new Employee(empID, name, dept, designation, pan, acco, branch, doj, dor);
        return employee;


    }

}
