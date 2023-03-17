package com.scaler.blog_app.user;

import com.scaler.blog_app.articles.ArticleEntity;
import com.scaler.blog_app.common.BaseEntity;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserEntity extends BaseEntity {

    @Column(name = "username", nullable = false, unique = true)
    String username;

    @Column(name = "password", nullable = false)
    String password;

    @Column(name = "email", nullable = false, unique = true)
    String email;

    @Nullable
    String bio;

    @Nullable
    String image;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Set<ArticleEntity> articles;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "likers")
    Set<ArticleEntity> likedArticles;

    @ManyToMany(fetch = FetchType.LAZY)
            @JoinTable(
                    name = "followers",
                    joinColumns = @JoinColumn(name = "following_id"),
                    inverseJoinColumns = @JoinColumn(name = "follower_id")
            )
    Set<UserEntity> followers;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "followers")
    Set<UserEntity> following;

}
