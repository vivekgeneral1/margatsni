package tech.vivek.margatsni.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class LikeUserPost {

    @ManyToOne
    @JoinColumn(name = "liker_id")
    private AppUser liker;

    @ManyToOne
    @JoinColumn(name = "post_id")
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
