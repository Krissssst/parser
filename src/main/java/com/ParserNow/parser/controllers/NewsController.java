package com.ParserNow.parser.controllers;

import com.ParserNow.parser.models.News;
import com.ParserNow.parser.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NewsController {
    @Autowired
    NewsService newsService;
    @GetMapping(value = "/news")
    public List<News> getAllNews(){
        return newsService.getAllNews();
    }
}
