package com.yintu;

import com.yintu.zhongtie.dao.SystemUserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author mlf
 * @version 1.0
 * @date 2020/10/6 15:19
 */
@RunWith(SpringJUnit4ClassRunner.class) //声明spring提供的单元测试环境
@ContextConfiguration(locations = "classpath:applicationContext.xml")//指定spring容器的配置信息
public class JunitTest {

    @Autowired
    private SystemUserRepository systemUserRepository;

    @Test
    public void test1() {
        System.out.println(systemUserRepository.queryTopByNameAndPassword("admin", "123456"));
    }
}
