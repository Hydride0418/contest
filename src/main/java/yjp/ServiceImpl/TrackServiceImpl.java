package yjp.ServiceImpl;

import org.springframework.stereotype.Service;
import yjp.dao.TrackDao;
import yjp.pojo.Track;
import yjp.service.TrackService;

import java.util.List;

@Service
public class TrackServiceImpl implements TrackService {
    private final TrackDao trackDao;

    public TrackServiceImpl(TrackDao trackDao) {
        this.trackDao = trackDao;
    }

    @Override
    public boolean addTrack(Track track) {
        boolean success = trackDao.addTrack(track);
        return success;
    }

    @Override
    public List<Track> showTrackList() {
        List<Track> trackList = trackDao.listTrack();
        return trackList;
    }

    @Override
    public boolean modifyTrackInfo(Track track) {
        boolean success = trackDao.modifyTrack(track);
        return success;
    }

    @Override
    public boolean deleteTrack(Integer id) {
        boolean success = trackDao.deleteTrack(id);
        return success;
    }
}
