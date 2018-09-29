package com.xzy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

/**
 * @author zhaoyang on 2018/9/4/0004.
 */

public class ScopedBeanTests {

    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration(classes = ComponentScannedConfig.class)
    public static class ComponentScannedScopedBeanTest {

        @Autowired
        private ApplicationContext context;

        @Test
        public void testProxyScope() {
//          notepad bean添加了scope注解，声明为原型bean。每次从context得到该bean时，都会创建新的实例
            Notepad notepad1 = context.getBean(Notepad.class);
            Notepad notepad2 = context.getBean(Notepad.class);
            assertNotSame(notepad1, notepad2); //两个实例不一样
        }

        @Test
        public void testSingletonScope() {
//          默认是单例的bean，所以这里是一样的
            UniqueThing thing1 = context.getBean(UniqueThing.class);
            UniqueThing thing2 = context.getBean(UniqueThing.class);
            assertSame(thing1, thing2);
        }
    }
}
