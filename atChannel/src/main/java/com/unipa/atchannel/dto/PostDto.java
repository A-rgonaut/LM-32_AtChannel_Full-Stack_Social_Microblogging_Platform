package com.unipa.atchannel.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
public class PostDto {

    private int postId;
    private Date date;
    private String content;
    private String image_path;
    private int likes;
    private int comments;
    private int saves;
    private PostUserDto user;
    private List<PostCommentDto> listComment = new ArrayList<>();

    @Override
    public String toString() {
        return "PostDto{" +
                "post_id=" + postId +
                ", date=" + date +
                ", content='" + content + '\'' +
                ", image_path='" + image_path + '\'' +
                ", likes=" + likes +
                ", comments=" + comments +
                ", saves=" + saves +
                ", user=" + user +
                ", listComment=" + listComment +
                '}';
    }
}
