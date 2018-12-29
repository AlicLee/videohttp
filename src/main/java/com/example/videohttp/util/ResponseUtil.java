package com.example.videohttp.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

public class ResponseUtil {
    private static final int SUCCESS_CODE = 200, ERROR_CODE = 500;
    private static final JSONObject dataOb=new JSONObject();
    public static String returnSuccessResponse(String msg, Object data) {
        return returnResponse(SUCCESS_CODE, msg, data);
    }

    public static String returnSuccessResponse(Object data) {
        return returnResponse(SUCCESS_CODE, "success", data);
    }

    public static String returnErrorResponse(String msg) {
        return returnResponse(ERROR_CODE, msg, null);
    }

    public static String returnErrorResponse(String msg, Object data) {
        return returnResponse(ERROR_CODE, msg, data);
    }

    public static String returnResponse(int code, String msg, Object data) {
        dataOb.put("code", code);
        dataOb.put("message", msg);
        if(data!=null)
            dataOb.put("data", data.toString());
        return dataOb.toString();
    }
//    public static String fixCrossDoMain(HttpServletResponse response){
//        response.setHeader("Access-Control-Allow-Origin","*");
//        response.setHeader("Access-Control-Allow-Methods","GET, POST, HEAD, PUT, DELETE");
//        String controllHeader=response.getHeader("Access-Control-Allow-Headers");
//    }
}
