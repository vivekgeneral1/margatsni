package tech.vivek.margatsni.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class LikeUserPost {
    private AppUser liker;
    private Post post;

    public LikeUserPost() {}

    public LikeUserPost(AppUser liker, Post post) {
        this.liker = liker;
        this.post = post;
    }

    public AppUser getLiker() {
        return liker;
    }

    public void setLiker(AppUser liker) {
        this.liker = liker;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
