package yjp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contest {
    private Integer id;
    private String name;
    private Integer time_limit;
    private Integer question_number;
    private Integer archive_status;
    private Integer contest_id;
    private String image;
    private String content;
    private Date start_time;
    private Date end_time;
    private Date apply_start;
    private Date apply_end;


    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
