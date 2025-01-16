package com.unipa.atchannel.service;


import com.unipa.atchannel.dao.CommentDao;
import com.unipa.atchannel.dao.PostDao;
import com.unipa.atchannel.dao.UserDao;
import com.unipa.atchannel.model.Comment;
import com.unipa.atchannel.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class CommentService {

    @Autowired
    private PostDao postDao;

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private UserDao userDao;

    public void addComment(String content, int userId, int postId) {

        Comment comment = new Comment();

        comment.setDate(new Date());
        comment.setContent(content);
        userDao.findById(userId).ifPresent(comment::setUser);
        postDao.findById(postId).ifPresent(comment::setPost);

        Post post = comment.getPost();
        post.setComments(post.getComments() + 1);

        postDao.save(post);
        commentDao.save(comment);

    }

    public void addLike(int commentId) {

        commentDao.findById(commentId).ifPresent(comment -> {
            comment.setLikes(comment.getLikes() + 1);
            commentDao.save(comment);
        });

    }


}
