package com.afbb.balakrishna.playslipproj.interfaces;

import java.util.HashMap;

/**
 * Created by balakrishna on 22/7/15.
 */
public interface iRequest {

    public void onResponse(String response);
    public HashMap<String, String> getParams();
    public void onErrorResponse(String errorResponse);
}
