package com.good.night.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Set;

/**
 * Redis客户端工具
 *
 * @author zhangxc email: zhangxicheng@lizi-inc.com
 * @Description:com.good.night.util.JRedisUtil
 * @date 2016年1月21日 下午4:08:26
 */
public class JRedisUtil {
    private static JRedisUtil instance = new JRedisUtil();
    private static JedisPool pool = null;

    static {
        try {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxActive(-1); // 可用连接实例的最大数目，为负值时没有限制
            config.setMaxIdle(100); // 空闲连接实例的最大数目，为负值时没有限制
            config.setMaxWait(10000); // 等待可用连接的超时时间,单位毫秒.当连接池中没有active/idle的连接时,会等待maxWait时间,如果等待超时还没有可用连接,则抛出Could not get a resource from the pool异常
            //pool = new JedisPool(config, Config.getInstance().get("redis.server"));
            String host = Config.getInstance().get("redis.server");
            String auth = Config.getInstance().get("redis.auth");
            int port = Integer.parseInt(Config.getInstance().get("redis.port"));
            pool = new JedisPool(config, host, port, 60, auth);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private JRedisUtil() {
    }

    public static JRedisUtil getInstance() {
        return instance;
    }

    public String set(String key, String value) {
        LoggerUtil.getLogger(JRedisUtil.class).info(String.format("redis set key  %s  value %s ", key, value));
        Jedis j = null;
        String re = "";
        try {
        	j = pool.getResource();
            re = j.set(key, value);
        } catch(Exception ex) {
        	ex.printStackTrace();
        } finally {
            if(j != null) {
            	pool.returnBrokenResource(j);
            }
        }
        return re;
    }

    public long expire(String key, int seconds) {
        Jedis j = null;
        long re = 0;
        try {
        	j = pool.getResource();
            re = j.expire(key, seconds);
        } catch(Exception ex) {
        	ex.printStackTrace();
        } finally {
            if(j != null) {
            	pool.returnBrokenResource(j);
            }
        }
        return re;
    }

    public long incr(String key) {
    	long re = 0;
        Jedis j = null;
        try {
        	j = pool.getResource();
            re = j.incr(key);
            LoggerUtil.getLogger(JRedisUtil.class).info(String.format("redis set key  %s  value %d ", key, re));
        } catch(Exception ex) {
        	ex.printStackTrace();
        } finally {
            if(j != null) {
            	pool.returnBrokenResource(j);
            }
        }
        return re;
    }

    public long sadd(String key, String value) {
        Jedis j = null;
        long re = 0;
        try {
        	j = pool.getResource();
            re = j.sadd(key, value);
            LoggerUtil.getLogger(JRedisUtil.class).info(String.format("redis set key  %s  value %d ", key, re));
        } catch(Exception ex) {
        	ex.printStackTrace();
        } finally {
            if(j != null) {
            	pool.returnBrokenResource(j);
            }
        }
        return re;
    }

    public long srem(String key, String value) {
    	long re = 0;
        Jedis j = null;
        try {
        	j = pool.getResource();
            re = j.srem(key, value);
            LoggerUtil.getLogger(JRedisUtil.class).info(String.format("redis srem key  %s  value %d ", key, re));
        } catch(Exception ex) {
        	ex.printStackTrace();
        } finally {
            if(j != null) {
            	pool.returnBrokenResource(j);
            }
        }
        return re;
    }

    public long scard(String key) {
    	long re = 0;
        Jedis j = null;
        try {
        	j = pool.getResource();
            re = j.scard(key);
            LoggerUtil.getLogger(JRedisUtil.class).info(String.format("redis srem key  %s  value %d ", key, re));
        } catch(Exception ex) {
        	ex.printStackTrace();
        } finally {
            if(j != null) {
            	pool.returnBrokenResource(j);
            }
        }
        return re;
    }

    public String get(String key) {
        String re = "";
        Jedis j = null;
        try {
            LoggerUtil.getLogger(JRedisUtil.class).info(String.format("redis get key  %s ", key));
            j = pool.getResource();
            re = j.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (j != null) {
                pool.returnBrokenResource(j);
            }
        }
        return re;
    }

    public long getLong(String key) {
        LoggerUtil.getLogger(JRedisUtil.class).info(String.format("redis getLong key  %s ", key));
        Jedis j = null;
        String value = "";
        long count = 0;
        try {
        	j = pool.getResource();
            value = j.get(key);
            count = Long.parseLong(value);
        } catch(Exception ex) {
        	ex.printStackTrace();
        } finally {
            if(j != null) {
            	pool.returnBrokenResource(j);
            }
        }
        return count;
    }

    public Set<String> keys(String prefix) {
        Jedis j = null;
        Set<String> value = null;
        try {
        	j = pool.getResource();
            value = j.keys(prefix);
        } catch(Exception ex) {
        	ex.printStackTrace();
        } finally {
            if(j != null) {
            	pool.returnBrokenResource(j);
            }
        }
        return value;
    }

    public static void main(String[] args) {
//        List<String> arr = new ArrayList<>();
//        arr.add("test1");
//        arr.add("test2");
//        arr.add("test3");
//        JRedisUtil.getInstance().lpush("zhaoxiufei_test", arr);
//        List<String> list = JRedisUtil.getInstance().lrangeAll("zhaoxiufei_test");
//        for (String s : list) {
//            System.out.println(s);
//        }
//        long zhaoxiufei_test = JRedisUtil.getInstance().lpopAll("zhaoxiufei_test");
//        System.out.println(zhaoxiufei_test);

//        JRedisUtil.getInstance().set("qrs2222e_3", "33");
//        JRedisUtil.getInstance().set("qrs2222e_5", "334");
//        System.out.println(JRedisUtil.getInstance().get("qrs2222e_3"));
    }

    public Set<String> smembers(String redisKey) {
        Jedis j = null;
        Set<String> value = null;
        try {
        	j = pool.getResource();
            value = j.smembers(redisKey);
        } catch(Exception ex) {
        	ex.printStackTrace();
        } finally {
            if(j != null) {
            	pool.returnBrokenResource(j);
            }
        }
        return value;
    }

    public boolean isExist(String redisKey) {
        Jedis j = null;
        boolean isExist = false;
        try {
        	j = pool.getResource();
            isExist = j.exists(redisKey);
        } catch(Exception ex) {
        	ex.printStackTrace();
        } finally {
            if(j != null) {
            	pool.returnBrokenResource(j);
            }
        }
        return isExist;
    }

    public String setex(String redisKey, int expireSecond, String value) {
    	String result = "";
        if (pool == null) {
            LoggerUtil.getLogger(JRedisUtil.class).error(String.format("get redis error!", ""));
            return result;
        }
        
        Jedis j = null;
        try {
        	j = pool.getResource();
            result = j.setex(redisKey, expireSecond, value);
        } catch(Exception ex) {
        	ex.printStackTrace();
        } finally {
            if(j != null) {
            	pool.returnBrokenResource(j);
            }
        }
        return result;
    }

    public Long del(String key) {
    	Long re = 0L;
    	if(pool == null) {
    		LoggerUtil.getLogger(JRedisUtil.class).error(String.format("redis pool null %s", key));
    		return re;
    	}
    	
        LoggerUtil.getLogger(JRedisUtil.class).info(String.format("redis get key  %s ", key));
        Jedis j = null;
        try {
        	j = pool.getResource();
            re = j.del(key);
        }catch(Exception ex) {
        	ex.printStackTrace();
        } finally {
            if(j != null) {
            	pool.returnBrokenResource(j);
            }
        }
        return re;
    }

    /**
     * shiro 缓存用户权限
     * @param key
     * @param values
     */
    public void lpush(String key, List<String> values) {
    	if(pool == null) {
    		LoggerUtil.getLogger(JRedisUtil.class).error(String.format("redis pool null %s", key));
    		return;
    	}
    	
        LoggerUtil.getLogger(JRedisUtil.class).info(String.format("redis lpush key  %s ", key));
        Jedis j = null;
        try {
        	j = pool.getResource();
            for (String value : values) {
                j.lpush(key, value);
            }
        }catch(Exception ex) {
        	ex.printStackTrace();
        } finally {
            if(j != null) {
            	pool.returnBrokenResource(j);
            }
        }
    }

    public Long llen(String key) {
    	Long value = null;
    	if(pool == null) {
    		LoggerUtil.getLogger(JRedisUtil.class).error(String.format("redis pool null %s", key));
    		return value;
    	}
        LoggerUtil.getLogger(JRedisUtil.class).info(String.format("redis llen key  %s ", key));
        Jedis j = null;
        try {
        	j = pool.getResource();
        	value = j.llen(key);
        }catch(Exception ex) {
        	ex.printStackTrace();
        } finally {
            if(j != null) {
            	pool.returnBrokenResource(j);
            }
        }
        return value;
    }

    public String lpop(String key) {
    	String value = null;
    	if(pool == null) {
    		LoggerUtil.getLogger(JRedisUtil.class).error(String.format("redis pool null %s", key));
    		return value;
    	}
    	
        LoggerUtil.getLogger(JRedisUtil.class).info(String.format("redis lpop key  %s ", key));
        Jedis j = null;
        try {
        	j = pool.getResource();
            value = j.lpop(key);
        } catch(Exception ex) {
        	ex.printStackTrace();
        } finally {
        	if(j != null) {
        		pool.returnBrokenResource(j);
        	}
        }
        return value;
    }

    public long lpopAll(String key) {
    	/*long value = 0;
    	if(pool == null) {
    		LoggerUtil.getLogger(JRedisUtil.class).error(String.format("redis pool null %s", key));
    		return value;
    	}
        LoggerUtil.getLogger(JRedisUtil.class).info(String.format("redis lpopAll key  %s ", key));
        Jedis j = null;
        try {
        	j = pool.getResource();
            Long len = llen(key);
            if (len != null) {
                for (int i = 0; i < len; i++) {
                    j.lpop(key);
                }
                value = len;
            }
        } catch(Exception ex) {
        	ex.printStackTrace();
        } finally {
            if(j != null) {
            	pool.returnBrokenResource(j);
            }
        }
        return value;*/
    	
    	Long re = 0L;
    	if(pool == null) {
    		LoggerUtil.getLogger(JRedisUtil.class).error(String.format("redis pool null %s", key));
    		return re;
    	}
    	
        LoggerUtil.getLogger(JRedisUtil.class).info(String.format("redis get key  %s ", key));
        Jedis j = null;
        try {
        	j = pool.getResource();
            re = j.del(key);
        }catch(Exception ex) {
        	ex.printStackTrace();
        } finally {
            if(j != null) {
            	pool.returnBrokenResource(j);
            }
        }
        return re;
    }

    public List<String> lrangeAll(String key) {
    	if(pool == null) {
    		LoggerUtil.getLogger(JRedisUtil.class).error(String.format("redis pool null %s", key));
    		return null;
    	}
        LoggerUtil.getLogger(JRedisUtil.class).info(String.format("redis lrangeAll key  %s ", key));
        List<String> list = null;
        Jedis j = null;
        try {
        	j = pool.getResource();
            list = j.lrange(key, 0, -1);
        }catch(Exception ex) {
        	ex.printStackTrace();
        }finally {
        	if(j != null) {
        		pool.returnBrokenResource(j);
        	}
        }
        return list;
    }
}
