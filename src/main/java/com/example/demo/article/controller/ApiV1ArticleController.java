package com.example.demo.article.controller;

import com.example.demo.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/articles")
public class ApiV1ArticleController {

    private final ArticleService articleService;

    @GetMapping
    public String list() {
        return "";
    }
    @GetMapping("/{id}")
    public String getArticle() {
        return "";
    }

    @PostMapping
    public String create() {
        return "";
    }

    @PatchMapping("{id}")
    public String modify() {
        return "";
    }

    @DeleteMapping("{id}")
    public String delete() {
        return "";
    }
}
