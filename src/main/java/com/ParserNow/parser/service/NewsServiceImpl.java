package com.ParserNow.parser.service;

import com.ParserNow.parser.models.News;
import com.ParserNow.parser.repo.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    NewsRepository newsRepository;

    @Override
    public void save(News news) {
        newsRepository.save(news);

    }

    @Override
    public boolean isExist(String newsTitle) {
        List<News> news = newsRepository.findAll();
        for (News n : news) {
            if (n.getTitle().equals(newsTitle)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<News> getAllNews() {
        return newsRepository.findAll();
    }
}
