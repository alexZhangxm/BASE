package com.mcs.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @ClassName GenericsUtil
 * @Description:泛型工具类
 * @author zhangxm
 * @date 2016年6月6日 下午6:30:46
 */
public class GenericsUtil
{
    
    /**
     * 通过反射获得定义Class时声明的父类的范型参数的类型
     * 
     * @param clazz
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static Class getSuperClassGenericType(Class clazz)
    {
        return GenericsUtil.getSuperClassGenericType(clazz, 0);
    }
    
    /**
     * 通过反射获得定义Class时声明的父类的范型参数的类型
     * 
     * @param clazz
     * @param index
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static Class getSuperClassGenericType(Class clazz, int index)
    {
        Type genType = clazz.getGenericSuperclass();
        if (!(genType instanceof ParameterizedType))
        {
            return Object.class;
        }
        Type[] params = ((ParameterizedType)genType).getActualTypeArguments();
        if (index >= params.length || index < 0)
        {
            return Object.class;
        }
        if (!(params[index] instanceof Class))
        {
            return Object.class;
        }
        return (Class)params[index];
    }
}
