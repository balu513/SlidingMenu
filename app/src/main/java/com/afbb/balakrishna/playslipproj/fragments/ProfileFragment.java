package com.afbb.balakrishna.playslipproj.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.afbb.balakrishna.playslipproj.MainActivity;
import com.afbb.balakrishna.playslipproj.R;
import com.afbb.balakrishna.playslipproj.core.Employee;
import com.afbb.balakrishna.playslipproj.utils.Utils;

public class ProfileFragment extends Fragment {

    private TextView tv_profile_name;
    private TextView tv_profile_dept;
    private TextView tv_profile_designation;
    private View btnChangePwd;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, null);
        tv_profile_name = (TextView) view.findViewById(R.id.tv_profile_name);
        tv_profile_dept = (TextView) view.findViewById(R.id.tv_profile_dept);
        tv_profile_designation = (TextView) view.findViewById(R.id.tv_profile_designation);
        btnChangePwd = view.findViewById(R.id.btn_pwdchange_profile);
        Employee employee = Utils.getInstance(getActivity()).getEmployeePreference();
        tv_profile_name.setText(employee.getName());
        tv_profile_dept.setText(employee.getDept());
        tv_profile_designation.setText(employee.getDesignation());
        btnChangePwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).replaceFragment(new ChangePwdFragment());
            }
        });
        return view;
    }
}
