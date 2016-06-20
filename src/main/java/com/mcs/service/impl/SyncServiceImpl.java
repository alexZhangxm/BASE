package com.mcs.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mcs.dao.SyncDao;
import com.mcs.entity.Sync;
import com.mcs.service.SyncService;

/**
 * @ClassName SyncServiceImpl
 * @Description 同步业务层接口实现类
 * @author zhangxm
 * @date 2016年6月12日 上午9:59:06
 */
@Service
public class SyncServiceImpl implements SyncService
{
    @Resource
    private SyncDao syncDao;
    
    /**
     * 查找token
     */
    public int findToken(String token)
        throws Exception
    {
        return syncDao.getToken(token);
    }
    
    /**
     * 增加同步记录
     */
    public void addSync(String userId, String token)
        throws Exception
    {
        syncDao.insertSync(userId, token);
    }
    
    /**
     * 查找用户同步记录
     */
    public Sync existSyncUser(String userId)
        throws Exception
    {
        return syncDao.getSyncUser(userId);
    }
    
    /**
     * 删除同步用户
     */
    public void removeSync()
        throws Exception
    {
        syncDao.deleteSync();
    }
    
}
