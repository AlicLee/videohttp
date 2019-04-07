package com.example.videohttp.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.videohttp.module.TLive;
import com.example.videohttp.module.TSrs;
import com.example.videohttp.service.LiveService;
import com.example.videohttp.service.SrsService;
import com.example.videohttp.util.RequestUtil;
import com.example.videohttp.util.ResponseUtil;
import com.example.videohttp.util.TimeUtil;
import org.apache.log4j.Logger;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.HashMap;

@RestController
@CrossOrigin
@RequestMapping("/srs/v1")
public class SrsController {
    @Autowired
    HttpServletRequest request;
    private final String SUCCESS_CODE = "0", ERROR_CODE = "-1";
    @Autowired
    private LiveService liveService;
    @Autowired
    private SrsService srsService;

    @RequestMapping("/connect")
    public String onSrsConnect() {
        String jsonString = RequestUtil.readData(request);
        System.out.println("onSrsConnect:" + jsonString);
        JSONObject object = JSON.parseObject(jsonString);
        insertSrsModel(object);
        return SUCCESS_CODE;
    }

    @RequestMapping("/publish")
    public String onSrsPublish() {
        String jsonString = RequestUtil.readData(request);
        System.out.println("onSrsPublish:" + jsonString);
        JSONObject object = JSON.parseObject(jsonString);
        try {
            String stream = object.getString("stream");
            //用这种方式来判断是否是原始流,之所以这样做,是防止多次更新数据库。
            if (!stream.contains("_")) {
                TLive tLive = new TLive();
//                String[] streamList = stream.split("/");
//                int userId = Integer.valueOf(streamList[0]);
//                tLive.setId(userId);
                //获取参数
                String param = object.getString("param");
                String tcUrl = object.getString("tcUrl");
                String vhost = object.getString("vhost");
                //去掉param中多余的?符号
                if (param.charAt(0) == '?') {
                    param = param.substring(1, param.length());
                    System.out.println("param remove ?:" + param);
                }
                int resultId = handlePublishParam(param);
                if (resultId == -1) {
                    return ERROR_CODE;
                } else {
                    tLive.setUserId(resultId);
                }
                //拼接各种清晰度的地址。
                tLive.setLiveAddress(tcUrl + File.separator + stream);
                String pathBuilder = tcUrl + "?vhost=" + vhost + File.separator + stream;
                tLive.setLiveHdAddress(pathBuilder + "_hd");
                tLive.setLiveLdAddress(pathBuilder + "_ld");
                tLive.setLiveSdAddress(pathBuilder + "_sd");
                tLive.setLiveStatus(1);
                int updateIndex = liveService.updateByUserIdSelective(tLive);
                if (updateIndex == 0) {
                    return ERROR_CODE;
                }
            }
        } catch (Exception e) {
            System.out.println("errorUnPublish:" + e.toString());
            return ERROR_CODE;
        }
        insertSrsModel(object);
        return SUCCESS_CODE;
    }

    @RequestMapping("/unPublish")
    public String onSrsUnPublish() {
        String jsonString = RequestUtil.readData(request);
        System.out.println("onSrsPublish:" + jsonString);
        Logger.getLogger(SrsController.class).debug("onSrsUnPublish" + jsonString);
        JSONObject object = JSON.parseObject(jsonString);
        try {
            String param = object.getString("param");
            String stream = object.getString("stream");
            if (!stream.contains("_")) {
                TLive tLive = new TLive();
                param = param.replace("?", "");
                int resultId = handlePublishParam(param);
                if (resultId == -1) {
                    return ERROR_CODE;
                } else {
                    tLive.setUserId(resultId);
                }
                tLive.setLiveStatus(0);
                int updateIndex = liveService.updateByUserIdSelective(tLive);
                if (updateIndex == 0) {
                    return ERROR_CODE;
                }
            }
        } catch (Exception e) {
            System.out.println("errorUnPublish:" + e.toString());
            return ERROR_CODE;
        }
        insertSrsModel(object);
        return SUCCESS_CODE;
    }

    @RequestMapping("/play")
    public String onSrsPlay() {
        String jsonString = RequestUtil.readData(request);
        System.out.println("onSrsPlay:" + jsonString);
        Logger.getLogger(SrsController.class).debug("onSrsPlay" + jsonString);
        JSONObject object = JSON.parseObject(jsonString);
        insertSrsModel(object);
        return SUCCESS_CODE;
    }

    @RequestMapping("/close")
    public String onSrsClose() {
        String jsonString = RequestUtil.readData(request);
        System.out.println("onSrsClose:" + jsonString);
        Logger.getLogger(SrsController.class).debug("onSrsClose" + jsonString);
        JSONObject object = JSON.parseObject(jsonString);
        insertSrsModel(object);
        return SUCCESS_CODE;
    }

    @RequestMapping("/dvrs")
    public String onSrsDvr() {
        String jsonString = RequestUtil.readData(request);
        System.out.println("ondvrs:" + jsonString);
        Logger.getLogger(SrsController.class).debug("onDvrs" + jsonString);
        JSONObject object = JSON.parseObject(jsonString);
        insertSrsModel(object);
        return SUCCESS_CODE;
    }

    @RequestMapping("/hls")
    public String onSrsHls() {
        String jsonString = RequestUtil.readData(request);
        return SUCCESS_CODE;
    }

    private int insertSrsModel(JSONObject object) {
        TSrs srs = JSON.toJavaObject(object, TSrs.class);
        srs.setCreateTime(new Date());
        object.remove("action");
        object.remove("clientId");
        object.remove("ip");
        object.remove("vhost");
        object.remove("app");
        srs.setCustom(object.toJSONString());
        srs.setCreateTime(new Date());
        return srsService.insertSelective(srs);
    }

    private int handlePublishParam(String param) {
        if (param.contains("&")) {
            //todo split param
            return -1;
        } else {
            //不是多个参数,切割"="获得Key和value
            String[] keyAndValue = param.split("=");
            String key = keyAndValue[0];
            String value = keyAndValue[1];
            //如果没有获取到id的key就抛出异常
            if (key.equals("id")) {
                return Integer.valueOf(value);
            } else {
                return -1;
            }
        }
    }
}
