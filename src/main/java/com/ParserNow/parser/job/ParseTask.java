package com.ParserNow.parser.job;

import com.ParserNow.parser.models.News;
import com.ParserNow.parser.service.NewsService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ParseTask {

    @Autowired
    NewsService newsService;

    @Scheduled(fixedDelay = 10000)
    public void parserNewNews(){
        String url="https://news.sportbox.ru/";

        try {
            Document doc= Jsoup.connect(url)
                    .userAgent("Yandex")
                    .timeout(5000)
                    .referrer("https://google.com")
                    .get();

            Elements news=doc.getElementsByClass("b-actually__item");
            for (Element el:news){
                String title=el.ownText();
                if (!newsService.isExist(title)){
                    News news1=new News();
                    news1.setTitle(title);
                    newsService.save(news1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
