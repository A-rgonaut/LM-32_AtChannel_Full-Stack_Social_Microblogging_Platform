package com.unipa.atchannel.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "post_id")
    private int postId;
    private Date date;
    private String content;
    private String image_path;
    private int likes;
    private int comments;
    private int saves;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @OneToMany(
            cascade = CascadeType.REFRESH,
            fetch = FetchType.EAGER,
            mappedBy = "post",
            orphanRemoval = true
    )
    private List<Comment> listComment = new ArrayList<>();

    @Override
    public String toString() {
        return "Post{" +
                "post_id=" + postId +
                ", date=" + date +
                ", content='" + content + '\'' +
                ", image_path='" + image_path + '\'' +
                ", likes=" + likes +
                ", comments=" + comments +
                ", saves=" + saves +
                '}';
    }
}
