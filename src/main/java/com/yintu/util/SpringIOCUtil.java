package com.yintu.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author mlf
 * @version 1.0
 * @date 2020/10/9 13:09
 */
public class SpringIOCUtil {

    public static ApplicationContext init() {
        return new ClassPathXmlApplicationContext("applicationContext.xml");
    }
}
