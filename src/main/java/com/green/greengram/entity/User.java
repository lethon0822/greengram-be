package com.green.greengram.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

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
    private int pic;

    @Column(nullable = false, length = 100)
    private int upw;

}
