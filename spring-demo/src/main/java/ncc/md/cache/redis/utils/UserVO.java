package ncc.md.cache.redis.utils;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author huangbiaof
 * @data 创建时间：2019/9/17 10:56
 */
@ToString(callSuper = true)
public class UserVO {


    @Getter @Setter public String password;
    @Getter @Setter public String email;
    @Getter @Setter public String time;
}
