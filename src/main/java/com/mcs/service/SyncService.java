package com.mcs.service;

import com.mcs.entity.Sync;

/**
 * @ClassName SyncService
 * @Description 同步业务层接口
 * @author zhangxm
 * @date 2016年6月12日 上午9:59:41
 */
public interface SyncService
{
    /**
     * @Description 查找token
     * @return
     * @author zhangxm
     * @date 2016年6月12日 上午9:56:41
     */
    public int findToken(String token)
        throws Exception;
    
    /**
     * @Description 增加同步记录
     * @param userId
     * @param token
     * @throws Exception
     * @author zhangxm
     * @date 2016年6月12日 上午10:29:46
     */
    public void addSync(String userId, String token)
        throws Exception;
    
    /**
     * @Description 查找用户同步记录是否已存在
     * @param userId
     * @return
     * @throws Exception
     * @author zhangxm
     * @date 2016年6月12日 上午11:16:43
     */
    public Sync existSyncUser(String userId)
        throws Exception;
    
    /**
     * @Description 删除同步用户记录
     * @throws Exception
     * @author zhangxm
     * @date 2016年6月12日 下午2:24:30
     */
    public void removeSync()
        throws Exception;
}
