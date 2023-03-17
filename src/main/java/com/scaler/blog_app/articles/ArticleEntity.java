package com.scaler.blog_app.articles;

import com.scaler.blog_app.comments.CommentEntity;
import com.scaler.blog_app.common.BaseEntity;
import com.scaler.blog_app.user.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity(name = "articles")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ArticleEntity extends BaseEntity {

    @Column(name = "title", nullable = false, length = 100)
    String title;

    @Column(name = "slug", nullable = false, unique = true)
    String slug;

    @Column(name = "subtitle", length = 150)
    String subtitle;

    @Column(name = "body", columnDefinition = "TEXT")
    String body;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    UserEntity author;

    @ManyToMany(fetch=FetchType.EAGER)
            @JoinTable(
                    name = "likes",
                    joinColumns = @JoinColumn(name = "article_id"),
                    inverseJoinColumns = @JoinColumn(name = "user_id")
            )
    Set<UserEntity> likers;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Set<CommentEntity> comments;
}
