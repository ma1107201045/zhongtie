package com.yintu.zhongtie.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author mlf
 * @version 1.0
 * @date 2020/10/9 17:53
 */
public class SpringIOCUtil {


    public static ApplicationContext init() {
        return new ClassPathXmlApplicationContext("applicationContext.xml");
    }


}
