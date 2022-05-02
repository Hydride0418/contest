package yjp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlockUser {
    private Integer Id; //用户id
    private Integer Score; //初始积分
    private String name;//区块链外存储的冗余字段 为方便调试

    public BlockUser(Integer id, String name) {
        Id = id;
        Score = 0;
    }
}
