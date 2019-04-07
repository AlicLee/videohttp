package com.example.videohttp.service.impl;

import com.example.videohttp.dao.VideoDao;
import com.example.videohttp.module.TVideo;
import com.example.videohttp.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    VideoDao videoDao;

    @Override
    public List<TVideo> getVideoByPages(int currentPage, int nextPage) {
        return videoDao.getVideoByPages(currentPage, nextPage);
    }

    @Override
    public int batchInsertVideo(List<TVideo> videoList) {
        return videoDao.batchInsertVideo(videoList);
    }

    @Override
    public int insertSelective(TVideo video) {
        return videoDao.insertSelective(video);
    }

}
