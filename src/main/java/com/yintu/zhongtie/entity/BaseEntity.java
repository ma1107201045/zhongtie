package com.yintu.zhongtie.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author mlf
 * @version 1.0
 * @date 2020/10/6 15:48
 */
@Data
@NoArgsConstructor
@MappedSuperclass
@EntityListeners(EntityListener.class)
public abstract class BaseEntity implements Serializable {
    private static final long serialVersionUID = 2787806455801319271L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    protected Long id;
    @CreatedBy
    @Column(name = "created_by", nullable = false)
    protected String createdBy;

    @CreatedDate
    @Column(name = "created_time", nullable = false)
    protected Date createdTime;

    @LastModifiedBy
    @Column(name = "modified_by", nullable = false)
    protected String modifiedBy;

    @LastModifiedDate
    @Column(name = "modified_time", nullable = false)
    protected Date modifiedTime;


}
