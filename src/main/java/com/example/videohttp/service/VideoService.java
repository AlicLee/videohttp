package com.example.videohttp.service;

import com.example.videohttp.module.TLive;
import com.example.videohttp.module.TVideo;

import java.util.List;

public interface VideoService {

    List<TVideo> getVideoByPages(int currentPage, int nextPage);

    int batchInsertVideo(List<TVideo> videoList);

    int insertSelective(TVideo video);
//    public List<TVideo>
}
