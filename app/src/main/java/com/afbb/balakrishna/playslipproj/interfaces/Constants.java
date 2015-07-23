package com.afbb.balakrishna.playslipproj.interfaces;


public interface Constants {

    public static final String URL_LOGIN = "http://192.168.50.118/phpws/Demo/PayslipProject/api/userlogin.php";
    public static final String URL_CHANGE_PWD = "http://192.168.50.118/phpws/Demo/PayslipProject/api/change_password.php";
    public static final String URL_GET_PAYSLIPS = "http://192.168.50.118/phpws/Demo/PayslipProject/api/getpayslip.php";

    public static final int RESPONSE_OK = 1;
    public static final int RESPONSE_FAILURE = 0;
    public static final String CODE = "code";
    public static final String MESSAGE = "message";
    public static final String OBJECT = "object";
    public static final String PREFF_NAME = "employee_preff";



    /**
     * employee
     */

    public static final String KEY_EMP_ID = "emp_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_DEPARTMENT = "dept";
    public static final String KEY_DESIGNATION = "desg";
    public static final String KEY_PAN_NUMBER = "pan";
    public static final String KEY_ACCOUNT_NUMBER = "account";
    public static final String KEY_BRANCH = "branch";
    public static final String KEY_DOJ = "doj";
    public static final String KEY_DOR = "dor";
    public static final String KEY_PASSWORD = "password";

    /**
     * payslip
     */
    public static final String KEY_PID = "pid";
    public static final String KEY_FROM = "from";
    public static final String KEY_TO = "to";
    public static final String KEY_HRA = "hra";
    public static final String KEY_BASIC_SALARY = "basic";
    public static final String KEY_MEDICAL_ALLOWANCE = "medical";
    public static final String KEY_CONVEYANCE_ALLOWANCES = "conveyance";
    public static final String KEY_SPECIAL_ALLOWANCES = "special";
    public static final String KEY_GROSS = "gross";
    public static final String KEY_PROF_TAX = "ptax";
    public static final String KEY_TDS = "tds";
    public static final String KEY_ADV_SALARY = "adv_sal";
    public static final String KEY_OTHER_DET = "other_det";
    public static final String KEY_LEAVES_DET = "leaves_det";
    public static final String KEY_NET_SALARY = "net";


    public interface URLPARAMS {

        public static final String PARAM_EMP_ID = "empid";
        public static final String PARAM_PASSWORD = "pwd";
        public static final String PARAM_OLD_PWD = "oldpwd";
        public static final String PARAM_NEW_PWD = "newpwd";


    }
}
