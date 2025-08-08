package com.green.greengram.entity.user;

import com.green.greengram.config.enumcode.EnumUserRole;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@EqualsAndHashCode
public class UserRoleIds implements Serializable {
    private long userId;
    @Column(length = 2)
    private EnumUserRole roleCode;
}
