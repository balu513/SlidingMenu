package com.afbb.balakrishna.playslipproj.fragments;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.afbb.balakrishna.playslipproj.DetailsPaySlipActivity;
import com.afbb.balakrishna.playslipproj.MainActivity;
import com.afbb.balakrishna.playslipproj.R;
import com.afbb.balakrishna.playslipproj.RequestHandle;
import com.afbb.balakrishna.playslipproj.adapters.PayslipsAdapter;
import com.afbb.balakrishna.playslipproj.core.PayslipBean;
import com.afbb.balakrishna.playslipproj.core.Response;
import com.afbb.balakrishna.playslipproj.interfaces.Constants;
import com.afbb.balakrishna.playslipproj.interfaces.iRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PaySlipsFragment extends Fragment implements iRequest {

    private Object employeeId;
    private ListView listView;
    private List<PayslipBean> payslipBeans;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_pay_slips, null);
        listView = (ListView) view.findViewById(R.id.listview_payslips_monhts);
        requestPayslipsUrl();
        return view;
    }

    private void requestPayslipsUrl() {
        new RequestHandle(getActivity()).requestURL(this, Constants.URL_GET_PAYSLIPS);
    }


    public String getEmployeeId() {
        SharedPreferences preferences = ((MainActivity) getActivity()).getSharedPreferences(Constants.PREFF_NAME, Context.MODE_PRIVATE);
        String empId = preferences.getString(Constants.KEY_EMP_ID, null);
        return empId;

    }

    @Override
    public void onResponse(String response) {
        Response responseObj = parseResponse(response);
        payslipBeans = (List<PayslipBean>) responseObj.getObject();
        setListView(payslipBeans);
    }

    private void setListView(final List<PayslipBean> payslipBeans) {
        PayslipsAdapter adapter = new PayslipsAdapter(getActivity(), payslipBeans);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), DetailsPaySlipActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable("payslip", payslipBeans.get(position));
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }


    @Override
    public HashMap<String, String> getParams() {
        String empId = getEmployeeId();
        HashMap<String, String> hashMap = new HashMap();
        hashMap.put(Constants.URLPARAMS.PARAM_EMP_ID, empId);
        return hashMap;
    }

    @Override
    public void onErrorResponse(String errorResponse) {
        Log.d("PaySlipsFragment", errorResponse);
    }

    private Response parseResponse(String response) {

        List<PayslipBean> list = new ArrayList();
        Response responseObj = new Response();
        try {
            JSONObject object = new JSONObject(response);
            String code = object.getString(Constants.CODE);
            String message = object.getString(Constants.MESSAGE);
            responseObj.setCode(Integer.parseInt(code));
            responseObj.setMessage(message);
            JSONArray arr = object.getJSONArray(Constants.OBJECT);
            if (Integer.parseInt(code) == Constants.RESPONSE_OK) {
                for (int i = 0; i < arr.length(); i++) {

                    JSONObject jsonObject = arr.getJSONObject(i);
                    String pid = jsonObject.getString(Constants.KEY_PID);
                    String from = jsonObject.getString(Constants.KEY_FROM);
                    String to = jsonObject.getString(Constants.KEY_TO);
                    String hra = jsonObject.getString(Constants.KEY_HRA);
                    String basic = jsonObject.getString(Constants.KEY_BASIC_SALARY);
                    String medical_al = jsonObject.getString(Constants.KEY_MEDICAL_ALLOWANCE);
                    String conveyance_al = jsonObject.getString(Constants.KEY_CONVEYANCE_ALLOWANCES);
                    String special_al = jsonObject.getString(Constants.KEY_SPECIAL_ALLOWANCES);
                    String gross = jsonObject.getString(Constants.KEY_GROSS);
                    String prof_tax = jsonObject.getString(Constants.KEY_PROF_TAX);
                    String tds = jsonObject.getString(Constants.KEY_TDS);
                    String adv_sal = jsonObject.getString(Constants.KEY_ADV_SALARY);
                    String other_det = jsonObject.getString(Constants.KEY_OTHER_DET);
                    String leaves_det = jsonObject.getString(Constants.KEY_LEAVES_DET);
                    String net = jsonObject.getString(Constants.KEY_NET_SALARY);

                    PayslipBean bean = new PayslipBean();
                    bean.setFromDate(from);
                    bean.setToDate(to);
                    bean.setHra(Float.parseFloat(hra));
                    bean.setBasicSal(Float.parseFloat(basic));
                    bean.setMedicalSal(Float.parseFloat(medical_al));
                    bean.setConvSal(Float.parseFloat(conveyance_al));
                    bean.setSpecialSal(Float.parseFloat(special_al));
                    bean.setGrossSal(Float.parseFloat(gross));
                    bean.setPfTax(Float.parseFloat(prof_tax));
                    bean.setTds(Float.parseFloat(tds));
                    bean.setAdvSalary(Float.parseFloat(adv_sal));
                    bean.setOtherDeductions(Float.parseFloat(other_det));
                    bean.setLeaves(Float.parseFloat(leaves_det));
                    bean.setNet(Float.parseFloat(net));
                    list.add(bean);
                }
                responseObj.setObject(list);
            } else {
                responseObj.setObject(null);
            }

        } catch (JSONException e) {
            e.printStackTrace();
            Log.d("PaySlipsFragment", e.getMessage());
        }

        return responseObj;
    }
}
