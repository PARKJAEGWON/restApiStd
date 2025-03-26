package com.example.demo.article.dto.respose;

import com.example.demo.article.dto.ArticleDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class ArticlesResponse{
    private final List<ArticleDto> articleList;
}
