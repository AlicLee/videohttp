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
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@RestController
@CrossOrigin
@RequestMapping("/srs/v1")
public class SrsController {
    @Autowired
    HttpServletRequest request;
    @Autowired
    HttpServletResponse response;
    private final String SUCCESS_CODE = "0", ERROR_CODE = "-1";
    private String jsonString;
    @Autowired
    private LiveService liveService;
    @Autowired
    private SrsService srsService;

    @RequestMapping("/connect")
    public String onSrsConnect() {
        String jsonString = RequestUtil.readData(request);
        JSONObject object = JSON.parseObject(jsonString);
        insertSrsModel(object);
        return SUCCESS_CODE;
    }

    @RequestMapping("/publish")
    public String onSrsPublish() {
        Logger.getLogger(SrsController.class).debug("onSrsPublish" + jsonString);
        String jsonString = RequestUtil.readData(request);
        JSONObject object = JSON.parseObject(jsonString);
        insertSrsModel(object);
        return SUCCESS_CODE;
    }

    @RequestMapping("/unPublish")
    public String onSrsUnPublish() {
        String jsonString = RequestUtil.readData(request);
        Logger.getLogger(SrsController.class).debug("onSrsUnPublish" + jsonString);
        JSONObject object = JSON.parseObject(jsonString);
        insertSrsModel(object);
        return SUCCESS_CODE;
    }

    @RequestMapping("/play")
    public String onSrsPlay() {
        String jsonString = RequestUtil.readData(request);
        Logger.getLogger(SrsController.class).debug("onSrsPlay" + jsonString);
        JSONObject object = JSON.parseObject(jsonString);
        insertSrsModel(object);
        return SUCCESS_CODE;
    }

    @RequestMapping("/close")
    public String onSrsClose() {
        String jsonString = RequestUtil.readData(request);
        Logger.getLogger(SrsController.class).debug("onSrsClose" + jsonString);
        JSONObject object = JSON.parseObject(jsonString);
        insertSrsModel(object);
        return SUCCESS_CODE;
    }

    @RequestMapping("/dvrs")
    public String onSrsDvr() {
        String jsonString = RequestUtil.readData(request);
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
        srs.setCreatetime(new Date());
        object.remove("action");
        object.remove("clientId");
        object.remove("ip");
        object.remove("vhost");
        object.remove("app");
        srs.setCustom(object.toJSONString());
        srs.setCreatetime(new Date());
        return srsService.insertSelective(srs);
    }

}
