package tech.vivek.margatsni.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(
        indexes = @Index(name = "post_index", columnList = "post_id")
)
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private AppUser commenter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    private Comment parentComment;

    @Column(nullable = false)
    private String text;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    public Comment() {}

    public Comment(AppUser commenter, Post post, Comment parentComment, String text) {
        this.commenter = commenter;
        this.post = post;
        this.parentComment = parentComment;
        this.text = text;
    }

    public UUID getId() {
        return id;
    }

    public AppUser getCommenter() {
        return commenter;
    }

    public void setCommenter(AppUser commenter) {
        this.commenter = commenter;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Comment getParentComment() {
        return parentComment;
    }

    public void setParentComment(Comment parentComment) {
        this.parentComment = parentComment;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
