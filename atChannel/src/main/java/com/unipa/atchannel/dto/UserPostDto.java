package com.unipa.atchannel.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Setter
@Getter
public class UserPostDto {

    private int postId;
    private Date date;
    private String content;
    private String image_path;
    private int likes;
    private int comments;
    private int saves;
    private int user_id;
    private List<UserPostCommentDto> listComment;

    @Override
    public String toString() {
        return "UserPostDto{" +
                "id=" + postId +
                ", date=" + date +
                ", content='" + content + '\'' +
                ", image_path='" + image_path + '\'' +
                ", likes=" + likes +
                ", comments=" + comments +
                ", saves=" + saves +
                ", user_id=" + user_id +
                ", listComment=" + listComment +
                '}';
    }
}
