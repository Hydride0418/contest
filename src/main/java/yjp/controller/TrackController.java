package yjp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yjp.pojo.Track;
import yjp.response.TrackResponse.AddTrackResponse;
import yjp.response.TrackResponse.DeleteTrackResponse;
import yjp.response.TrackResponse.ModifyTrackResponse;
import yjp.service.TrackService;

import java.util.List;

@Controller
@RequestMapping("/track")
public class TrackController {
    private final TrackService trackService;

    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @GetMapping("/get")
    @ResponseBody
    public List<Track> getTrackList() {
        List<Track> trackList = trackService.showTrackList();
        return trackList;
    }

    @PostMapping("/add")
    @ResponseBody
    public AddTrackResponse addTrack(@RequestBody Track track) {
        boolean success = trackService.addTrack(track);
        AddTrackResponse addTrackResponse = new AddTrackResponse();
        addTrackResponse.generate(success);
        return addTrackResponse;
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public DeleteTrackResponse deleteTrack(@PathVariable("id") Integer id){
        boolean success = trackService.deleteTrack(id);
        DeleteTrackResponse deleteTrackResponse = new DeleteTrackResponse();
        deleteTrackResponse.generate(success);
        return deleteTrackResponse;
    }

    @PostMapping("/modify")
    @ResponseBody
    public ModifyTrackResponse modifyTrack(@RequestBody Track track) {
        boolean success = trackService.modifyTrackInfo(track);
        ModifyTrackResponse modifyTrackResponse = new ModifyTrackResponse();
        modifyTrackResponse.generate(success);
        return modifyTrackResponse;
    }
}
