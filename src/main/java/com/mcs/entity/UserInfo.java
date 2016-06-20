package com.mcs.entity;

import java.io.Serializable;
import java.util.Date;

import com.mcs.meta.Column;

/**
 * @ClassName UserInfo
 * @Description:用户实体类
 * @author zhangxm
 * @date 2016年6月2日 下午6:06:40
 */
public class UserInfo implements Serializable
{
    
    /**
     * 
     */
    private static final long serialVersionUID = -6435220793929441368L;
    
    @Column("UserID")
    private String userId;
    
    @Column("PWD")
    private String pwd;
    
    @Column("UserType")
    private String userType;
    
    @Column("UserNM")
    private String userNM;
    
    @Column("Gender")
    private String gender;
    
    @Column("IsAdmin")
    private Boolean isAdmin;
    
    private Boolean isMCS;
    
    private Boolean isPLC;
    
    @Column("Permit")
    private String permit;
    
    @Column("EmpNo")
    private String empNo;
    
    @Column("CardNo")
    private String cardNo;
    
    @Column("DeptNo")
    private String deptNo;
    
    @Column("DepartCode")
    private String departCode;
    
    @Column("TelNo")
    private String telNo;
    
    @Column("Online")
    private String online;
    
    private String TMSOL;
    
    private String ABCOL;
    
    @Column("LastLogin")
    private Date lastLogin;
    
    @Column("LastLogout")
    private Date lastLogout;
    
    private Date lastLogin_TMS;
    
    private Date lastLoginut_TMS;
    
    private Date lastLogin_ABC;
    
    private Date lastLoginut_ABC;
    
    @Column("InCompany")
    private Boolean inCompany;
    
    @Column("Account")
    private Boolean account;
    
    private Boolean subAcc;
    
    private Boolean defaultMode;
    
    private Boolean defaultWH;
    
    private Boolean wHctrl;
    
    private Boolean allowMultiLogin;
    
    @Column("Email")
    private String email;
    
    private String langID;
    
    private String WMS;
    
    private String ABC;
    
    private String TMS;
    
    private String OMS;
    
    private String webOMS;
    
    private String HH;
    
    private String billing;
    
    private String extension;
    
    @Column("PushApplID")
    private String pushApplID;
    
    @Column("PushChannelID")
    private String pushChannelID;
    
    @Column("PushUserID")
    private String pushUserID;
    
    private String pushType;
    
    private String macid;
    
    private String sessionkey;
    
    private Boolean active;
    
    private Boolean readOnly;
    
    private Boolean chgGateCharge;
    
    private Boolean chgBinLoc;
    
    private String chgGridFormat;
    
    private String chgFieldProp;
    
    private String chgPartyAccount;
    
    private String canViewPartyTariff;
    
    private String canModifyPartyTariff;
    
    private String canUnapprInvoice;
    
    private String canChangeAfterCompleted;
    
    private String selectByTTCode;
    
    private String combineConsignee;
    
    private String appServerList;
    
    private String reprintReceipt;
    
    @Column("Remark")
    private String remark;
    
    @Column("UpdateDate")
    private Date updateDate;
    
    @Column("UpdateUser")
    private String updateUser;
    
    @Column("CreateDate")
    private Date createDate;
    
    @Column("CreateUser")
    private String createUser;
    
    private String leadid;
    
    private String proxyid;
    
    public String getUserId()
    {
        return userId;
    }
    
    public void setUserId(String userId)
    {
        this.userId = userId;
    }
    
    public String getPwd()
    {
        return pwd;
    }
    
    public void setPwd(String pwd)
    {
        this.pwd = pwd;
    }
    
    public String getUserType()
    {
        return userType;
    }
    
    public void setUserType(String userType)
    {
        this.userType = userType;
    }
    
    public String getUserNM()
    {
        return userNM;
    }
    
    public void setUserNM(String userNM)
    {
        this.userNM = userNM;
    }
    
    public String getGender()
    {
        return gender;
    }
    
    public void setGender(String gender)
    {
        this.gender = gender;
    }
    
    public Boolean getIsAdmin()
    {
        return isAdmin;
    }
    
    public void setIsAdmin(Boolean isAdmin)
    {
        this.isAdmin = isAdmin;
    }
    
    public Boolean getIsMCS()
    {
        return isMCS;
    }
    
    public void setIsMCS(Boolean isMCS)
    {
        this.isMCS = isMCS;
    }
    
    public Boolean getIsPLC()
    {
        return isPLC;
    }
    
    public void setIsPLC(Boolean isPLC)
    {
        this.isPLC = isPLC;
    }
    
    public String getPermit()
    {
        return permit;
    }
    
    public void setPermit(String permit)
    {
        this.permit = permit;
    }
    
    public String getEmpNo()
    {
        return empNo;
    }
    
    public void setEmpNo(String empNo)
    {
        this.empNo = empNo;
    }
    
    public String getCardNo()
    {
        return cardNo;
    }
    
    public void setCardNo(String cardNo)
    {
        this.cardNo = cardNo;
    }
    
    public String getDeptNo()
    {
        return deptNo;
    }
    
    public void setDeptNo(String deptNo)
    {
        this.deptNo = deptNo;
    }
    
    public String getDepartCode()
    {
        return departCode;
    }
    
    public void setDepartCode(String departCode)
    {
        this.departCode = departCode;
    }
    
    public String getTelNo()
    {
        return telNo;
    }
    
    public void setTelNo(String telNo)
    {
        this.telNo = telNo;
    }
    
    public String getOnline()
    {
        return online;
    }
    
    public void setOnline(String online)
    {
        this.online = online;
    }
    
    public String getTMSOL()
    {
        return TMSOL;
    }
    
    public void setTMSOL(String tMSOL)
    {
        TMSOL = tMSOL;
    }
    
    public String getABCOL()
    {
        return ABCOL;
    }
    
    public void setABCOL(String aBCOL)
    {
        ABCOL = aBCOL;
    }
    
    public Date getLastLogin()
    {
        return lastLogin;
    }
    
    public void setLastLogin(Date lastLogin)
    {
        this.lastLogin = lastLogin;
    }
    
    public Date getLastLogout()
    {
        return lastLogout;
    }
    
    public void setLastLogout(Date lastLogout)
    {
        this.lastLogout = lastLogout;
    }
    
    public Date getLastLogin_TMS()
    {
        return lastLogin_TMS;
    }
    
    public void setLastLogin_TMS(Date lastLogin_TMS)
    {
        this.lastLogin_TMS = lastLogin_TMS;
    }
    
    public Date getLastLoginut_TMS()
    {
        return lastLoginut_TMS;
    }
    
    public void setLastLoginut_TMS(Date lastLoginut_TMS)
    {
        this.lastLoginut_TMS = lastLoginut_TMS;
    }
    
    public Date getLastLogin_ABC()
    {
        return lastLogin_ABC;
    }
    
    public void setLastLogin_ABC(Date lastLogin_ABC)
    {
        this.lastLogin_ABC = lastLogin_ABC;
    }
    
    public Date getLastLoginut_ABC()
    {
        return lastLoginut_ABC;
    }
    
    public void setLastLoginut_ABC(Date lastLoginut_ABC)
    {
        this.lastLoginut_ABC = lastLoginut_ABC;
    }
    
    public Boolean getInCompany()
    {
        return inCompany;
    }
    
    public void setInCompany(Boolean inCompany)
    {
        this.inCompany = inCompany;
    }
    
    public Boolean getAccount()
    {
        return account;
    }
    
    public void setAccount(Boolean account)
    {
        this.account = account;
    }
    
    public Boolean getSubAcc()
    {
        return subAcc;
    }
    
    public void setSubAcc(Boolean subAcc)
    {
        this.subAcc = subAcc;
    }
    
    public Boolean getDefaultMode()
    {
        return defaultMode;
    }
    
    public void setDefaultMode(Boolean defaultMode)
    {
        this.defaultMode = defaultMode;
    }
    
    public Boolean getDefaultWH()
    {
        return defaultWH;
    }
    
    public void setDefaultWH(Boolean defaultWH)
    {
        this.defaultWH = defaultWH;
    }
    
    public Boolean getwHctrl()
    {
        return wHctrl;
    }
    
    public void setwHctrl(Boolean wHctrl)
    {
        this.wHctrl = wHctrl;
    }
    
    public Boolean getAllowMultiLogin()
    {
        return allowMultiLogin;
    }
    
    public void setAllowMultiLogin(Boolean allowMultiLogin)
    {
        this.allowMultiLogin = allowMultiLogin;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public String getLangID()
    {
        return langID;
    }
    
    public void setLangID(String langID)
    {
        this.langID = langID;
    }
    
    public String getWMS()
    {
        return WMS;
    }
    
    public void setWMS(String wMS)
    {
        WMS = wMS;
    }
    
    public String getABC()
    {
        return ABC;
    }
    
    public void setABC(String aBC)
    {
        ABC = aBC;
    }
    
    public String getTMS()
    {
        return TMS;
    }
    
    public void setTMS(String tMS)
    {
        TMS = tMS;
    }
    
    public String getOMS()
    {
        return OMS;
    }
    
    public void setOMS(String oMS)
    {
        OMS = oMS;
    }
    
    public String getWebOMS()
    {
        return webOMS;
    }
    
    public void setWebOMS(String webOMS)
    {
        this.webOMS = webOMS;
    }
    
    public String getHH()
    {
        return HH;
    }
    
    public void setHH(String hH)
    {
        HH = hH;
    }
    
    public String getBilling()
    {
        return billing;
    }
    
    public void setBilling(String billing)
    {
        this.billing = billing;
    }
    
    public String getExtension()
    {
        return extension;
    }
    
    public void setExtension(String extension)
    {
        this.extension = extension;
    }
    
    public String getPushApplID()
    {
        return pushApplID;
    }
    
    public void setPushApplID(String pushApplID)
    {
        this.pushApplID = pushApplID;
    }
    
    public String getPushChannelID()
    {
        return pushChannelID;
    }
    
    public void setPushChannelID(String pushChannelID)
    {
        this.pushChannelID = pushChannelID;
    }
    
    public String getPushUserID()
    {
        return pushUserID;
    }
    
    public void setPushUserID(String pushUserID)
    {
        this.pushUserID = pushUserID;
    }
    
    public String getPushType()
    {
        return pushType;
    }
    
    public void setPushType(String pushType)
    {
        this.pushType = pushType;
    }
    
    public String getMacid()
    {
        return macid;
    }
    
    public void setMacid(String macid)
    {
        this.macid = macid;
    }
    
    public String getSessionkey()
    {
        return sessionkey;
    }
    
    public void setSessionkey(String sessionkey)
    {
        this.sessionkey = sessionkey;
    }
    
    public Boolean getActive()
    {
        return active;
    }
    
    public void setActive(Boolean active)
    {
        this.active = active;
    }
    
    public Boolean getReadOnly()
    {
        return readOnly;
    }
    
    public void setReadOnly(Boolean readOnly)
    {
        this.readOnly = readOnly;
    }
    
    public Boolean getChgGateCharge()
    {
        return chgGateCharge;
    }
    
    public void setChgGateCharge(Boolean chgGateCharge)
    {
        this.chgGateCharge = chgGateCharge;
    }
    
    public Boolean getChgBinLoc()
    {
        return chgBinLoc;
    }
    
    public void setChgBinLoc(Boolean chgBinLoc)
    {
        this.chgBinLoc = chgBinLoc;
    }
    
    public String getChgGridFormat()
    {
        return chgGridFormat;
    }
    
    public void setChgGridFormat(String chgGridFormat)
    {
        this.chgGridFormat = chgGridFormat;
    }
    
    public String getChgFieldProp()
    {
        return chgFieldProp;
    }
    
    public void setChgFieldProp(String chgFieldProp)
    {
        this.chgFieldProp = chgFieldProp;
    }
    
    public String getChgPartyAccount()
    {
        return chgPartyAccount;
    }
    
    public void setChgPartyAccount(String chgPartyAccount)
    {
        this.chgPartyAccount = chgPartyAccount;
    }
    
    public String getCanViewPartyTariff()
    {
        return canViewPartyTariff;
    }
    
    public void setCanViewPartyTariff(String canViewPartyTariff)
    {
        this.canViewPartyTariff = canViewPartyTariff;
    }
    
    public String getCanModifyPartyTariff()
    {
        return canModifyPartyTariff;
    }
    
    public void setCanModifyPartyTariff(String canModifyPartyTariff)
    {
        this.canModifyPartyTariff = canModifyPartyTariff;
    }
    
    public String getCanUnapprInvoice()
    {
        return canUnapprInvoice;
    }
    
    public void setCanUnapprInvoice(String canUnapprInvoice)
    {
        this.canUnapprInvoice = canUnapprInvoice;
    }
    
    public String getCanChangeAfterCompleted()
    {
        return canChangeAfterCompleted;
    }
    
    public void setCanChangeAfterCompleted(String canChangeAfterCompleted)
    {
        this.canChangeAfterCompleted = canChangeAfterCompleted;
    }
    
    public String getSelectByTTCode()
    {
        return selectByTTCode;
    }
    
    public void setSelectByTTCode(String selectByTTCode)
    {
        this.selectByTTCode = selectByTTCode;
    }
    
    public String getCombineConsignee()
    {
        return combineConsignee;
    }
    
    public void setCombineConsignee(String combineConsignee)
    {
        this.combineConsignee = combineConsignee;
    }
    
    public String getAppServerList()
    {
        return appServerList;
    }
    
    public void setAppServerList(String appServerList)
    {
        this.appServerList = appServerList;
    }
    
    public String getReprintReceipt()
    {
        return reprintReceipt;
    }
    
    public void setReprintReceipt(String reprintReceipt)
    {
        this.reprintReceipt = reprintReceipt;
    }
    
    public String getRemark()
    {
        return remark;
    }
    
    public void setRemark(String remark)
    {
        this.remark = remark;
    }
    
    public Date getUpdateDate()
    {
        return updateDate;
    }
    
    public void setUpdateDate(Date updateDate)
    {
        this.updateDate = updateDate;
    }
    
    public String getUpdateUser()
    {
        return updateUser;
    }
    
    public void setUpdateUser(String updateUser)
    {
        this.updateUser = updateUser;
    }
    
    public Date getCreateDate()
    {
        return createDate;
    }
    
    public void setCreateDate(Date createDate)
    {
        this.createDate = createDate;
    }
    
    public String getCreateUser()
    {
        return createUser;
    }
    
    public void setCreateUser(String createUser)
    {
        this.createUser = createUser;
    }
    
    public String getLeadid()
    {
        return leadid;
    }
    
    public void setLeadid(String leadid)
    {
        this.leadid = leadid;
    }
    
    public String getProxyid()
    {
        return proxyid;
    }
    
    public void setProxyid(String proxyid)
    {
        this.proxyid = proxyid;
    }
    
}