package com.yintu.zhongtie.entity.system;

import com.yintu.zhongtie.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;

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
@Table(name = "system_user_role")
public class SystemUserRoleEntity extends BaseEntity {
    private static final long serialVersionUID = 5089958281963455789L;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private SystemUserEntity userEntity;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", nullable = false)
    private SystemRoleEntity roleEntity;
}
