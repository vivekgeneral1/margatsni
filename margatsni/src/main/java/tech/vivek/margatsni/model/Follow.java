package tech.vivek.margatsni.model;

import jakarta.persistence.CheckConstraint;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(
        name = "follow",
        check = @CheckConstraint(name = "disallow_self_follow", constraint = "follow.follower_id <> follow.followee_id")
)
public class Follow {

    @EmbeddedId
    private FollowerFollowee followerFollowee;

    public Follow() {}

    public Follow(AppUser follower, AppUser followee) {
        this.followerFollowee = new FollowerFollowee(follower, followee);
    }

    public AppUser getFollower(){
        return followerFollowee.getFollower();
    }

    public AppUser getFollowee(){
        return followerFollowee.getFollowee();
    }
}
