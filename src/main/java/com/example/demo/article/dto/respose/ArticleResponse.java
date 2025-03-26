package com.example.demo.article.dto.respose;

import com.example.demo.article.dto.ArticleDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ArticleResponse {
    private final ArticleDto article;
}