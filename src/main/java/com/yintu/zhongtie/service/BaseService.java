package com.yintu.zhongtie.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.io.Serializable;
import java.util.List;

/**
 * @author mlf
 * @version 1.0
 * @date 2020/10/23 18:15
 */
public interface BaseService<T extends Serializable, PK extends Serializable> {
    void add(T entity);

    void remove(PK id);

    void edit(T entity);

    T findById(PK id);

    Page<T> findAll(Specification<T> specification, Pageable pageable);

    List<T> findAll(Specification<T> specification, Sort sort);

}
