package com.yintu;

import com.yintu.zhongtie.entity.system.UserEntity;
import com.yintu.zhongtie.repository.UserRepository;
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
    private UserRepository userRepository;

    @Test
    public void test1() {
        UserEntity userEntity = new UserEntity();
        userEntity.setName("");
        userEntity.setPassword("");
        userEntity = userRepository.save(userEntity);
        userEntity.setName("admin");
        userEntity.setPassword("123456");
        userEntity = userRepository.save(userEntity);
        userRepository.delete(userEntity);
        System.out.println(userRepository.findAll());
    }
}
