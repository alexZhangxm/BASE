package com.mcs.service;

import com.mcs.entity.UserInfo;

/**
 * @ClassName UserInfoService
 * @Description:用户信息业务接口
 * @author zhangxm
 * @date 2016年6月6日 上午10:16:43
 */
public interface UserInfoService
{
    
    /**
     * @Description:根据用户ID获取用户数据
     * @param userId
     * @return
     * @author zhangxm
     * @date 2016年6月8日 下午6:23:16
     */
    public UserInfo findUserByUserId(String userId)
        throws Exception;
}
