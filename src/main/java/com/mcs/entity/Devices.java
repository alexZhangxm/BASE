package com.mcs.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import com.mcs.meta.Column;
import com.mcs.util.DateUtil;

/**
 * @ClassName Devices
 * @Description:设备实体类
 * @author zhangxm
 * @date 2016年6月2日 下午6:23:03
 */
public class Devices implements Serializable
{
    
    /**
     * 
     */
    private static final long serialVersionUID = -2238634227209835738L;
    
    @Column("SerialNo")
    private String serialNo;
    
    @Column("DeviceNo")
    private String deviceNo;
    
    @Column("DeviceName")
    private String deviceName;
    
    @Column("Descript")
    private String descript;
    
    @Column("DeviceType")
    private Integer deviceType;
    
    @Column("DeviceCategory")
    private String deviceCategory;
    
    @Column("DeviceNature")
    private Integer deviceNature;
    
    @Column("SpecNo")
    private String specNo;
    
    @Column("BankTerminalNo")
    private String bankTerminalNo;
    
    @Column("BankDeviceNo")
    private String bankDeviceNo;
    
    @Column("Ip")
    private String ip;
    
    @Column("Mask")
    private String mask;
    
    @Column("Gateway")
    private String gateway;
    
    @Column("ServerIP")
    private String serverIP;
    
    @Column("ServerPort")
    private String serverPort;
    
    @Column("SoftwareVersion")
    private String softwareVersion;
    
    @Column("AntiVirus")
    private String antiVirus;
    
    @Column("CustCode")
    private String custCode;
    
    @Column("SubCustCode1")
    private String subCustCode1;
    
    @Column("SubCustCode2")
    private String subCustCode2;
    
    @Column("SubCustCode3")
    private String subCustCode3;
    
    @Column("PmCustCode")
    private String pmCustCode;
    
    @Column("ProjID")
    private String projID;
    
    @Column("SaleContractNo")
    private String saleContractNo;
    
    @Column("PmContractNo")
    private String pmContractNo;
    
    @Column("SiteID")
    private String siteID;
    
    @Column("SiteName")
    private String siteName;// 网点名字
    
    @Column("DeviceIncharge")
    private String deviceIncharge;
    
    @Column("OpenDate")
    private Timestamp openDate;
    
    @Column("QaDate")
    private Timestamp qaDate;
    
    @Column("QaStat")
    private Integer qaStat;
    
    @Column("RecvQAReport")
    private Integer recvQAReport;
    
    @Column("SetupDate")
    private Timestamp setupDate;
    
    @Column("CountDate")
    private Timestamp countDate;
    
    @Column("CountStat")
    private Integer countStat;
    
    @Column("MaintainStat")
    private Integer maintainStat;
    
    @Column("ScExpiryDate")
    private Timestamp scExpiryDate;
    
    @Column("PmExpiryDate")
    private Timestamp pmExpiryDate;
    
    @Column("DeviceStatus")
    private String deviceStatus;
    
    @Column("Remark")
    private String remark;
    
    @Column("UpdateUser")
    private String updateUser;
    
    @Column("UpdateDate")
    private Date updateDate;
    
    @Column("CreateUser")
    private String createUser;
    
    @Column("CreateDate")
    private Date createDate;
    
    @Column("RowPointer")
    private String rowPointer;
    
    @Column("DeptNo")
    private String deptNo;// 服务站
    
    @Column("DeviceCataegory")
    private String deviceCataegory;
    
    public String getSerialNo()
    {
        return serialNo;
    }
    
    public void setSerialNo(String serialNo)
    {
        this.serialNo = serialNo;
    }
    
    public String getDeviceNo()
    {
        return deviceNo;
    }
    
    public void setDeviceNo(String deviceNo)
    {
        this.deviceNo = deviceNo;
    }
    
    public String getDeviceName()
    {
        return deviceName;
    }
    
    public void setDeviceName(String deviceName)
    {
        this.deviceName = deviceName;
    }
    
    public String getDescript()
    {
        return descript;
    }
    
    public void setDescript(String descript)
    {
        this.descript = descript;
    }
    
    public Integer getDeviceType()
    {
        return deviceType;
    }
    
    public void setDeviceType(Integer deviceType)
    {
        this.deviceType = deviceType;
    }
    
    public String getDeviceCategory()
    {
        return deviceCategory;
    }
    
    public void setDeviceCategory(String deviceCategory)
    {
        this.deviceCategory = deviceCategory;
    }
    
    public Integer getDeviceNature()
    {
        return deviceNature;
    }
    
    public void setDeviceNature(Integer deviceNature)
    {
        this.deviceNature = deviceNature;
    }
    
    public String getSpecNo()
    {
        return specNo;
    }
    
    public void setSpecNo(String specNo)
    {
        this.specNo = specNo;
    }
    
    public String getBankTerminalNo()
    {
        return bankTerminalNo;
    }
    
    public void setBankTerminalNo(String bankTerminalNo)
    {
        this.bankTerminalNo = bankTerminalNo;
    }
    
    public String getBankDeviceNo()
    {
        return bankDeviceNo;
    }
    
    public void setBankDeviceNo(String bankDeviceNo)
    {
        this.bankDeviceNo = bankDeviceNo;
    }
    
    public String getIp()
    {
        return ip;
    }
    
    public void setIp(String ip)
    {
        this.ip = ip;
    }
    
    public String getMask()
    {
        return mask;
    }
    
    public void setMask(String mask)
    {
        this.mask = mask;
    }
    
    public String getGateway()
    {
        return gateway;
    }
    
    public void setGateway(String gateway)
    {
        this.gateway = gateway;
    }
    
    public String getServerIP()
    {
        return serverIP;
    }
    
    public void setServerIP(String serverIP)
    {
        this.serverIP = serverIP;
    }
    
    public String getServerPort()
    {
        return serverPort;
    }
    
    public void setServerPort(String serverPort)
    {
        this.serverPort = serverPort;
    }
    
    public String getSoftwareVersion()
    {
        return softwareVersion;
    }
    
    public void setSoftwareVersion(String softwareVersion)
    {
        this.softwareVersion = softwareVersion;
    }
    
    public String getAntiVirus()
    {
        return antiVirus;
    }
    
    public void setAntiVirus(String antiVirus)
    {
        this.antiVirus = antiVirus;
    }
    
    public String getCustCode()
    {
        return custCode;
    }
    
    public void setCustCode(String custCode)
    {
        this.custCode = custCode;
    }
    
    public String getSubCustCode1()
    {
        return subCustCode1;
    }
    
    public void setSubCustCode1(String subCustCode1)
    {
        this.subCustCode1 = subCustCode1;
    }
    
    public String getSubCustCode2()
    {
        return subCustCode2;
    }
    
    public void setSubCustCode2(String subCustCode2)
    {
        this.subCustCode2 = subCustCode2;
    }
    
    public String getSubCustCode3()
    {
        return subCustCode3;
    }
    
    public void setSubCustCode3(String subCustCode3)
    {
        this.subCustCode3 = subCustCode3;
    }
    
    public String getPmCustCode()
    {
        return pmCustCode;
    }
    
    public void setPmCustCode(String pmCustCode)
    {
        this.pmCustCode = pmCustCode;
    }
    
    public String getProjID()
    {
        return projID;
    }
    
    public void setProjID(String projID)
    {
        this.projID = projID;
    }
    
    public String getSaleContractNo()
    {
        return saleContractNo;
    }
    
    public void setSaleContractNo(String saleContractNo)
    {
        this.saleContractNo = saleContractNo;
    }
    
    public String getPmContractNo()
    {
        return pmContractNo;
    }
    
    public void setPmContractNo(String pmContractNo)
    {
        this.pmContractNo = pmContractNo;
    }
    
    public String getSiteID()
    {
        return siteID;
    }
    
    public void setSiteID(String siteID)
    {
        this.siteID = siteID;
    }
    
    public String getSiteName()
    {
        return siteName;
    }
    
    public void setSiteName(String siteName)
    {
        this.siteName = siteName;
    }
    
    public String getDeviceIncharge()
    {
        return deviceIncharge;
    }
    
    public void setDeviceIncharge(String deviceIncharge)
    {
        this.deviceIncharge = deviceIncharge;
    }
    
    public Timestamp getOpenDate()
    {
        return openDate;
    }
    
    public void setOpenDate(Timestamp openDate)
    {
        this.openDate = openDate;
    }
    
    public Timestamp getQaDate()
    {
        return qaDate;
    }
    
    public void setQaDate(Timestamp qaDate)
    {
        this.qaDate = qaDate;
    }
    
    public Integer getQaStat()
    {
        return qaStat;
    }
    
    public void setQaStat(Integer qaStat)
    {
        this.qaStat = qaStat;
    }
    
    public Integer getRecvQAReport()
    {
        return recvQAReport;
    }
    
    public void setRecvQAReport(Integer recvQAReport)
    {
        this.recvQAReport = recvQAReport;
    }
    
    public Timestamp getSetupDate()
    {
        return setupDate;
    }
    
    public void setSetupDate(Timestamp setupDate)
    {
        this.setupDate = setupDate;
    }
    
    public Timestamp getCountDate()
    {
        return countDate;
    }
    
    public void setCountDate(Timestamp countDate)
    {
        this.countDate = countDate;
    }
    
    public Integer getCountStat()
    {
        return countStat;
    }
    
    public void setCountStat(Integer countStat)
    {
        this.countStat = countStat;
    }
    
    public Integer getMaintainStat()
    {
        return maintainStat;
    }
    
    public void setMaintainStat(Integer maintainStat)
    {
        this.maintainStat = maintainStat;
    }
    
    public Timestamp getScExpiryDate()
    {
        return scExpiryDate;
    }
    
    public void setScExpiryDate(Timestamp scExpiryDate)
    {
        this.scExpiryDate = scExpiryDate;
    }
    
    public Timestamp getPmExpiryDate()
    {
        return pmExpiryDate;
    }
    
    public void setPmExpiryDate(Timestamp pmExpiryDate)
    {
        this.pmExpiryDate = pmExpiryDate;
    }
    
    public String getDeviceStatus()
    {
        return deviceStatus;
    }
    
    public void setDeviceStatus(String deviceStatus)
    {
        this.deviceStatus = deviceStatus;
    }
    
    public String getRemark()
    {
        return remark;
    }
    
    public void setRemark(String remark)
    {
        this.remark = remark;
    }
    
    public String getUpdateUser()
    {
        return updateUser;
    }
    
    public void setUpdateUser(String updateUser)
    {
        this.updateUser = updateUser;
    }
    
    public Date getUpdateDate()
    {
        return updateDate;
    }
    
    public void setUpdateDate(Date updateDate)
    {
        this.updateDate = updateDate;
    }
    
    public String getCreateUser()
    {
        return createUser;
    }
    
    public void setCreateUser(String createUser)
    {
        this.createUser = createUser;
    }
    
    public Date getCreateDate()
    {
        return createDate;
    }
    
    public void setCreateDate(Date createDate)
    {
        this.createDate = createDate;
    }
    
    public String getRowPointer()
    {
        return rowPointer;
    }
    
    public void setRowPointer(String rowPointer)
    {
        this.rowPointer = rowPointer;
    }
    
    public String getDeptNo()
    {
        return deptNo;
    }
    
    public void setDeptNo(String deptNo)
    {
        this.deptNo = deptNo;
    }
    
    public String getDeviceCataegory()
    {
        return deviceCataegory;
    }
    
    public void setDeviceCataegory(String deviceCataegory)
    {
        this.deviceCataegory = deviceCataegory;
    }
    
    public String getCreateDateStr()
    {
        String date = "";
        if (createDate != null)
        {
            
            date = DateUtil.format(createDate, "yyyy-MM-dd HH:mm");
        }
        return date;
    }
}
