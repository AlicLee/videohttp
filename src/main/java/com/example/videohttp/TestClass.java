package com.example.videohttp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.videohttp.module.TLive;
import com.example.videohttp.module.TUser;

import javax.servlet.http.HttpServletResponse;

public class TestClass {
    static String[] nameAndValues = new String[]{"set-Cookie", "1", "set-Cookie", "2", "set-Cookie", "3", "set-Cookie", "4"};

    public static void main(String args[]) {
        System.out.println(get(nameAndValues, "set-Cookie"));
    }

    private static String get(String[] namesAndValues, String name) {
        for (int i = namesAndValues.length - 2; i >= 0; i -= 2) {
            if (name.equalsIgnoreCase(namesAndValues[i])) {
                return namesAndValues[i + 1];
            }
        }
        return null;
    }
}
