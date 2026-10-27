package tech.vivek.margatsni.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
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
