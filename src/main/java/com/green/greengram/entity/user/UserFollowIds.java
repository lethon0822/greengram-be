package com.green.greengram.entity.user;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Embeddable
@EqualsAndHashCode
// Foreign key 를 걸기 위해서는 Serializable 반드시 implement
public class UserFollowIds implements Serializable {
    private long fromUserId;
    private long toUserId;
}
