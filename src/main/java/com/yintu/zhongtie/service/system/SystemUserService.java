package com.yintu.zhongtie.service.system;

import com.yintu.zhongtie.entity.system.SystemUserEntity;
import com.yintu.zhongtie.service.BaseService;

/**
 * @author mlf
 * @version 1.0
 * @date 2020/10/23 18:13
 */
public interface SystemUserService extends BaseService<SystemUserEntity, Long> {
    /**
     * @param name     用户名
     * @param password 密码
     * @return
     */
    SystemUserEntity findByNameAndPassword(String name, String password);
}
