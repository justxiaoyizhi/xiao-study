package com.xyz.home.xiao20170218;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Set;

public class TestClusterRedis {

	private static final String REDIS_SERVER_URL = "101.200.57.197";

	public static void main(String[] args) {
	    
	    Set<HostAndPort> jedisClusterNode = new HashSet<HostAndPort>();
	    jedisClusterNode.add(new HostAndPort(REDIS_SERVER_URL, 7001));
	    jedisClusterNode.add(new HostAndPort(REDIS_SERVER_URL, 7002));
	    jedisClusterNode.add(new HostAndPort(REDIS_SERVER_URL, 7003));
	    jedisClusterNode.add(new HostAndPort(REDIS_SERVER_URL, 7004));
	    jedisClusterNode.add(new HostAndPort(REDIS_SERVER_URL, 7005));
	    jedisClusterNode.add(new HostAndPort(REDIS_SERVER_URL, 7006));
	    //GenericObjectPoolConfig goConfig = new GenericObjectPoolConfig();
	    //JedisCluster jc = new JedisCluster(jedisClusterNode,2000,100, goConfig);
		JedisPoolConfig cfg = new JedisPoolConfig();
		cfg.setMaxTotal(100);
		cfg.setMaxIdle(20);
	    cfg.setMaxWaitMillis(-1);
	    cfg.setTestOnBorrow(true); 
	    JedisCluster jc = new JedisCluster(jedisClusterNode,6000,1000,cfg);	    
	    
	    //System.out.println(jc.set("age","20"));
	    //System.out.println(jc.set("sex","男"));
	    System.out.println(jc.get("age"));
	    System.out.println(jc.get("sex"));
	    jc.close();
	}
}
