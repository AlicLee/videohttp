package com.example.videohttp.controller;

import ch.qos.logback.core.util.FileUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.videohttp.module.TUser;
import com.example.videohttp.service.UserService;
import com.example.videohttp.util.RequestUtil;
import com.example.videohttp.util.ResponseUtil;
import org.apache.log4j.Logger;
import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    HttpServletRequest request;
    @Autowired
    HttpServletResponse response;

    private Logger logger = Logger.getLogger(UserController.class);
    private String requestData;

    @RequestMapping("/login")
    @ResponseBody
    public String login() {
        logger.debug("login invoke");
        requestData = RequestUtil.readData(request);
        String controllHeader = response.getHeader("Access-Control-Allow-Headers");
        logger.debug("controllerHeader:" + controllHeader);
        JSONObject object = JSON.parseObject(requestData);
        String userName = object.getString("userName");
        String userPassword = object.getString("userPassword");
        TUser tUser = userService.selectByUserNameAndPassword(userName, userPassword);
        if (tUser == null) {
            return ResponseUtil.returnErrorResponse("用户名或密码不正确");
        }
        return ResponseUtil.returnSuccessResponse(JSON.toJSONString(tUser));
    }

    @RequestMapping("/register")
    @ResponseBody
    public String register() {
        logger.debug("register invoke");
        requestData = RequestUtil.readData(request);
        TUser user = JSON.parseObject(requestData, TUser.class);
        if (user == null || user.getUsername() == null) {
            return ResponseUtil.returnErrorResponse("注册的用户信息不正确");
        }
        if (userService.selectByUserName(user.getUsername()) != null) {
            return ResponseUtil.returnErrorResponse("该用户已经存在");
        }
        user.setUsercreatetime(new Date());
        int lines = userService.insertSelective(user);
        if (lines == 0) {
            return ResponseUtil.returnErrorResponse("更新失败,用户不存在");
        } else {
            return ResponseUtil.returnSuccessResponse("注册成功", JSON.toJSONString(user));
        }
    }

    @RequestMapping("/updateUserInfo")
    @ResponseBody
    public String updateUserInfo() {
        TUser tUser = JSON.parseObject(RequestUtil.readData(request), TUser.class);
        if (tUser == null) {
            return ResponseUtil.returnErrorResponse("用户信息不正确,更新失败");
        }
        int lines = userService.updateByPrimaryKeySelective(tUser);
        if (lines == 0) {
            return ResponseUtil.returnErrorResponse("更新失败,用户不存在");
        } else {
            return ResponseUtil.returnSuccessResponse("更新成功", JSON.toJSONString(tUser));
        }
    }

}
