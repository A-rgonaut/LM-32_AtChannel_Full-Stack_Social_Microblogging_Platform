package com.unipa.atchannel.service;


import com.unipa.atchannel.dao.PostDao;
import com.unipa.atchannel.dao.UserDao;
import com.unipa.atchannel.dto.PostDto;
import com.unipa.atchannel.model.Post;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class PostService {

    @Autowired
    private PostDao postDao;

    @Autowired
    private UserDao userDao;

    private final ModelMapper modelMapper = new ModelMapper();

    public void addPost(String content, int userId) {

        Post post = new Post();

        post.setDate(new Date());
        post.setContent(content);

        userDao.findById(userId).ifPresent(post::setUser);

        postDao.save(post);

    }

    public PostDto getPost(int postId) {

        Post post = postDao.findById(postId).orElse(null);

        return modelMapper.map(post, PostDto.class);

    }

    public void addLike(int postId) {

        postDao.findById(postId).ifPresent(post -> {
            post.setLikes(post.getLikes() + 1);
            postDao.save(post);
        });

    }
}
