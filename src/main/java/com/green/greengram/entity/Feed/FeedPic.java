package com.green.greengram.entity.Feed;

import com.green.greengram.entity.CreatedAt;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class FeedPic extends CreatedAt {
    @EmbeddedId
    private FeedPicIds feedPicIds;

    @ManyToOne
    @MapsId("feedId")
    @JoinColumn(name = "feed_id")
    private Feed feed;
}
