package com.mcs.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
// 使用junit4进行测试
@ContextConfiguration(locations = {"classpath*:config/applicationContext.xml"})
// 加载配置文件
public class BaseJunit4Test extends AbstractTransactionalJUnit4SpringContextTests
{
    @Test
    public void runTest()
    {
        System.out.println("test!");
        
    }
}