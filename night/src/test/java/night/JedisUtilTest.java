package night;

import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import com.good.night.util.LoggerUtil;

public class JedisUtilTest {

	private static Logger LOGGER = LoggerUtil.getLogger(JedisUtilTest.class);

	private static JedisUtilTest instance = new JedisUtilTest();

	private static JedisPool pool = null;

	static {
		try {
			JedisPoolConfig config = new JedisPoolConfig();
			config.setMaxActive(-1); // 可用连接实例的最大数目，为负值时没有限制
			config.setMaxIdle(100); // 空闲连接实例的最大数目，为负值时没有限制
			config.setMaxWait(10000); // 等待可用连接的超时时间,单位毫秒.当连接池中没有active/idle的连接时,会等待maxWait时间,如果等待超时还没有可用连接,则抛出Could
										// not get a resource from the pool异常

			String host = "127.0.0.1";
			// String auth = "";
			int port = 6379;
			pool = new JedisPool(config, host, port, 60);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String set(String key, String value) {
		LOGGER.info(String.format("redis set key  %s  value %s ", key, value));
		Jedis j = null;
		String re = "";
		try {
			j = pool.getResource();
			re = j.set(key, value);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (j != null) {
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
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (j != null) {
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
            LOGGER.info(String.format("redis set key  %s  value %d ", key, re));
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
            LOGGER.info(String.format("redis set key  %s  value %d ", key, re));
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
           LOGGER.info(String.format("redis srem key  %s  value %d ", key, re));
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
            LOGGER.info(String.format("redis srem key  %s  value %d ", key, re));
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
            LOGGER.info(String.format("redis get key  %s ", key));
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

	public static JedisUtilTest getInstance() {
		return instance;
	}

	public static void main(String[] args) {
		// JedisUtilTest.getInstance().set("zxc","10");
		// JedisUtilTest.getInstance().expire("sss", 10000);
		// System.out.println(JedisUtilTest.getInstance().get("zxc"));
		// JedisUtilTest.getInstance().incr("zxc");
	}
}
