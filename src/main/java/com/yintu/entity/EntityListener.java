package com.yintu.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.Date;

/**
 * @author mlf
 * @version 1.0
 * @date 2020/10/7 18:45
 */
public class EntityListener {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PrePersist
    public void prePersist(BaseEntity baseEntity) {
        logger.info("prePersist.................");
        baseEntity.setCreatedBy("");
        baseEntity.setCreatedTime(new Date());
        baseEntity.setModifiedBy("");
        baseEntity.setModifiedTime(baseEntity.getCreatedTime());
    }

    @PreUpdate
    public void preUpdate(BaseEntity baseEntity) {
        logger.info("preUpdate.................");
        baseEntity.setModifiedBy("");
        baseEntity.setModifiedTime(new Date());
    }

    @PreRemove
    public void preRemove(BaseEntity baseEntity) {
        logger.info("preRemove.................");
    }


    @PostLoad
    public void postLoad(Object o) {
        logger.info("postLoad.................");
    }

    @PostRemove
    public void postRemove(Object o) {
        logger.info("postRemove.................");
    }

    @PostUpdate
    public void postUpdate(Object o) {
        logger.info("postUpdate.................");
    }

    @PostPersist
    public void postPersist(Object o) {
        logger.info("postPersist.................");
    }
}
