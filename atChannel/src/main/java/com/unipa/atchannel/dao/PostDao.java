package com.unipa.atchannel.dao;

import com.unipa.atchannel.model.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostDao extends CrudRepository<Post, Integer> {
    List<Post> findFirst4ByOrderByPostIdDesc();
    List<Post> findFirst4ByPostIdLessThanOrderByPostIdDesc(int postId);
}