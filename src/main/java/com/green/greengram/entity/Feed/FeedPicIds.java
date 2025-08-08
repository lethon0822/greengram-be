package com.green.greengram.entity.Feed;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@EqualsAndHashCode
public class FeedPicIds implements Serializable {
    private long feedId;

    @Column(nullable = false, length = 50)
    private String pic;
}
