package tech.vivek.margatsni.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private AppUser owner;

    @Column(nullable = false)
    private String imageUrl;

    private String caption;

    public Post() {}

    public Post(AppUser owner, String imageUrl, String caption) {
        this.owner = owner;
        this.imageUrl = imageUrl;
        this.caption = caption;
    }

    public UUID getId() {
        return id;
    }

    public AppUser getOwner() {
        return owner;
    }

    public void setOwner(AppUser owner) {
        this.owner = owner;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}
