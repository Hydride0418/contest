package yjp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlockWork {
    private Integer Id; //作品id
    private String Hash; //作品url
    private Integer Uploader; //上传者BlockUser的id
    private String Time; //上传时间
    private Integer Cost; //交换积分
    private Integer GetScore; //上传所获积分

    public BlockWork(Integer id,String hash, Integer uploader,String time) {
        Id = id;
        Hash = hash;
        Uploader = uploader;
        Time = time;
        Cost = 0;
        GetScore = 0;
    }
}
