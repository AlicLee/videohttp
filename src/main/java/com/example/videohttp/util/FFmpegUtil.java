package com.example.videohttp.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class FFmpegUtil {

    public static void makeScreenCut(String ffmpegPath, String videoRealPath, String imageRealName) {
        List<String> command = new ArrayList<>();
        command.add(ffmpegPath);
        command.add("-ss");
        command.add("1");
        command.add("-i");
        command.add(videoRealPath);
        command.add("-y");
        command.add("-f");
        command.add("image2");
        command.add("-vframes");
        command.add("1");
        command.add(imageRealName);
        try {
            ProcessBuilder builder = new ProcessBuilder();
            builder.command(command);
            builder.redirectErrorStream(true);
            System.out.println("视频截图开始...");
            Process process = builder.start();
            InputStream in = process.getInputStream();
            byte[] bytes = new byte[1024];
            System.out.print("正在进行截图，请稍候");
            while (in.read(bytes) != -1) {
                System.out.println(".");
            }
            System.out.println("视频截取完成...");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("视频截图失败！");
        }
    }

}
