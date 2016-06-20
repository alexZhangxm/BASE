package com.mcs.test.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.mcs.dao.DeviceDao;
import com.mcs.entity.Devices;
import com.mcs.test.BaseJunit4Test;

public class DevicesDaoTest extends BaseJunit4Test
{
    @Resource
    private DeviceDao devicesDao;
    
    @Test
    public void getdevice()
        throws Exception
    {
        Devices device = devicesDao.getDeviceBySerialNo("CF2112Q000114");
        System.out.println(device.getDeviceName());
        List<String> serialNos = devicesDao.getSerialNoByDeviceName("穿墙式自动取款机");
        for (String no : serialNos)
        {
            System.out.println(no);
        }
    }
    
    @Test
    public void updateDevice()
        throws Exception
    {
        devicesDao.deleteDeviceBySerialNo("1111");
        
        Devices device = new Devices();
        device.setSerialNo("1111");
        device.setDeviceName("test");
        devicesDao.updateDevice(device);
        
        Devices devi = new Devices();
        devi.setSerialNo("666");
        devi.setDeviceNo("6666");
        devi.setDeviceName("6");
        devi.setDeviceNature(1);
        devi.setDeviceStatus("1");
        devi.setRowPointer("66666");
        // devicesDao.insertDevice(devi);
    }
    
    @Test
    public void batchUpdateDevice()
        throws Exception
    {
        List<Devices> devices = new ArrayList<Devices>();
        
        Devices device = new Devices();
        device.setSerialNo("999");
        device.setDeviceNo("999");
        device.setDeviceName("tt99");
        device.setDeviceNature(1);
        device.setDeviceStatus("1");
        device.setRowPointer("999999");
        Devices de = new Devices();
        de.setSerialNo("000");
        de.setDeviceNo("000");
        de.setDeviceName("tt00");
        de.setDeviceNature(0);
        de.setDeviceStatus("0");
        de.setRowPointer("00000");
        
        devices.add(de);
        
        // devicesDao.batchInsert(devices);
        
    }
    
    @Test
    public void getDeviceCount()
        throws Exception
    {
        int count = devicesDao.countDeviceByName("穿墙式自动取款机");
        System.out.println(count);
    }
}
