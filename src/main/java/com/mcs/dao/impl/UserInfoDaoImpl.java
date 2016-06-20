package com.mcs.dao.impl;

import org.springframework.stereotype.Repository;

import com.mcs.dao.UserInfoDao;
import com.mcs.dao.base.BaseDao;
import com.mcs.entity.UserInfo;

/**
 * @ClassName UserInfoDaoImpl
 * @Description:用户信息持久层接口实现类
 * @author zhangxm
 * @date 2016年6月6日 上午10:18:08
 */
@Repository
public class UserInfoDaoImpl extends BaseDao<UserInfo> implements UserInfoDao
{
    private final String SQL_GET_USER_BY_ID = "SELECT * FROM USERINFO WHERE USERID = ?";
    
    /**
     * 根据ID获取用户
     * 
     * @throws Exception
     */
    public UserInfo getUserByUserId(String userId)
        throws Exception
    {
        return getObject(SQL_GET_USER_BY_ID, userId);
    }
    
}
