package com.mcs.dao;

import com.mcs.entity.Sync;

/**
 * @ClassName SyncDao
 * @Description 同步持久层接口
 * @author zhangxm
 * @date 2016年6月12日 上午10:00:28
 */
public interface SyncDao
{
    /**
     * @Description 查找token
     * @param token
     * @return
     * @author zhangxm
     * @date 2016年6月12日 上午10:05:44
     */
    public int getToken(String token)
        throws Exception;
    
    /**
     * @Description 增加同步记录
     * @param userId
     * @param token
     * @throws Exception
     * @author zhangxm
     * @date 2016年6月12日 上午10:31:54
     */
    public void insertSync(String userId, String token)
        throws Exception;
    
    /**
     * @Description 查找用户同步记录
     * @param userId
     * @throws Exception
     * @author zhangxm
     * @date 2016年6月12日 上午11:20:26
     */
    public Sync getSyncUser(String userId)
        throws Exception;
    
    /**
     * @Description 删除同步记录
     * @throws Exception
     * @author zhangxm
     * @date 2016年6月12日 下午2:25:31
     */
    public void deleteSync()
        throws Exception;
}
