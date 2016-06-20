package com.mcs.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.mcs.dao.DeviceDao;
import com.mcs.dao.base.BaseDao;
import com.mcs.entity.Devices;

/**
 * @ClassName DeviceDaoImpl
 * @Description:设备信息持久层接口实现类
 * @author zhangxm
 * @date 2016年6月6日 上午10:18:21
 */
@Repository
public class DeviceDaoImpl extends BaseDao<Devices> implements DeviceDao
{
    
    private static final String SQL_GET_DEVICES_BY_SERIALNO = "SELECT * FROM PLC_DEVICES WHERE SERIALNO = ?";
    
    private static final String SQL_GET_DEVICES_BY_DEVICENAME =
        "SELECT * FROM PLC_DEVICES WHERE DEVICENAME = ? ORDER BY CREATEDATE";
    
    private static final String SQL_DEL_DEVICE_BY_SERIALNO_STRING = "DELETE FROM PLC_DEVICES WHERE SERIALNO = ?";
    
    private static final String SQL_INSERT_DEVICE =
        "INSERT INTO PLC_DEVICES (SERIALNO,DEVICENO,DEVICENAME,DEVICENATURE,DEVICESTATUS,ROWPOINTER) VALUES (?,?,?,?,?,?)";
    
    private static final String SQL_UPDATE_DEVICE =
        "UPDATE PLC_DEVICES SET DEVICENO = ?, DEVICENAME = ? WHERE SERIALNO = ? ";
    
    private static final String SQL_COUNT_DEVICE_BY_DEVICENAME =
        "SELECT COUNT(0) FROM PLC_DEVICES WHERE DEVICENAME = ?";
    
    private static final String SQL_GET_DEVICES = "SELECT * FROM PLC_DEVICES";
    
    // /**
    // * 单记录映射集
    // */
    // public class DeviceMapper implements RowMapper<Devices>
    // {
    // public Devices mapRow(ResultSet rs, int rowNum)
    // throws SQLException
    // {
    // Devices device = new Devices();
    // device.setSerialNo(rs.getString("serialNo"));
    // device.setDeviceNo(rs.getString("deviceNo"));
    // device.setDeviceName(rs.getString("deviceName"));
    // device.setRowPointer(rs.getString("rowPointer"));
    // device.setDeviceType(rs.getInt("deviceType"));
    // device.setCreateDate(rs.getTimestamp("createDate"));
    // return device;
    // }
    // }
    
    /**
     * 根据序列号获取设备
     */
    public Devices getDeviceBySerialNo(String serialNo)
        throws Exception
    {
        // Devices device = getObject(new DeviceMapper(), SQL_GET_DEVICES_BY_SERIALNO, new Object[] {serialNo});
        Devices device = getObject(SQL_GET_DEVICES_BY_SERIALNO, serialNo);
        return device;
    }
    
    /**
     * 根据设备名获取设备列表
     */
    public List<Devices> getDevicesByDeviceName(String deviceName)
        throws Exception
    {
        List<Devices> devices = findObjects(SQL_GET_DEVICES_BY_DEVICENAME, deviceName);
        return devices;
    }
    
    /**
     * 根据设备名获取设备序列号列表
     */
    public List<String> getSerialNoByDeviceName(String deviceName)
        throws Exception
    {
        List<String> serialNos = findObject(SQL_GET_DEVICES_BY_DEVICENAME, deviceName);
        return serialNos;
    }
    
    /**
     * 根据序列号删除设备
     */
    public void deleteDeviceBySerialNo(String serialNo)
        throws Exception
    {
        execute(SQL_DEL_DEVICE_BY_SERIALNO_STRING, serialNo);
    }
    
    /**
     * 增加设备
     */
    public void insertDevice(Devices device)
        throws Exception
    {
        execute(SQL_INSERT_DEVICE,
            device.getSerialNo(),
            device.getDeviceNo(),
            device.getDeviceName(),
            device.getDeviceNature(),
            device.getDeviceStatus(),
            device.getRowPointer());
    }
    
    /**
     * 更新设备
     */
    public void updateDevice(Devices device)
        throws Exception
    {
        execute(SQL_UPDATE_DEVICE, device.getDeviceNo(), device.getDeviceName(), device.getSerialNo());
    }
    
    /**
     * 批量新增设备
     */
    public void batchInsert(final List<Devices> devices)
        throws Exception
    {
        batchExecute(SQL_INSERT_DEVICE, new BatchPreparedStatementSetter()
        {
            public int getBatchSize()
            {
                return devices.size();
            }
            
            public void setValues(PreparedStatement ps, int i)
                throws SQLException
            {
                Devices device = devices.get(i);
                ps.setString(1, device.getSerialNo());
                ps.setString(2, device.getDeviceNo());
                ps.setString(3, device.getDeviceName());
                ps.setInt(4, device.getDeviceNature());
                ps.setString(5, device.getDeviceStatus());
                ps.setString(6, device.getRowPointer());
            }
        });
    }
    
    /**
     * 查询数量
     */
    public int countDeviceByName(String deviceName)
        throws Exception
    {
        return getCount(SQL_COUNT_DEVICE_BY_DEVICENAME, deviceName);
    }
    
    /**
     * 获取所有设备
     */
    public List<Devices> getAllDevices()
        throws Exception
    {
        return findObjects(SQL_GET_DEVICES);
    }
    
}
