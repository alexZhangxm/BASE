package com.mcs.dao;

import java.util.List;

import com.mcs.entity.Devices;

/**
 * @ClassName DevicesDao
 * @Description:设备信息持久层接口
 * @author zhangxm
 * @date 2016年6月6日 上午10:17:58
 */
public interface DeviceDao
{
    
    /**
     * @Description: 根据序列号获取设备
     * @param serialNo
     * @return
     * @throws Exception
     * @author zhangxm
     * @date 2016年6月6日 下午5:53:05
     */
    public Devices getDeviceBySerialNo(String serialNo)
        throws Exception;
    
    /**
     * @Description: 根据设备名获取设备列表
     * @param deviceName
     * @return
     * @throws Exception
     * @author zhangxm
     * @date 2016年6月6日 下午6:23:42
     */
    public List<Devices> getDevicesByDeviceName(String deviceName)
        throws Exception;
    
    /**
     * @param deviceName
     * @Description: 根据设备名获取设备序列号列表
     * @return
     * @throws Exception
     * @author zhangxm
     * @date 2016年6月7日 下午5:26:36
     */
    public List<String> getSerialNoByDeviceName(String deviceName)
        throws Exception;
    
    /**
     * @Description:
     * @param serialNo
     * @author zhangxm
     * @date 2016年6月8日 上午11:03:58
     */
    public void deleteDeviceBySerialNo(String serialNo)
        throws Exception;
    
    /**
     * @Description:
     * @param device
     * @author zhangxm
     * @date 2016年6月8日 上午11:13:19
     */
    public void insertDevice(Devices device)
        throws Exception;
    
    /**
     * @Description:
     * @param device
     * @throws Exception
     * @author zhangxm
     * @date 2016年6月8日 上午11:13:39
     */
    public void updateDevice(Devices device)
        throws Exception;
    
    /**
     * @Description: 批量新增
     * @param devices
     * @throws Exception
     * @author zhangxm
     * @date 2016年6月8日 下午2:49:29
     */
    public void batchInsert(List<Devices> devices)
        throws Exception;
    
    /**
     * @Description:查询设备数量
     * @param deviceName
     * @return
     * @author zhangxm
     * @date 2016年6月8日 下午3:39:56
     */
    public int countDeviceByName(String deviceName)
        throws Exception;
    
    /**
     * @Description 获取所有设备
     * @return
     * @author zhangxm
     * @date 2016年6月12日 上午10:21:16
     */
    public List<Devices> getAllDevices()
        throws Exception;
}
