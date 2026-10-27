package tech.vivek.margatsni.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

@Embeddable
public class FollowerFollowee {
    private AppUser follower;
    private AppUser followee;

    public FollowerFollowee() {}
    public FollowerFollowee(AppUser follower, AppUser followee) {
        this.follower = follower;
        this.followee = followee;
    }

    public AppUser getFollower() {
        return follower;
    }

    public void setFollower(AppUser follower) {
        this.follower = follower;
    }

    public AppUser getFollowee() {
        return followee;
    }

    public void setFollowee(AppUser followee) {
        this.followee = followee;
    }
}
