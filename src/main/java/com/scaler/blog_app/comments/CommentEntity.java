package com.scaler.blog_app.comments;

import com.scaler.blog_app.articles.ArticleEntity;
import com.scaler.blog_app.common.BaseEntity;
import com.scaler.blog_app.user.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "comments")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CommentEntity extends BaseEntity {

    @Column(name = "title", nullable = false, length = 100)
    String title;

    @Column(name = "body", columnDefinition = "TEXT")
    String body;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    UserEntity author;

    @ManyToOne
            @JoinColumn(name = "article_id", nullable = false)
    ArticleEntity article;

}
