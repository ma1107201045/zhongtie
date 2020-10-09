package com.yintu.zhongtie.repository;

import com.yintu.zhongtie.entity.system.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author mlf
 * @version 1.0
 * @date 2020/10/6 18:23
 */
public interface UserRepository extends JpaRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity> {


}
