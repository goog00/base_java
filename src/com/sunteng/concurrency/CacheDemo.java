package com.sunteng.concurrency;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by ST on 16-2-2.
 */
public class CacheDemo {

    private Map<String,Object> cache = new HashMap<String, Object>();

    private ReadWriteLock rwl = new ReentrantReadWriteLock();

    public Object getData(String key){
          rwl.readLock().lock();
          Object value = null;
          try{
              value = cache.get(key);
              if(value == null){
                  rwl.readLock().unlock();
                  rwl.writeLock().lock();
                  if(value == null){
                      try{
                          value = "ddddd";//真实环境去数据库取数据
                      } finally {
                          rwl.readLock().lock();
                          rwl.writeLock().unlock();
                      }
                  }
              }

          }finally {
              rwl.readLock().unlock();
          }

          return  value;
    }
}
