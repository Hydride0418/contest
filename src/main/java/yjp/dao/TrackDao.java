package yjp.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import yjp.pojo.Track;

import java.util.List;

@Mapper
@Repository
public interface TrackDao {
    //返回所有赛道
    public List<Track> listTrack();
    //增加一个赛道
    public boolean addTrack(Track track);
    //根据id删除一个赛道
    public boolean deleteTrack(Integer id);
    //修改赛道信息
    public boolean modifyTrack(Track Track);
}
