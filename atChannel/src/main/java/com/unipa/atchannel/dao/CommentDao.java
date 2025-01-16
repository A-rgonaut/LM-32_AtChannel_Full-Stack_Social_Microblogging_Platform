package com.unipa.atchannel.dao;

import com.unipa.atchannel.model.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentDao extends CrudRepository<Comment, Integer> {
}
