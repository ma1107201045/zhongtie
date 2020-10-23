package com.yintu.zhongtie.dao;

import com.yintu.zhongtie.entity.system.SystemUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author mlf
 * @version 1.0
 * @date 2020/10/6 18:23
 */
public interface SystemUserRepository extends JpaRepository<SystemUserEntity, Long>, JpaSpecificationExecutor<SystemUserEntity> {

    SystemUserEntity queryTopByNameAndPassword(String name, String password);

}
