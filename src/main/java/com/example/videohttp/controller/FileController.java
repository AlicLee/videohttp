package com.example.videohttp.controller;

import com.example.videohttp.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;


@RestController
public class FileController {
    @Autowired
    HttpServletRequest request;
    private final Logger logger = LoggerFactory.getLogger(FileController.class);
    private final String UPLOAD_PATH="upload";
    //单个文件上传相关代码
    @RequestMapping(value = "/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseUtil.returnErrorResponse("上传失败,上传的文件为空");
        }
        //获取文件名
        String fileName = file.getOriginalFilename();
        if (fileName == null) {
            return ResponseUtil.returnErrorResponse("上传文件失败");
        }
        logger.info("上传的文件名为:" + fileName);
        //获取文件名的后缀名
        if (!fileName.contains(".")) {
            fileName = UUID.randomUUID().toString();
        } else {
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            logger.info("上传的后缀名为:" + suffixName);
            fileName = UUID.randomUUID() + suffixName;
        }
        ServletContext context = request.getServletContext();
        //文件上传后的路径
        File dest = new File(context.getRealPath("/") + File.separator + fileName);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            return ResponseUtil.returnSuccessResponse("上传文件成功", fileName);
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
        }
        return ResponseUtil.returnErrorResponse("上传文件失败");
    }

    @RequestMapping(value = "/uploadFiles", method = RequestMethod.POST)
    @ResponseBody
    public String uploadFiles() {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request)
                .getFiles("file");
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    stream = new BufferedOutputStream(new FileOutputStream(
                            new File(file.getOriginalFilename())));
                    stream.write(bytes);
                    stream.close();
                } catch (Exception e) {
                    stream = null;
                    return "You failed to upload " + i + " => "
                            + e.getMessage();
                }
            } else {
                return "You failed to upload " + i
                        + " because the file was empty.";
            }
        }
        return "upload successful";
    }
}
