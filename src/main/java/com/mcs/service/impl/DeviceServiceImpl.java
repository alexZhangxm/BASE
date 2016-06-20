package com.mcs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mcs.dao.DeviceDao;
import com.mcs.entity.Devices;
import com.mcs.service.DeviceService;

/**
 * @ClassName DeviceServiceImpl
 * @Description 设备信息业务接口实现类
 * @author zhangxm
 * @date 2016年6月6日 上午10:17:32
 */
@Service
public class DeviceServiceImpl implements DeviceService
{
    @Resource
    private DeviceDao devicesDao;
    
    /**
     * 根据序列号获取设备
     */
    public Devices findDeviceBySerialNo(String serialNo)
        throws Exception
    {
        Devices device = devicesDao.getDeviceBySerialNo(serialNo);
        return device;
    }
    
    /**
     * 根据设备名获取设备
     */
    public List<Devices> findDevicesByName(String deviceName)
        throws Exception
    {
        List<Devices> devices = devicesDao.getDevicesByDeviceName(deviceName);
        return devices;
    }
    
    /**
     * 删除设备
     */
    public void removeDeviceBySerialNo(String serialNo)
        throws Exception
    {
        devicesDao.deleteDeviceBySerialNo(serialNo);
    }
    
    /**
     * 增加设备
     */
    public void addDevice(Devices device)
        throws Exception
    {
        devicesDao.insertDevice(device);
    }
    
    /**
     * 修改设备
     */
    public void modifyDevice(Devices device)
        throws Exception
    {
        devicesDao.updateDevice(device);
    }
    
    /**
     * 批量新增设备
     */
    public void batchAdd(List<Devices> devices)
        throws Exception
    {
        devicesDao.batchInsert(devices);
    }
    
    /**
     * 获取所有设备
     */
    public List<Devices> findAllDevices()
        throws Exception
    {
        return devicesDao.getAllDevices();
    }
    
}
