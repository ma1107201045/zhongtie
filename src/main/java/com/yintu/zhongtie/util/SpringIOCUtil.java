package com.yintu.zhongtie.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author mlf
 * @version 1.0
 * @date 2020/10/9 17:53
 */
public class SpringIOCUtil {

    private static ApplicationContext applicationContext;

    public static void init() {
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }


}
