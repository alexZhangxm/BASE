package com.mcs.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.mcs.entity.Devices;
import com.mcs.service.DeviceService;

/**
 * @ClassName HelloWorldController
 * @Description:视图层测试类
 * @author zhangxm
 * @date 2016年6月7日 上午9:46:41
 */
@Controller
@RequestMapping("/")
public class TestController
{
    
    private static final Log log = LogFactory.getLog(TestController.class);
    
    @Resource
    private DeviceService devicesService;
    
    /**
     * @Description 跳转测试页(http://127.0.0.1:8080/MCS_OPEN/loginIndex.htm)
     * @return
     * @author zhangxm
     * @date 2016年6月7日 上午9:44:05
     */
    @RequestMapping("/loginIndex.htm")
    public String loginIndex()
    {
        return "springmvcTest";
    }
    
    /**
     * @Description 获取测试页返回结果
     * @param device
     * @param modelMap
     * @return
     * @throws Exception
     * @author zhangxm
     * @date 2016年6月7日 上午9:44:55
     */
    @RequestMapping("/login.htm")
    public String login(Devices device, ModelMap modelMap)
        throws Exception
    {
        log.info("设备名字:" + device.getDeviceName());
        Devices dev = devicesService.findDeviceBySerialNo(device.getSerialNo());
        List<Devices> devices = devicesService.findDevicesByName(device.getDeviceName());
        
        // Devices de = new Devices();
        // de.setSerialNo("1111");
        // de.setDeviceNo("666");
        // de.setDeviceName("tt66");
        // devicesService.modifyDevice(de);
        //
        // Devices d = new Devices();
        // d.setSerialNo("666");
        // d.setDeviceNo("888");
        // d.setDeviceName("tt888");
        // d.setDeviceNature(1);
        //
        // d.setDeviceStatus("1");
        // d.setRowPointer("88888");
        // devicesService.addDevice(d);
        // devicesService.removeDeviceBySerialNo("1111");
        // ////////////////////////////
        // List<Devices> des = new ArrayList<Devices>();
        // Devices d = new Devices();
        // d.setSerialNo("FFF-TTT");
        // d.setDeviceNo("999");
        // d.setDeviceName("tt99");
        // d.setDeviceNature(1);
        // d.setDeviceStatus("1");
        // d.setRowPointer("FFF-999999-TTT");
        // des.add(d);
        // Devices de = new Devices();
        // de.setSerialNo("GGG-TTT");
        // de.setDeviceNo("000");
        // de.setDeviceName("tt00");
        // de.setDeviceNature(0);
        // de.setDeviceStatus("0");
        // de.setRowPointer("GGG-00000-TTT");
        // des.add(de);
        // devicesService.batchAdd(des);
        
        modelMap.addAttribute("device", dev);
        modelMap.addAttribute("devices", devices);
        log.info("设备数量:" + devices.size());
        return "showMessageTest";
    }
    
    /**
     * 测试返回JSON数据
     * 
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/testJson", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String test()
        throws Exception
    {
        Devices dev = devicesService.findDeviceBySerialNo("CF2112Q000114");
        List<Devices> devices = devicesService.findDevicesByName("穿墙式自动取款机");
        return JSON.toJSONString(devices);
    }
    
    @RequestMapping("/test.htm")
    public String test(Devices device, ModelMap modelMap)
        throws Exception
    {
        return "test";
    }
}