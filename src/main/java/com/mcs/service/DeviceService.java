package com.mcs.service;

import java.util.List;

import com.mcs.entity.Devices;

/**
 * @ClassName DevicesService
 * @Description:设备信息业务接口
 * @author zhangxm
 * @date 2016年6月6日 上午10:17:04
 */
public interface DeviceService
{
    
    /**
     * @Description:根据序列号获取设备
     * @param serialNo
     * @return
     * @author zhangxm
     * @date 2016年6月6日 上午10:23:37
     */
    public Devices findDeviceBySerialNo(String serialNo)
        throws Exception;
    
    /**
     * @Description:根据设备名获取设备列表
     * @param deviceName
     * @return
     * @throws Exception
     * @author zhangxm
     * @date 2016年6月6日 下午6:22:48
     */
    public List<Devices> findDevicesByName(String deviceName)
        throws Exception;
    
    /**
     * @Description 获取所有设备信息
     * @return
     * @throws Exception
     * @author zhangxm
     * @date 2016年6月12日 上午10:19:07
     */
    public List<Devices> findAllDevices()
        throws Exception;
    
    /**
     * @Description:删除设备
     * @param serialNo
     * @throws Exception
     * @author zhangxm
     * @date 2016年6月8日 上午11:36:54
     */
    public void removeDeviceBySerialNo(String serialNo)
        throws Exception;
    
    /**
     * @Description:增加设备
     * @param device
     * @throws Exception
     * @author zhangxm
     * @date 2016年6月8日 上午11:36:59
     */
    public void addDevice(Devices device)
        throws Exception;
    
    /**
     * @Description:更新设备
     * @param device
     * @throws Exception
     * @author zhangxm
     * @date 2016年6月8日 上午11:37:03
     */
    public void modifyDevice(Devices device)
        throws Exception;
    
    /**
     * @Description:批量新增设备
     * @param devices
     * @throws Exception
     * @author zhangxm
     * @date 2016年6月8日 下午2:41:19
     */
    public void batchAdd(List<Devices> devices)
        throws Exception;
}
