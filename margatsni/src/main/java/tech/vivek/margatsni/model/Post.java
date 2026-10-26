package tech.vivek.margatsni.model;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.UUID;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    private AppUser owner;

    private String imageUrl;

    private String caption;

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
