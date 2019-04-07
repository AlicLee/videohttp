package com.example.videohttp.controller;

import com.alibaba.fastjson.JSON;
import com.example.videohttp.module.TLive;
import com.example.videohttp.module.TVideo;
import com.example.videohttp.service.VideoService;
import com.example.videohttp.util.FFmpegUtil;
import com.example.videohttp.util.RequestUtil;
import com.example.videohttp.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/video")
public class VideoController {
    @Autowired
    VideoService videoService;
    @Autowired
    HttpServletRequest request;
//    @Autowired
//    HttpServletResponse response;

    @RequestMapping(value = "/getVideoByPages")
    @ResponseBody
    public String getVideoByPages(int pageIndex, int pageSize) {
//        JSONObject object = JSON.parseObject(RequestUtil.readData(request));
//        int pageIndex = object.getInteger("pageIndex");
//        int pageSize = object.getInteger("pageSize");
        if (pageSize == 0) {
            return ResponseUtil.returnErrorResponse("参数不正确");
        }
        int currentPage = pageIndex * pageSize;
        int nextPage = ++pageIndex * pageSize;
        List<TVideo> videoList = videoService.getVideoByPages(currentPage, nextPage);
//        List<TLive> tLiveList = liveService.selectByPages(pageIndex, pageSize);
        if (videoList != null) {
            return ResponseUtil.returnSuccessResponse(JSON.toJSONString(videoList));
        } else {
            return ResponseUtil.returnErrorResponse("查询失败");
        }
    }

    @RequestMapping(value = "/insertVideos")
    @ResponseBody
    public String insertVideos() {
        String filePath = request.getServletContext().getRealPath("/") + "../" + "File" + File.separator + "Video";
        File file = new File(filePath);
        File[] videoFile = file.listFiles();
        if (videoFile == null)
            return ResponseUtil.returnErrorResponse("插入失败~");
        List<TVideo> videoList = new ArrayList<>();
        for (File itemFile : videoFile) {
            TVideo tVideo = new TVideo();
            String fileName = itemFile.getName();
            //获取文件名的后缀名
            String coverPath = "File" + File.separator + UUID.randomUUID().toString() + ".png";
            final String FFMPEG_PATH = "/usr/local/bin/ffmpeg";
            String picPath = request.getServletContext().getRealPath("/") + "../" + coverPath;
            System.out.println("图片保存路径是:" + picPath + "filepath:" + itemFile.getPath());
            FFmpegUtil.makeScreenCut(FFMPEG_PATH, itemFile.getPath(), picPath);
            if (!new File(picPath).exists()) {
                continue;
            }
            if (!fileName.contains(".")) {
                tVideo.setName(fileName);
                fileName = UUID.randomUUID().toString();
                itemFile.renameTo(new File(itemFile.getParent() + File.separator + fileName));
            } else {
                String suffixName = fileName.substring(fileName.lastIndexOf("."));
                String name = fileName.substring(0, fileName.lastIndexOf("."));
                tVideo.setName(name);
                fileName = UUID.randomUUID() + suffixName;
                itemFile.renameTo(new File(itemFile.getParent() + File.separator + fileName));
            }
            tVideo.setCoverPath(coverPath);
            tVideo.setPath("File" + File.separator + "Video" + File.separator + fileName);
            tVideo.setUserid(1);
            videoList.add(tVideo);
        }
        int updateIndex = videoService.batchInsertVideo(videoList);
        if (updateIndex == videoList.size()) {
            return ResponseUtil.returnSuccessResponse("批量插入成功");
        } else {
            return ResponseUtil.returnErrorResponse("批量插入失败");
        }
    }

    @RequestMapping(value = "/insertVideo")
    @ResponseBody
    public String uploadVideo() {
        String data = RequestUtil.readData(request);
        TVideo video = JSON.parseObject(data, TVideo.class);
        if (video == null || video.getId() == null) {
            return ResponseUtil.returnErrorResponse("发送数据不正确");
        }
        String videoRealPath = request.getServletContext().getRealPath("/") + "../" + video.getPath();
        File videoFile = new File(videoRealPath);
        if (!videoFile.exists()) {
            return ResponseUtil.returnErrorResponse("视频不存在");
        }
        //判断是否在本地处理
        if (StringUtils.isEmpty(video.getCoverPath())) {
            String coverPath = "File" + File.separator + UUID.randomUUID().toString() + ".png";
            final String FFMPEG_PATH = "/usr/local/bin/ffmpeg";
            FFmpegUtil.makeScreenCut(FFMPEG_PATH, videoFile.getPath(), request.getServletContext().getRealPath("/") + "../" + coverPath);
            video.setCoverPath(coverPath);
        }
        int index = videoService.insertSelective(video);
        if (index > 0) {
            return ResponseUtil.returnSuccessResponse(JSON.toJSONString(video));
        } else {
            return ResponseUtil.returnErrorResponse("服务器错误");
        }
    }
}
