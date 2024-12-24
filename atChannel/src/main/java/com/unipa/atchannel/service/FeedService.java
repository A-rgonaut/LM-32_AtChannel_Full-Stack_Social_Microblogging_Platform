package com.unipa.atchannel.service;

import com.unipa.atchannel.dao.PostDao;
import com.unipa.atchannel.dto.PostDto;
import com.unipa.atchannel.model.Post;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FeedService {

    @Autowired
    private PostDao postDao;

    private final ModelMapper modelMapper = new ModelMapper();

    public List<PostDto> initFeed(){

        List<Post> listPost = postDao.findFirst4ByOrderByPostIdDesc();
        List<PostDto> listPostDto = new java.util.ArrayList<>();

        for(Post post : listPost)
            listPostDto.add(modelMapper.map(post, PostDto.class));

        return listPostDto;
    }

    public List<PostDto> getFeed(int lastId){

        List<Post> listPost = postDao.findFirst4ByPostIdLessThanOrderByPostIdDesc(lastId);
        List<PostDto> listPostDto = new java.util.ArrayList<>();

        for(Post post : listPost)
            listPostDto.add(modelMapper.map(post, PostDto.class));

        return listPostDto;
    }
}
