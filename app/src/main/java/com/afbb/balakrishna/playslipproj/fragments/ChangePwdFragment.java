package com.afbb.balakrishna.playslipproj.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.afbb.balakrishna.playslipproj.R;
import com.afbb.balakrishna.playslipproj.RequestHandle;
import com.afbb.balakrishna.playslipproj.interfaces.Constants;
import com.afbb.balakrishna.playslipproj.interfaces.iRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class ChangePwdFragment extends Fragment implements iRequest {
    private EditText etOldPwd;
    private EditText etNewPwd;
    private EditText etEmpId;
    private Button btnSubmit;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_change_pwd, null);
        etOldPwd = (EditText) view.findViewById(R.id.et_oldpassword);
        etNewPwd = (EditText) view.findViewById(R.id.et_newpwd);
        etEmpId = (EditText) view.findViewById(R.id.et_empid_changepwd);
        btnSubmit = (Button) view.findViewById(R.id.btn_pwdchange_submit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new RequestHandle(getActivity()).requestURL(ChangePwdFragment.this, Constants.URL_CHANGE_PWD);
            }
        });
        return view;
    }

    @Override
    public void onResponse(String response) {
        Log.d("ChangePwdFragment", "onResponse " + response);
        try {
            JSONObject obj = new JSONObject(response);
            String code = obj.getString(Constants.CODE);
            String message = obj.getString(Constants.MESSAGE);
            Toast.makeText(getActivity(), obj.getString(Constants.MESSAGE), Toast.LENGTH_SHORT).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public HashMap<String, String> getParams() {
        String oldpwd = etOldPwd.getText().toString();
        String newpwd = etNewPwd.getText().toString();
        String empId = etEmpId.getText().toString();
        HashMap<String, String> map = new HashMap();
        map.put(Constants.URLPARAMS.PARAM_OLD_PWD, oldpwd);
        map.put(Constants.URLPARAMS.PARAM_NEW_PWD, newpwd);
        map.put(Constants.URLPARAMS.PARAM_EMP_ID, empId);
        return map;
    }

    @Override
    public void onErrorResponse(String errorResponse) {
        Log.d("ChangePwdFragment", "onErrorResponse " + errorResponse);

    }
}
