package com.example.demoCRUD.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "posts")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "created_at")
    private ZonedDateTime createdAt;

    @Column(name = "updated_at")
    private ZonedDateTime updatedAt;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "bio")
    private String bio;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Post> posts = new ArrayList<>();


    public User(ZonedDateTime createdAt, ZonedDateTime updatedAt, String username, String bio, String avatar, String phone, String email, String password) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.username = username;
        this.bio = bio;
        this.avatar = avatar;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    public void add(Post post){
        if(posts == null){
            posts = new ArrayList<>();
        }
        posts.add(post);
        post.setUser(this);
    }
}
