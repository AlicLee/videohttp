package com.example.videohttp.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.example.videohttp.module.TLive;
import com.example.videohttp.service.LiveService;
import com.example.videohttp.util.RequestUtil;
import com.example.videohttp.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping("/live")
public class LiveController {
    @Autowired
    LiveService liveService;
    @Autowired
    HttpServletRequest request;

    @RequestMapping("/getLiveByPages")
    public String getByPages(int pageIndex, int pageSize) {
//        JSONObject object = JSON.parseObject(RequestUtil.readData(request));
//        int pageIndex = object.getInteger("pageIndex");
//        int pageSize = object.getInteger("pageSize");
        if (pageSize == 0) {
            return ResponseUtil.returnErrorResponse("参数不正确");
        }
        int currentPage=pageIndex*pageSize;
        int nextPage=++pageIndex*pageSize;
        List<TLive> tLiveList = liveService.selectByPages(currentPage, nextPage);
        if (tLiveList != null) {
            return ResponseUtil.returnSuccessResponse(JSON.toJSONString(tLiveList));
        } else {
            return ResponseUtil.returnErrorResponse("查询失败");
        }
    }

    @RequestMapping("/addLive")
    @ResponseBody
    public String add() {
        TLive tLive = JSON.parseObject(RequestUtil.readData(request), TLive.class);
        if (tLive != null) {
            int changeIndex = liveService.insert(tLive);
            if (changeIndex > 0) {
                return ResponseUtil.returnSuccessResponse(JSON.toJSONString(tLive));
            } else {
                return ResponseUtil.returnErrorResponse("添加失败");
            }
        } else {
            return ResponseUtil.returnErrorResponse("信息不正确");
        }
    }

    @RequestMapping("/deleteLive")
    @ResponseBody
    public String delete() {
        JSONObject object = JSON.parseObject(RequestUtil.readData(request));
        int id = object.getInteger("id");
        int changeIndex = liveService.deleteByPrimaryKey(id);
        if (changeIndex > 0) {
            return ResponseUtil.returnSuccessResponse("删除成功");
        } else {
            return ResponseUtil.returnErrorResponse("删除失败");
        }
    }

    @RequestMapping("/updateLive")
    @ResponseBody
    public String update() {
        TLive tLive = JSON.parseObject(RequestUtil.readData(request), TLive.class);
        if (tLive == null) {
            return ResponseUtil.returnErrorResponse("更新失败,发送的信息不正确");
        }
        int changeIndex = liveService.updateByPrimaryKeySelective(tLive);
        if (changeIndex > 0) {
            return ResponseUtil.returnSuccessResponse(JSON.toJSONString(tLive));
        } else {
            return ResponseUtil.returnErrorResponse("更新失败");
        }
    }

    @RequestMapping("/updateOrInsert")
    @ResponseBody
    public String updateOrInsert() {
        TLive tLive = JSON.parseObject(RequestUtil.readData(request), TLive.class);
        if (tLive == null) {
            return ResponseUtil.returnErrorResponse("更新失败,发送的信息不正确");
        }
        int changeIndex = liveService.updateOrInsert(tLive);
        if (changeIndex > 0)
            return ResponseUtil.returnSuccessResponse("更新成功");
        else
            return ResponseUtil.returnErrorResponse("更新失败");
    }
}
