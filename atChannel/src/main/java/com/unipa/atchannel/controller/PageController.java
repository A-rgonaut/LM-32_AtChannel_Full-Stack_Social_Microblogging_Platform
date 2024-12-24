package com.unipa.atchannel.controller;

import com.unipa.atchannel.dto.PostDto;
import com.unipa.atchannel.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/at-channel")
public class PageController {

    @Autowired
    private FeedService feedService;

    @GetMapping("/home")
    public String getHome(Model model) {
        return "home";
    }

    @GetMapping("/post/{id}")
    public String getPost(Model model, @PathVariable(value="id") Object postId) {

        model.addAttribute("postId", postId);

        return "post";
    }

    @GetMapping("/profile")
    public String getProfile(Model model) {
        return "profile";
    }

    @GetMapping(value = "/get-xml", produces = MediaType.APPLICATION_XML_VALUE)
    public String getXML(Model model) {

        List<PostDto> feed = feedService.initFeed();

        model.addAttribute("feed", feed);

        return "feed";
    }
}
