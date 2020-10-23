package com.yintu.zhongtie.service.system.impl;

import com.yintu.zhongtie.dao.SystemUserRepository;
import com.yintu.zhongtie.entity.system.SystemUserEntity;
import com.yintu.zhongtie.service.system.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author mlf
 * @version 1.0
 * @date 2020/10/23 18:13
 */
@Service
@Transactional
public class SystemUserServiceImpl implements SystemUserService {
    @Autowired
    private SystemUserRepository systemUserRepository;

    @Override
    public void add(SystemUserEntity entity) {
        systemUserRepository.save(entity);
    }

    @Override
    public void remove(Long id) {
        systemUserRepository.deleteById(id);
    }

    @Override
    public void edit(SystemUserEntity entity) {
        systemUserRepository.save(entity);
    }

    @Override
    public SystemUserEntity findById(Long id) {
        Optional<SystemUserEntity> optional = systemUserRepository.findById(id);
        return optional.orElse(new SystemUserEntity());
    }

    @Override
    public Page<SystemUserEntity> findAll(Specification<SystemUserEntity> specification, Pageable pageable) {
        return systemUserRepository.findAll(specification, pageable);
    }

    @Override
    public List<SystemUserEntity> findAll(Specification<SystemUserEntity> specification, Sort sort) {
        return systemUserRepository.findAll(specification, sort);
    }

    @Override
    public SystemUserEntity findByNameAndPassword(String name, String password) {
        return systemUserRepository.queryTopByNameAndPassword(name, password);
    }
}
