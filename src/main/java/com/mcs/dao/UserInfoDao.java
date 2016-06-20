package com.mcs.dao;

import com.mcs.entity.UserInfo;

/**
 * @ClassName UserInfoDao
 * @Description:用户信息持久层接口
 * @author zhangxm
 * @date 2016年6月6日 上午10:17:47
 */
public interface UserInfoDao
{
    /**
     * @Description 根据ID获取用户
     * @param userId
     * @return
     * @author zhangxm
     * @date 2016年6月12日 上午10:39:32
     */
    public UserInfo getUserByUserId(String userId)
        throws Exception;
}
