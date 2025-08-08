package com.green.greengram.entity.user;

import com.green.greengram.config.enumcode.EnumUserRole;
import com.green.greengram.entity.UpdatedAt;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@EqualsAndHashCode
@Table(
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = { "uid" }
                )
        }
)
public class User extends UpdatedAt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = true, length = 30)
    private String nickName;

    @Column(nullable = false, length = 50)
    private String uid;

    @Column(nullable = true, length = 100)
    private String pic;

    @Column(nullable = false, length = 100)
    private String upw;

    // 관계 설정을 하지 않아도 되는 곳에 mappedBy 작성
    // cascade는 자식과 나랑 모두 연결 (내가 영속성이면 자식도 영속성, 내가 삭제되면 자식도 삭제)
    // orphanRemoval은 userRole에서 자식을 하나 제거 시, DB에도 삭제되어 반영됨
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserRole> userRole = new ArrayList<>(1);

    public void addUserRoles(List<EnumUserRole> enumUserRole) {
        for(EnumUserRole e : enumUserRole){
            UserRoleIds ids = new UserRoleIds(this.userId, e);
            UserRole userRole = new UserRole(ids, this);

            this.userRole.add(userRole);
        }
    }
}

