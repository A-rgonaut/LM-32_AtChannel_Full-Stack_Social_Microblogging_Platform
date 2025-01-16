package com.unipa.atchannel.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
public class User {

    @Id
    @Column(name = "user_id")
    private int userId;
    private String firstname;
    private String lastname;
    private String email;
    private String username;
    private String nametag;
    private String pic_path;
    private String cover_path;
    private int follower;
    private int following;

    @OneToMany(
            cascade = CascadeType.REFRESH,
            fetch = FetchType.EAGER,
            mappedBy = "user",
            orphanRemoval = true
    )
    private List<Post> listPost = new ArrayList<>();

    @OneToMany(
            cascade = CascadeType.REFRESH,
            fetch = FetchType.EAGER,
            mappedBy = "user",
            orphanRemoval = true
    )
    private List<Comment> listComment = new ArrayList<>();

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + userId +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", nametag='" + nametag + '\'' +
                ", pic_path='" + pic_path + '\'' +
                ", cover_path='" + cover_path + '\'' +
                ", follower=" + follower +
                ", following=" + following +
                '}';
    }
}
