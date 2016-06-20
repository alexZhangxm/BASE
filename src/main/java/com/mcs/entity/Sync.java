package com.mcs.entity;

import java.io.Serializable;
import java.util.Date;

import com.mcs.meta.Column;
import com.mcs.util.DateUtil;

/**
 * @ClassName Sync
 * @Description
 * @author zhangxm
 * @date 2016年6月12日 上午10:12:12
 */
public class Sync implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 7240255317235036662L;
    
    @Column("userId")
    private String userId;
    
    @Column("token")
    private String token;
    
    @Column("createDate")
    private Date createDate;
    
    public String getUserId()
    {
        return userId;
    }
    
    public void setUserId(String userId)
    {
        this.userId = userId;
    }
    
    public String getToken()
    {
        return token;
    }
    
    public void setToken(String token)
    {
        this.token = token;
    }
    
    public Date getCreateDate()
    {
        return createDate;
    }
    
    public void setCreateDate(Date createDate)
    {
        this.createDate = createDate;
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
