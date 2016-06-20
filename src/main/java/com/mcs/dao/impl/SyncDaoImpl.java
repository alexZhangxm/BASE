package com.mcs.dao.impl;

import java.util.Date;

import org.springframework.stereotype.Repository;

import com.mcs.dao.SyncDao;
import com.mcs.dao.base.BaseDao;
import com.mcs.entity.Sync;

/**
 * @ClassName SyncDaoImpl
 * @Description 同步持久层接口实现类
 * @author zhangxm
 * @date 2016年6月12日 上午10:00:43
 */
@Repository
public class SyncDaoImpl extends BaseDao<Sync> implements SyncDao
{
    private static final String SQL_CONT_TOKEN_EXIST = "SELECT COUNT(0) FROM SYNC WHERE TOKEN = ?";
    
    private static final String SQL_INSERT_SYNC = "INSERT INTO SYNC(USERID, TOKEN, CREATEDATE) VALUES (?,?,?)";
    
    private static final String SQL_GET_USER_SYNC = "SELECT * FROM SYNC WHERE USERID = ?";
    
    private static final String SQL_DELETE_SYNC = "DELETE FROM SYNC";
    
    /**
     * 查找token
     */
    public int getToken(String token)
        throws Exception
    {
        return getCount(SQL_CONT_TOKEN_EXIST, token);
    }
    
    /**
     * 增加同步记录
     */
    public void insertSync(String userId, String token)
        throws Exception
    {
        execute(SQL_INSERT_SYNC, userId, token, new Date());
        
    }
    
    /**
     * 查找用户记录
     * 
     * @return
     */
    public Sync getSyncUser(String userId)
        throws Exception
    {
        return getObject(SQL_GET_USER_SYNC, userId);
    }
    
    /**
     * 删除同步用户
     */
    public void deleteSync()
        throws Exception
    {
        execute(SQL_DELETE_SYNC);
    }
}
