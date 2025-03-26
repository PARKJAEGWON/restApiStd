package com.example.demo.article.controller;

import com.example.demo.article.dto.ArticleDto;
import com.example.demo.article.entity.Article;
import com.example.demo.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/articles")
public class ApiV1ArticleController {

    private final ArticleService articleService;

    @GetMapping
    public List<ArticleDto> list() {
        List<ArticleDto> articleList = new ArrayList<>();

        //가독성 좋은 방식
        Article article1 = new Article("제목1","내용1");
        articleList.add(new ArticleDto(article1));

        // 순차적으로 풀이 방식
        Article article2 = new Article("제목2","내용2");
        ArticleDto articleDto = new ArticleDto(article2);
        articleList.add(articleDto);

        Article article3 = new Article("제목3","내용3");
        articleList.add(new ArticleDto(article3));

        return articleList;
    }

    @GetMapping("/{id}")
    public String getArticle() {
        return "단건";
    }

    @PostMapping
    public String create() {
        return "생성";
    }

    @PatchMapping("{id}")
    public String modify() {
        return "수정";
    }

    @DeleteMapping("{id}")
    public String delete() {
        return "삭제";
    }
}
