package com.green.greengram.entity.Feed;

import com.green.greengram.entity.UpdatedAt;
import com.green.greengram.entity.user.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Feed extends UpdatedAt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long feedId;

    @Column(nullable = true, length = 30)
    private String location;

    @Column(nullable = true, length = 1000)
    private String contents;

    // 관계 설정
    @ManyToOne
    @JoinColumn(name = "writer_user_id", nullable = false)
    private User writerUser;
}
