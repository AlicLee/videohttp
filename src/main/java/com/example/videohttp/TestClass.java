package com.example.videohttp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.videohttp.module.TLive;
import com.example.videohttp.module.TUser;
import com.example.videohttp.util.FFmpegUtil;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.UUID;

public class TestClass {
    static String[] nameAndValues = new String[]{"set-Cookie", "1", "set-Cookie", "2", "set-Cookie", "3", "set-Cookie", "4"};

    public static void main(String args[]) {
//        File file=new File("/Users/Project/project/apache-tomcat-9.0.14/webapps/File/Video");
//        for(File itemFile:file.listFiles()){
//            System.out.println("path:"+itemFile.getPath()+"getAbsolutePath:"+itemFile.getAbsolutePath());
//        }

        FFmpegUtil.makeScreenCut("/usr/local/bin/ffmpeg",
                "/Users/Project/tools/1.mp4",
                "/Users/Project/project/apache-tomcat-9.0.14/webapps/videoHttp/../File/"+UUID.randomUUID().toString()+".png");
    }


}
