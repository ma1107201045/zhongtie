package com.yintu.zhongtie.entity.system;

import com.yintu.zhongtie.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author mlf
 * @version 1.0
 * @date 2020/10/6 15:46
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "system_user")
public class SystemUserEntity extends BaseEntity {
    private static final long serialVersionUID = -4400567447315830842L;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 20, nullable = false)
    private String password;

    @Column(name = "true_name", length = 20)
    private String trueName;

    @Column(length = 20)
    private String phone;

    @Column(length = 20)
    private String email;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "system_user_role", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private List<SystemRoleEntity> roleEntities;

}
