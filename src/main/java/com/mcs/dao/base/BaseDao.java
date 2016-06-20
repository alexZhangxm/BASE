package com.mcs.dao.base;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

import com.mcs.entity.Page;
import com.mcs.meta.Column;
import com.mcs.util.GenericsUtil;
import com.mcs.util.ReflectUtil;

/**
 * @ClassName BaseDao
 * @Description:数据处理基类
 * @author zhangxm
 * @param <T>
 * @date 2016年6月6日 下午5:40:45
 */
public class BaseDao<T>
{
    
    @Resource
    private JdbcDao jdbcDao;
    
    private Map<String, PropertyMeta> result;
    
    protected Class<T> entityClass;
    
    private boolean needLoad = false;
    
    @SuppressWarnings("unchecked")
    public BaseDao()
    {
        needLoad = this.getClass().getName().indexOf("CGLIB") == -1;
        if (!needLoad)
        {
            return;
        }
        entityClass = GenericsUtil.getSuperClassGenericType(getClass());
        getResultMap();
    }
    
    /**
     * 获取当前类属性与字段映射关系
     * 
     * @return
     */
    private Map<String, PropertyMeta> getResultMap()
    {
        if (result != null)
        {
            return result;
        }
        Field[] fields = entityClass.getDeclaredFields();
        result = new HashMap<String, PropertyMeta>();
        Column column = null;
        PropertyMeta property = null;
        Method method = null;
        DataType dataType = null;
        for (Field field : fields)
        {
            dataType = ReflectUtil.getDataType(field);
            if (dataType == null)
            {
                continue;
            }
            method = ReflectUtil.getMethod(entityClass, field);
            if (method == null)
            {
                continue;
            }
            property = new PropertyMeta(dataType, field, method);
            if (field.isAnnotationPresent(Column.class))
            {
                column = field.getAnnotation(Column.class);
                result.put(column.value(), property);
            }
            else
            {
                result.put(field.getName(), property);
            }
        }
        return result;
    }
    
    /**
     * 获取T类型数据列表基础方法
     *
     * @param rowMapper 结果映射对象
     * @param sql SQL
     * @param params 参数列表
     * @return
     * @throws Exception
     */
    private List<T> find(RowMapper<T> rowMapper, String sql, Object... params)
        throws Exception
    {
        return jdbcDao.getJdbcTemplate().query(sql, rowMapper, params);
    }
    
    /**
     * 获取V类型集合(只查询一个字段)基础方法
     * 
     * @param sql SQL
     * @param dataType 数据类型枚举
     * @param params 参数列表
     * @return
     */
    private <V> List<V> findObject(String sql, final DataType dataType, Object... params)
        throws Exception
    {
        RowMapper<V> rowMapper = new RowMapper<V>()
        {
            @SuppressWarnings("unchecked")
            public V mapRow(ResultSet rs, int i)
                throws SQLException
            {
                Object value = null;
                switch (dataType)
                {
                    case STRING:
                        value = rs.getString(1);
                        break;
                    case INT:
                        value = rs.getInt(1);
                        break;
                    case LONG:
                        value = rs.getLong(1);
                        break;
                    case DOUBLE:
                        value = rs.getDouble(1);
                        break;
                    case FLOAT:
                        value = rs.getFloat(1);
                        break;
                    default:
                        value = rs.getObject(1);
                        break;
                }
                return (V)value;
            }
        };
        return jdbcDao.getJdbcTemplate().query(sql, rowMapper, params);
    }
    
    /**
     * 获取T类型数据列表
     * 
     * @param sql SQL
     * @param params 参数列表
     * @return
     * @throws Exception
     */
    protected List<T> findObjects(String sql, Object... params)
        throws Exception
    {
        return find(new BaseRowMapper<T>(entityClass, getResultMap()), sql, params);
    }
    
    /**
     * 获取T类型数据
     * 
     * @param sql SQL
     * @param params 参数列表
     * @return
     * @throws Exception
     */
    protected T getObject(String sql, Object... params)
        throws Exception
    {
        List<T> list = findObjects(sql, params);
        if (list.size() > 0)
        {
            return list.get(0);
        }
        return null;
    }
    
    /**
     * 获取字符串集合(只查询一个字段)
     * 
     * @param sql SQL
     * @param params 参数列表
     * @return
     * @throws Exception
     */
    protected List<String> findObject(String sql, Object... params)
        throws Exception
    {
        return findObject(sql, DataType.STRING, params);
    }
    
    /**
     * 新增、修改、删除
     * 
     * @param sql SQL
     * @param params 参数列表
     * @throws Exception
     */
    protected int execute(String sql, Object... params)
        throws Exception
    {
        return jdbcDao.getJdbcTemplate().update(sql, params);
    }
    
    /**
     * 批量新增、修改、删除
     * 
     * @param sql SQL
     * @param pss 批量参数对象
     * @return
     * @throws Exception
     */
    protected int[] batchExecute(String sql, BatchPreparedStatementSetter pss)
        throws Exception
    {
        return jdbcDao.getJdbcTemplate().batchUpdate(sql, pss);
    }
    
    /**
     * 获取数量
     * 
     * @param sql SQL
     * @param params 参数列表
     * @return
     * @throws Exception
     */
    protected int getCount(String sql, Object... params)
        throws Exception
    {
        List<Integer> list = findObject(sql, DataType.INT, params);
        if (list.size() > 0)
        {
            return list.get(0);
        }
        return 0;
    }
    
    /**
     * 分页查询 基础方法
     * 
     * @param rowMapper 结果映射对象
     * @param sql SQL
     * @param page 分页对象
     * @param params 参数列表
     * @return
     * @throws Exception
     */
    private Page pageQuery(RowMapper<T> rowMapper, String sql, Page page, Object... params)
        throws Exception
    {
        sql = sql + " LIMIT " + page.getStart() + "," + page.getPageSize() + 1;// getPageSql(sql, page);
        List<T> list = jdbcDao.getJdbcTemplate().query(sql, rowMapper, params);
        page.setData(list, false);
        return page;
    }
    
    /**
     * 去掉SQL语句中的order by
     * 
     * @param sql SQL语句
     * @return
     */
    private String removeOrders(String sql)
    {
        String regex = "order\\s*by[\\w|\\W|\\s|\\S]*";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(sql);
        StringBuffer buf = new StringBuffer();
        while (matcher.find())
        {
            matcher.appendReplacement(buf, "");
        }
        matcher.appendTail(buf);
        return buf.toString();
    }
    
    /**
     * 分页查询
     * 
     * @param sql SQL
     * @param page 分页对象
     * @param params 参数列表
     * @return
     * @throws Exception
     */
    protected Page pageQuery(String sql, Page page, Object... params)
        throws Exception
    {
        return pageQuery(new BaseRowMapper<T>(entityClass, getResultMap()), sql, page, params);
    }
    
    /**
     * 分页查询(包含总页数)基础方法
     * 
     * @param rowMapper 结果映射对象
     * @param sql SQL
     * @param page 分页对象
     * @param params 参数列表
     * @return
     * @throws Exception
     */
    @SuppressWarnings("deprecation")
    private Page pageTotalQuery(RowMapper<T> rowMapper, String sql, Page page, Object... params)
        throws Exception
    {
        StringBuilder buf = new StringBuilder();
        buf.append("SELECT COUNT(1) TOTALNUM FROM ( ");
        buf.append(removeOrders(sql));
        buf.append(" ) T ");
        int count = jdbcDao.getJdbcTemplate().queryForInt(buf.toString(), params);
        
        sql = sql + " LIMIT " + page.getStart() + "," + page.getPageSize() + 1;
        List<T> list = jdbcDao.getJdbcTemplate().query(sql, rowMapper, params);
        page.setData(list, false);
        page.setCount(count);
        return page;
    }
    
    /**
     * 分页查询(包含总页数)
     * 
     * @param sql SQL
     * @param page 分页对象
     * @param params 参数列表
     * @return
     * @throws Exception
     */
    protected Page pageTotalQuery(String sql, Page page, Object... params)
        throws Exception
    {
        return pageTotalQuery(new BaseRowMapper<T>(entityClass, getResultMap()), sql, page, params);
    }
    
}
