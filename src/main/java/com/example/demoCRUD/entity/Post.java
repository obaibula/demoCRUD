package com.example.demoCRUD.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;

@Entity
@Table(name = "posts")
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "user")
@EqualsAndHashCode
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "created_at")
    private OffsetDateTime createdAt;

    @Column(name = "updated_at")
    private OffsetDateTime  updatedAt;

    @Column(name = "url", nullable = false)
    private String url;

    @Column(name = "caption")
    private String caption;

    @Column(name = "lat")
    private Double lat;

    @Column(name = "lng")
    private Double lng;


    //todo: correct and test this 2-way relationship
    @JsonBackReference
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private User user;

    public Post(OffsetDateTime  createdAt, OffsetDateTime  updatedAt, String url, String caption, Double lat, Double lng) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.url = url;
        this.caption = caption;
        this.lat = lat;
        this.lng = lng;
    }
}
