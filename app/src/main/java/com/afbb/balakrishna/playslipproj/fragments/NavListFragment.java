package com.afbb.balakrishna.playslipproj.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.afbb.balakrishna.playslipproj.LoginActivty;
import com.afbb.balakrishna.playslipproj.MainActivity;
import com.afbb.balakrishna.playslipproj.R;

public class NavListFragment extends Fragment implements View.OnClickListener {

    private RelativeLayout lProfile;
    private RelativeLayout lpayslips;
    private RelativeLayout llogout;
    private RelativeLayout lchangepwd;
    private ImageView iv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.nav_list, null);
        lProfile = (RelativeLayout) view.findViewById(R.id.rlout_profile);
        lpayslips = (RelativeLayout) view.findViewById(R.id.rlout_payslips);
        llogout = (RelativeLayout) view.findViewById(R.id.rlout_logout);
        lchangepwd = (RelativeLayout) view.findViewById(R.id.rlout_changepwd);
        iv = (ImageView) view.findViewById(R.id.iv_profile);
        lProfile.setOnClickListener(this);
        lpayslips.setOnClickListener(this);
        llogout.setOnClickListener(this);
        lchangepwd.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        ((MainActivity) getActivity()).closeSlider();
        Fragment fragment = null;
        switch (v.getId()) {
            case R.id.rlout_profile:
                fragment = new ProfileFragment();
                break;
            case R.id.rlout_payslips:
                fragment = new PaySlipsFragment();
                break;
            case R.id.rlout_changepwd:
                fragment = new ChangePwdFragment();
                break;
            case R.id.rlout_logout:
                Toast.makeText(getActivity(), "logout successful", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), LoginActivty.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("EXIT", true);
                startActivity(intent);
                return;
        }
        ((MainActivity) getActivity()).replaceFragment(fragment);

    }

}