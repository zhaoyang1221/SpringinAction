package com.habuma.restfun;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;

/**
 * @author zhaoyang on 2018/8/15/0015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MagicConfig.class)
public class MagicExistsTest {
    @Autowired
    private ApplicationContext context;

    @BeforeClass
    public static void before() {
        System.setProperty("magic", "True");
    }

    @Test
    public void shouldNotBeNull() {
        System.out.println(System.getProperty("magic"));
        assertTrue(context.containsBean("magicBean"));
    }
}
