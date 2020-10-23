package com.yintu.zhongtie.entity.system;

import com.yintu.zhongtie.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author mlf
 * @version 1.0
 * @date 2020/10/6 19:04
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "system_role")
public class SystemRoleEntity extends BaseEntity {
    private static final long serialVersionUID = -9078958344590204555L;

    @Column(length = 20, nullable = false)
    private String name;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "system_user_role", joinColumns = {@JoinColumn(name = "role_id")}, inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private List<SystemUserEntity> userEntities;

}
