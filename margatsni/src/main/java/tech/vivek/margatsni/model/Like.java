package tech.vivek.margatsni.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "likes")
public class Like {

    @EmbeddedId
    private LikeUserPost userPost;

    public Like() {}

    public Like(AppUser appUser, Post post) {
        userPost = new LikeUserPost(appUser, post);
    }

    public AppUser getUser(){
        return userPost.getLiker();
    }

    public Post getPost(){
        return userPost.getPost();
    }
}