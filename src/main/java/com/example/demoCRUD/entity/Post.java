package com.example.demoCRUD.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "posts")
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "user")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "created_at")
    private ZonedDateTime createdAt;

    @Column(name = "updated_at")
    private ZonedDateTime updatedAt;

    @Column(name = "url", nullable = false)
    private String url;

    @Column(name = "caption")
    private String caption;

    @Column(name = "lat")
    private Double lat;

    @Column(name = "lng")
    private Double lng;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    public Post(ZonedDateTime createdAt, ZonedDateTime updatedAt, String url, String caption, Double lat, Double lng) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.url = url;
        this.caption = caption;
        this.lat = lat;
        this.lng = lng;
    }
}
