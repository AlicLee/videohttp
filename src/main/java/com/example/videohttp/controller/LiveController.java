package com.example.videohttp.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.videohttp.module.TLive;
import com.example.videohttp.service.LiveService;
import com.example.videohttp.util.RequestUtil;
import com.example.videohttp.util.ResponseUtil;
import com.jfinal.core.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/live")
public class LiveController extends Controller {
    @Autowired
    LiveService liveService;
    @Autowired
    HttpServletRequest request;
    @RequestMapping("/getLiveByPages")
    public void getByPages(int pageIndex, int pageSize) {
        List<TLive> tLiveList = liveService.selectByPages(pageIndex, pageSize);
        if (tLiveList != null) {
            ResponseUtil.returnSuccessResponse(JSON.toJSONString(tLiveList));
        } else {
            ResponseUtil.returnErrorResponse("查询失败");
        }
    }

    @RequestMapping("/addLive")
    public void add() {
        TLive tLive = JSON.parseObject(RequestUtil.readData(request), TLive.class);
        if (tLive != null) {
            int changeIndex = liveService.insert(tLive);
            if (changeIndex > 0) {
                ResponseUtil.returnSuccessResponse(JSON.toJSONString(tLive));
            } else {
                ResponseUtil.returnErrorResponse("添加失败");
            }
        } else {
            ResponseUtil.returnErrorResponse("信息不正确");
        }
    }

    @RequestMapping("/deleteLive")
    public void delete() {
        JSONObject object = JSON.parseObject(RequestUtil.readData(request));
        int id = object.getInteger("id");
        int changeIndex = liveService.deleteByPrimaryKey(id);
        if (changeIndex > 0) {
            ResponseUtil.returnSuccessResponse("删除成功");
        } else {
            ResponseUtil.returnErrorResponse("删除失败");
        }
    }

    @RequestMapping("/updateLive")
    public void update() {
        TLive tLive = JSON.parseObject(RequestUtil.readData(request), TLive.class);
        if (tLive == null) {
            ResponseUtil.returnErrorResponse("更新失败,发送的信息不正确");
            return;
        }
        int changeIndex = liveService.updateByPrimaryKeySelective(tLive);
        if (changeIndex > 0) {
            ResponseUtil.returnSuccessResponse(JSON.toJSONString(tLive));
        } else {
            ResponseUtil.returnErrorResponse("更新失败");
        }
    }

    @RequestMapping("/updateOrInsert")
    public void updateOrInsert() {
        TLive tLive = JSON.parseObject(RequestUtil.readData(request), TLive.class);
        if (tLive == null) {
            ResponseUtil.returnErrorResponse("更新失败,发送的信息不正确");
            return;
        }
        int changeIndex = liveService.updateOrInsert(tLive);
        if (changeIndex > 0)
            ResponseUtil.returnSuccessResponse(JSON.toJSON(tLive));
        else
            ResponseUtil.returnErrorResponse("更新失败");
    }
}
