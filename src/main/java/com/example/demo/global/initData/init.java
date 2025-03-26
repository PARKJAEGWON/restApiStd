package com.example.demo.global.initData;

import com.example.demo.article.service.ArticleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class init {
    @Bean
    CommandLineRunner initData(ArticleService articleService){

        return args -> {
            articleService.write("제목1","내용1");
            articleService.write("제목2","내용2");
            articleService.write("제목3","내용3");
            articleService.write("제목4","내용4");
            articleService.write("제목5","내용5");
            articleService.write("제목6","내용6");
        };
    }
}
