package com.unipa.atchannel.controller;

import com.unipa.atchannel.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/add-comment")
    public String addComment(@RequestParam String content, @RequestParam int userId, @RequestParam int postId){

        commentService.addComment(content, userId, postId);

        return "index";
    }

    @PostMapping("/add-like")
    public String addLike(@RequestParam int commentId){

        commentService.addLike(commentId);

        return "index";
    }

}
