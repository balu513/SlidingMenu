package com.afbb.balakrishna.playslipproj;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.afbb.balakrishna.playslipproj.core.Employee;
import com.afbb.balakrishna.playslipproj.core.Response;
import com.afbb.balakrishna.playslipproj.interfaces.Constants;
import com.afbb.balakrishna.playslipproj.interfaces.iRequest;
import com.afbb.balakrishna.playslipproj.utils.Utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;


public class LoginActivty extends ActionBarActivity implements iRequest {

    private EditText etEmpId;
    private EditText etPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
//        if (getIntent().getBooleanExtra("EXIT", false)) {
//            finish();
//        }
        init();
    }

    public void login(View view) {
        new RequestHandle(getApplicationContext()).requestURL(this, Constants.URL_LOGIN);
    }


    private void init() {
        etEmpId = (EditText) findViewById(R.id.et_empid_login);
        etPwd = (EditText) findViewById(R.id.et_pwd);
    }

    @Override
    public void onResponse(String response) {
        try {
            Response responseObj = parseResponse(response);
            if (responseObj.getCode() == Constants.RESPONSE_OK) {
                Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivty.this, MainActivity.class));
                Employee employee = (Employee) responseObj.getObject();
                Utils.getInstance(getApplicationContext()).saveUserInPreference(employee);
                finish();
            }
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "invalid username Or Password", Toast.LENGTH_SHORT).show();
        }

    }


    private Response parseResponse(String response) {
        try {
            JSONObject object = new JSONObject(response);
            String code = object.getString("code");
            String message = object.getString("message");
            if (Integer.parseInt(code) == Constants.RESPONSE_OK) {
                JSONObject obj = object.getJSONObject("object");

                String empId = obj.getString(Constants.KEY_EMP_ID);
                String name = obj.getString(Constants.KEY_NAME);
                String dept = obj.getString(Constants.KEY_DEPARTMENT);
                String designation = obj.getString(Constants.KEY_DESIGNATION);
                String pan = obj.getString(Constants.KEY_PAN_NUMBER);
                String account = obj.getString(Constants.KEY_ACCOUNT_NUMBER);
                String branch = obj.getString(Constants.KEY_BRANCH);
                String DOJ = obj.getString(Constants.KEY_DOJ);
                String DOR = obj.getString(Constants.KEY_DOR);

                Employee employee = new Employee(empId, name, dept, designation, pan, account, branch, DOJ, DOR);
                Response resp = new Response();
                resp.setCode(Integer.parseInt(code));
                resp.setMessage(message);
                resp.setObject(employee);
                return resp;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public HashMap<String, String> getParams() {
        HashMap<String, String> map = new HashMap();
        map.put(Constants.URLPARAMS.PARAM_EMP_ID, etEmpId.getText().toString());
        map.put(Constants.URLPARAMS.PARAM_PASSWORD, etPwd.getText().toString());
        return map;
    }

    @Override
    public void onErrorResponse(String errorResponse) {
        Toast.makeText(getApplicationContext(), "ERROR " + errorResponse, Toast.LENGTH_SHORT).show();

    }
}
