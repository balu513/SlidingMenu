package com.afbb.balakrishna.playslipproj;

import android.content.Context;

import com.afbb.balakrishna.playslipproj.interfaces.iRequest;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Map;

public class RequestHandle {

    private final Context context;

    public RequestHandle(Context context) {
        this.context = context;
    }

    public void requestURL(final iRequest request, String url) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                request.onResponse(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                request.onErrorResponse(error.getMessage());
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return request.getParams();
            }
        };
        Volley.newRequestQueue(context).add(stringRequest);

    }
}
