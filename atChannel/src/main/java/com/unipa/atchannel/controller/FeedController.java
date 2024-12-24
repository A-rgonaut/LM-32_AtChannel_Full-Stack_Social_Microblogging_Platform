package com.unipa.atchannel.controller;

import com.unipa.atchannel.dto.PostDto;
import com.unipa.atchannel.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/feed")
public class FeedController {

    @Autowired
    private FeedService feedService;

    @GetMapping("/init-feed")
    public String initFeed(Model model){

        List<PostDto> feed = feedService.initFeed();

        model.addAttribute("feed", feed);

        return "feed";

    }

    @GetMapping("/get-feed/{lastId}")
    public String getFeed(Model model, @PathVariable int lastId){

        List<PostDto> feed = feedService.getFeed(lastId);

        model.addAttribute("feed", feed);

        return "feed";
    }
}
