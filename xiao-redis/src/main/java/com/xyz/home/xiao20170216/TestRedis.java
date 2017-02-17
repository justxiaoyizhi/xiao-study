package com.xyz.home.xiao20170216;

import com.xyz.home.xiao20170216.util.FastJsonUtil;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * Created by Xiao on 2017/2/16.
 */
public class TestRedis {

    private static final String SYS_USER_TABLE = "SYS_USER_TABLE";
    private static final String SYS_USER_SEL_AGE_25 = "SYS_USER_SEL_AGE_25";
    private static final String SYS_USER_SEL_SEX_m = "SYS_USER_SEL_SEX_m";

    public static void main(String[] args) {
        Jedis jedis = new Jedis("101.200.57.197", 6379);
        jedis.auth("123456");

        Set<String> smembers = jedis.sinter(SYS_USER_SEL_AGE_25, SYS_USER_SEL_SEX_m);
        for (String smember : smembers) {
            User user = FastJsonUtil.toBean(jedis.hget(SYS_USER_TABLE, smember), User.class);
            System.out.println(user.getId());
            System.out.println(user.getName());
            System.out.println(user.getAge());
            System.out.println(user.getSex());
        }

    }

    /**
     * 存储用户数据
     * @param jedis
     */
    private static void setUserData(Jedis jedis) {
        Map<String, String> map = new HashMap();

        // 模拟存储500w条用户数据，现在需要查询出年龄是25的man
        User u1 = new User(UUID.randomUUID().toString(), "23", "m", "zhangsan");
        map.put(u1.getId(), FastJsonUtil.toJSONString(u1));
        jedis.sadd(SYS_USER_SEL_SEX_m, u1.getId());

        User u2 = new User(UUID.randomUUID().toString(), "25", "m", "lisi");
        map.put(u2.getId(), FastJsonUtil.toJSONString(u2));
        jedis.sadd(SYS_USER_SEL_AGE_25, u2.getId());
        jedis.sadd(SYS_USER_SEL_SEX_m, u2.getId());

        User u3 = new User(UUID.randomUUID().toString(), "29", "m", "wanger");
        map.put(u3.getId(), FastJsonUtil.toJSONString(u3));
        jedis.sadd(SYS_USER_SEL_SEX_m, u3.getId());

        User u4 = new User(UUID.randomUUID().toString(), "25", "w", "zhaoli");
        map.put(u4.getId(), FastJsonUtil.toJSONString(u4));
        jedis.sadd(SYS_USER_SEL_AGE_25, u4.getId());

        User u5 = new User(UUID.randomUUID().toString(), "22", "w", "sulan");
        map.put(u5.getId(), FastJsonUtil.toJSONString(u5));
        jedis.hmset(SYS_USER_TABLE, map);
    }
}
