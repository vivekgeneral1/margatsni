package tech.vivek.margatsni.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LikeUserPost that = (LikeUserPost) o;
        return Objects.equals(liker, that.liker) && Objects.equals(post, that.post);
    }

    @Override
    public int hashCode() {
        return Objects.hash(liker, post);
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
