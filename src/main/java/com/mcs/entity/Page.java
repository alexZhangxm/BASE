package com.mcs.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import com.mcs.util.StringUtil;

/**
 * @ClassName Page
 * @Description:分页对象
 * @author zhangxm
 * @date 2016年6月8日 下午4:03:14
 */
public class Page implements Serializable
{
    
    private static final long serialVersionUID = 1L;
    
    /**
     * 显示页码个数
     */
    private final int PAGE_COUNT_SHOW = 5;
    
    /**
     * 页码折中点
     */
    private final int PAGE_COUNT_SPLIT = PAGE_COUNT_SHOW / 2 + 1;
    
    /**
     * 当前第几页(页面使用p代替)
     */
    private int pageNo = 1;
    
    /**
     * 每页行数
     */
    private int pageSize = 20;
    
    /**
     * 当前页行数
     */
    private int curSize;
    
    /**
     * 分页函数名称(JSON使用，页码使用fn代替)
     */
    private String pageFn;
    
    /**
     * 分页样式(default|tiny)
     */
    private String pageStyle;
    
    /**
     * 分页参数(JSON使用)
     */
    private String pageArgs;
    
    /**
     * 数据总数
     */
    private int count;
    
    /**
     * 总页数
     */
    private int pageCount;
    
    /**
     * 设置最大页数
     */
    private int maxPageCount;
    
    /**
     * 当前分页数据
     */
    private List<?> data;
    
    /**
     * 当前请求对象
     */
    private String url;
    
    /**
     * 当前请求参数
     */
    private Map<String, String> params;
    
    private Map<String, Object> outParams;
    
    /**
     * 获取数据的起始值
     * 
     * @return
     */
    public int getStart()
    {
        return (getPageNo() - 1) * getPageSize();
    }
    
    /**
     * 获取数据结束值
     * 
     * @return
     */
    public int getEnd()
    {
        return getStart() + getPageSize();
    }
    
    /**
     * 是否还有上一页
     * 
     * @return
     */
    private boolean hasPrevPage()
    {
        return getPageNo() != 1;
    }
    
    /**
     * 是否还有下一页
     * 
     * @return
     */
    private boolean hasNextPage()
    {
        return getCurSize() > getPageSize();
    }
    
    /**
     * 获取分页字符串
     * 
     * @return
     */
    public String getPageStr()
    {
        // 如果没有查询总数，则只显示上一页和下一页
        if (getCount() == 0)
        {
            return getSimpleStr();
        }
        if ("tiny".equals(pageStyle))
        {
            return getTinyStr();
        }
        // 按照页码显示
        return getDetailStr();
    }
    
    /**
     * 获取分页数据(JSON格式)
     * 
     * @return
     */
    public Map<String, Object> getJsonData()
    {
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("pageCount", getPageCount());
        obj.put("data", getData());
        obj.put("pageStr", getPageStr());
        obj.put("count", getCount());
        obj.put("hasMore", hasNextPage());
        if (outParams != null)
        {
            obj.putAll(outParams);
        }
        return obj;
    }
    
    /**
     * 获取简单的分页字符串
     * 
     * @return
     */
    private String getSimpleStr()
    {
        if ((getCurSize() < getPageSize()) && getPageNo() == 1)
        {
            return "";
        }
        StringBuffer items = new StringBuffer();
        if (hasPrevPage())
        {
            items.append("<a class=\"last\" " + getURL(getPageNo() - 1) + ">上一页</a>");
        }
        if (hasNextPage())
        {
            items.append("<a class=\"next\" " + getURL(getPageNo() + 1) + ">下一页</a>");
        }
        return items.toString();
    }
    
    /**
     * 获取详细的分页字符串
     * 
     * @return
     */
    private String getDetailStr()
    {
        if (getPageNo() == 1)
        {
            if (getCurSize() < getPageSize() || getPageSize() >= getCount())
            {
                return "";
            }
        }
        StringBuffer items = new StringBuffer();
        if (hasPrevPage())
        {
            items.append("<a class=\"last\" " + getURL(getPageNo() - 1) + "><span>上一页</span></a>");
        }
        pageCount = getPageCount();
        int start = 1;
        int end = 1;
        if (pageCount <= PAGE_COUNT_SHOW)
        {
            end = pageCount;
        }
        else
        {
            if (getPageNo() <= PAGE_COUNT_SPLIT)
            {
                end = PAGE_COUNT_SHOW;
            }
            else
            {
                start = getPageNo() - (PAGE_COUNT_SHOW - PAGE_COUNT_SPLIT);
                end = start + PAGE_COUNT_SHOW - 1;
                if (end > pageCount)
                {
                    start = pageCount - PAGE_COUNT_SHOW + 1;
                    end = pageCount;
                }
            }
        }
        if (pageCount > PAGE_COUNT_SHOW)
        {
            if (getPageNo() == (PAGE_COUNT_SPLIT + 1))
            {
                items.append("<a " + getURL(1) + ">" + 1 + "</a>");
            }
            else if (getPageNo() > (PAGE_COUNT_SPLIT + 1))
            {
                items.append("<a " + getURL(1) + ">" + 1 + "</a>");
                items.append("<a href=\"javascript:;\" class=\"break\">...</a>");
            }
        }
        for (int i = start; i <= end; i++)
        {
            if (i == getPageNo())
            {
                items.append("<a href=\"javascript:;\" class=\"active\">" + i + "</a>");
            }
            else
            {
                items.append("<a " + getURL(i) + ">" + i + "</a>");
            }
        }
        if (pageCount > PAGE_COUNT_SHOW)
        {
            if ((pageCount - getPageNo()) == PAGE_COUNT_SPLIT)
            {
                items.append("<a " + getURL(pageCount) + ">" + pageCount + "</a>");
            }
            else if ((pageCount - getPageNo()) > PAGE_COUNT_SPLIT)
            {
                items.append("<a href=\"javascript:;\" class=\"break\">...</a>");
                items.append("<a " + getURL(pageCount) + ">" + pageCount + "</a>");
            }
        }
        if (pageCount > getPageNo())
        {
            items.append("<a class=\"next\" " + getURL(getPageNo() + 1) + "><span>下一页</span></a>");
        }
        return items.toString();
    }
    
    private String getTinyStr()
    {
        if (getPageNo() == 1)
        {
            if (getCurSize() < getPageSize() || getPageSize() >= getCount())
            {
                return "";
            }
        }
        StringBuffer items = new StringBuffer();
        if (hasPrevPage())
        {
            items.append("<a class=\"btn15 publicBtn ie6png\" " + getURL(getPageNo() - 1) + ">上一页</a>");
        }
        items.append("<span class=\"lgrey ml10 mr10\">" + getPageNo() + "/" + getPageCount() + "</span>");
        if (hasNextPage())
        {
            items.append("<a class=\"btn15 publicBtn ie6png\" " + getURL(getPageNo() + 1) + ">下一页</a>");
        }
        return items.toString();
    }
    
    /**
     * 获取分页地址
     * 
     * @param pageNo 当前页数
     * @return
     */
    public String getURL(int pageNo)
    {
        // 分页函数不为空表示JSON分页
        if (pageFn != null)
        {
            String fn = pageFn + "(" + pageNo;
            if (pageArgs != null)
            {
                fn += "," + pageArgs;
            }
            fn += ")";
            return "href=\"javascript:;\" onclick=\"" + fn + "\"";
        }
        String href = null;
        params.remove("p");
        if (params.size() == 0)
        {
            href = url + "?p=" + pageNo;
        }
        else
        {
            href = url + "?" + getParamsStr(params) + "p=" + pageNo;
        }
        return "href=\"" + href + "\"";
    }
    
    /**
     * 获取分页查询参数
     * 
     * @param params
     * @return
     */
    private String getParamsStr(Map<String, String> params)
    {
        Iterator<String> it = params.keySet().iterator();
        String pstr = "";
        String key = null;
        String value = null;
        try
        {
            while (it.hasNext())
            {
                key = it.next();
                value = StringUtil.encodeURI(StringUtils.trimToEmpty(params.get(key)));
                pstr += key + "=" + value + "&";
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return pstr;
    }
    
    public int getPageCount()
    {
        if (count % pageSize == 0)
        {
            pageCount = count / pageSize;
        }
        else
        {
            pageCount = count / pageSize + 1;
        }
        if (maxPageCount != 0 && pageCount > maxPageCount)
        {
            pageCount = maxPageCount;
        }
        return pageCount;
    }
    
    public void setPageCount(int pageCount)
    {
        this.pageCount = pageCount;
    }
    
    @SuppressWarnings("unchecked")
    public <T> List<T> getData()
    {
        if (data == null)
        {
            data = new ArrayList<Object>();
        }
        return (List<T>)data;
    }
    
    /**
     * 设置集合数据(分页使用)
     * 
     * @param data
     */
    public void setData(List<?> data)
    {
        setData(data, true);
    }
    
    /**
     * 设置集合数据(分页使用)
     * 
     * @param data
     * @param isTotalQuery
     */
    public void setData(List<?> data, boolean isTotalQuery)
    {
        this.curSize = data.size();
        if (!isTotalQuery)
        {
            if (curSize > getPageSize())
            {
                data.remove(curSize - 1);
            }
        }
        this.data = data;
    }
    
    /**
     * 需要改变集合中的值时，请使用该方法
     * 
     * @param data
     */
    public void setResult(List<?> data)
    {
        this.data = data;
    }
    
    public void setUrl(String url)
    {
        this.url = url;
    }
    
    public void setParams(Map<String, String> params)
    {
        if (params != null)
        {
            this.pageNo = NumberUtils.toInt(params.get("p"), 1);
            this.pageFn = params.get("fn");
        }
        this.params = params;
    }
    
    /**
     * 添加输出参数
     * 
     * @param key 参数名称不能为：pageCount、data、pageStr、count
     * @param value
     */
    public void addParameter(String key, Object value)
    {
        if (outParams == null)
        {
            outParams = new HashMap<String, Object>();
        }
        outParams.put(key, value);
    }
    
    public int getPageNo()
    {
        return pageNo;
    }
    
    public void setPageNo(int pageNo)
    {
        this.pageNo = pageNo;
    }
    
    public int getPageSize()
    {
        return pageSize;
    }
    
    public void setPageSize(int pageSize)
    {
        this.pageSize = pageSize;
    }
    
    public int getCurSize()
    {
        return curSize;
    }
    
    public void setCurSize(int curSize)
    {
        this.curSize = curSize;
    }
    
    public String getPageFn()
    {
        return pageFn;
    }
    
    public void setPageFn(String pageFn)
    {
        this.pageFn = pageFn;
    }
    
    public String getPageStyle()
    {
        return pageStyle;
    }
    
    public void setPageStyle(String pageStyle)
    {
        this.pageStyle = pageStyle;
    }
    
    public String getPageArgs()
    {
        return pageArgs;
    }
    
    public void setPageArgs(String pageArgs)
    {
        this.pageArgs = pageArgs;
    }
    
    public int getCount()
    {
        return count;
    }
    
    public void setCount(int count)
    {
        this.count = count;
    }
    
    public int getMaxPageCount()
    {
        return maxPageCount;
    }
    
    public void setMaxPageCount(int maxPageCount)
    {
        this.maxPageCount = maxPageCount;
    }
    
}
