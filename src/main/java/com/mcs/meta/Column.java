package com.mcs.meta;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName Column
 * @Description:字段映射元数据
 * @author zhangxm
 * @date 2016年6月6日 下午6:09:02
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Column
{
    
    String value();
    
}
