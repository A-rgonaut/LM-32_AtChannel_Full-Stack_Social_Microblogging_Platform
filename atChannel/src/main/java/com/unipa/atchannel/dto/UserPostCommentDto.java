package com.unipa.atchannel.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class UserPostCommentDto {

    private int commentId;
    private Date date;
    private String content;
    private String image_path;
    private int likes;
    private int comments;
    private int saves;

    @Override
    public String toString() {
        return "UserPostCommentDto{" +
                "comment_id=" + commentId +
                ", date=" + date +
                ", content='" + content + '\'' +
                ", image_path='" + image_path + '\'' +
                ", likes=" + likes +
                ", comments=" + comments +
                ", saves=" + saves +
                '}';
    }
}
