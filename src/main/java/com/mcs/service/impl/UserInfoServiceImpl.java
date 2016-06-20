package com.mcs.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mcs.dao.UserInfoDao;
import com.mcs.entity.UserInfo;
import com.mcs.service.UserInfoService;

/**
 * @ClassName UserInfoServiceImpl
 * @Description:用户信息业务接口实现类
 * @author zhangxm
 * @date 2016年6月6日 上午10:17:18
 */
@Service
public class UserInfoServiceImpl implements UserInfoService
{
    @Resource
    private UserInfoDao userInfoDao;
    
    /**
     * 根据ID获取用户
     * 
     * @throws Exception
     */
    public UserInfo findUserByUserId(String userId)
        throws Exception
    {
        return userInfoDao.getUserByUserId(userId);
    }
    
}
