package com.mcs.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.mcs.entity.Devices;
import com.mcs.entity.Sync;
import com.mcs.entity.UserInfo;
import com.mcs.service.DeviceService;
import com.mcs.service.SyncService;
import com.mcs.service.UserInfoService;
import com.mcs.util.RandomUtil;
import com.mcs.util.StringUtil;

/**
 * @ClassName OpenController
 * @Description:开放接口
 * @author zhangxm
 * @date 2016年6月8日 下午5:06:53
 */

@Controller
@RequestMapping("/open")
public class OpenController
{
    
    private static final Log log = LogFactory.getLog(OpenController.class);
    
    @Resource
    private UserInfoService userInfoService;
    
    @Resource
    private SyncService syncService;
    
    @Resource
    private DeviceService deviceService;
    
    /**
     * @Description:身份校验 (http://127.0.0.1:8080/MCS_OPEN/open/authVerify?userId=SYSMGR&password=232599)
     * @return
     * @author zhangxm
     * @throws Exception
     * @date 2016年6月8日 下午5:22:06
     */
    @RequestMapping(value = "/authVerify", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String authVerify(String userId, String password)
        throws Exception
    {
        Map<String, Object> obj = new HashMap<String, Object>();
        
        if (userId == null)
        {
            obj.put("Sign", 0);
            obj.put("Message", "请携带userId进行身份验证!");
            log.info(obj);
            return JSON.toJSONString(obj);
        }
        if (password == null)
        {
            obj.put("Sign", 0);
            obj.put("Message", "请携带password进行身份验证!");
            log.info(obj);
            return JSON.toJSONString(obj);
        }
        Sync sync = syncService.existSyncUser(userId);
        if (sync != null)
        {
            obj.put("Sign", -1);
            obj.put("Message", "用户userId=" + userId + ",身份已通过校验token=" + sync.getToken() + ",请勿重新校验!!!");
            log.info(obj);
            return JSON.toJSONString(obj);
        }
        
        String passwordMD5 = StringUtil.md5(password);
        UserInfo userInfo = userInfoService.findUserByUserId(userId);
        if (userInfo == null)
        {
            obj.put("Sign", -1);
            obj.put("Message", "未找到该用户,请输入正确的用户名密码或请与管理员联系!");
            log.info(obj);
            return JSON.toJSONString(obj);
        }
        if (passwordMD5.equals(userInfo.getPwd()))
        {
            String token = StringUtil.md5(RandomUtil.randomDigit(6));
            syncService.addSync(userId, token);
            obj.put("Sign", 1);
            obj.put("Message", "用户userId=" + userId + ",通过身份校验token=" + token + ",校验码将在一天后失效,请尽快同步数据!!!");
            log.info(obj);
            return JSON.toJSONString(obj);
        }
        else
        {
            obj.put("Sign", -1);
            obj.put("Message", "身份校验未通过,请与管理员联系!");
            log.info(obj);
            return JSON.toJSONString(obj);
        }
    }
    
    /**
     * 获取设备信息(http://127.0.0.1:8080/MCS_OPEN/open/getDevices?token=e4c79d40d7e38b70438addcacebf8813)
     * 
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getDevices", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getDevices(String token)
        throws Exception
    {
        Map<String, Object> obj = new HashMap<String, Object>();
        if (token == null)
        {
            obj.put("Sign", 0);
            obj.put("Message", "请携带身份校验码,token=");
            log.info(obj);
            return JSON.toJSONString(obj);
        }
        int count = syncService.findToken(token);
        if (count != 0)
        {
            List<Devices> devices = deviceService.findAllDevices();
            
            obj.put("Sign", 1);
            obj.put("Message", "成功获取设备信息!");
            obj.put("Data", devices);
            log.info(obj);
            return JSON.toJSONString(obj);
        }
        else
        {
            obj.put("Sign", -1);
            obj.put("Message", "身份校验码出错!!!");
            log.info(obj);
            return JSON.toJSONString(obj);
        }
    }
}
