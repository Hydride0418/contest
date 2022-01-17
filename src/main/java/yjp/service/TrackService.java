package yjp.service;

import yjp.pojo.Track;

import java.util.List;

public interface TrackService {
    //新增赛道
    public boolean addTrack(Track track);
    //分页展示赛道列表
    public List<Track> showTrackList();
    //修改赛道信息
    public boolean modifyTrackInfo(Track track);
    //删除赛道
    public boolean deleteTrack(Integer id);
}
