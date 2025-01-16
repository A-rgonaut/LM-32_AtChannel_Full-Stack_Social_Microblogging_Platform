package com.unipa.atchannel.controller;

import com.unipa.atchannel.dto.PostDto;
import com.unipa.atchannel.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/{id}")
    public String getPost(Model model, @PathVariable(value="id") Object postId) {

        model.addAttribute("postId", postId);

        return "post";
    }

    @PostMapping("/get-post")
    public String getPost(Model model, @RequestParam int postId){

        PostDto post = postService.getPost(postId);
        System.out.println(post);

        model.addAttribute("feed", post);

        return "feed";
    }

    @PostMapping("/add-post")
    public String addPost(@RequestParam String content, @RequestParam int userId){

        postService.addPost(content, userId);

        return "index";
    }

    @PostMapping("/add-like")
    public String addLike(@RequestParam int postId){

        postService.addLike(postId);

        return "index";

    }

}
