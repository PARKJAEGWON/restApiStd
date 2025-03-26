package com.example.demo.article.dto;

import com.example.demo.article.entity.Article;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ArticleDto {
    //final 최초의 한번 무조건 초기화 해준다는 의미
    private final Long id;

    private final String subject;

    private final  String content;

    private final LocalDateTime createDate;

    private final LocalDateTime modifiedDate;

    public ArticleDto(Article article){
        this.id             = article.getId();
        this.subject        = article.getSubject();
        this.content        = article.getContent();
        this.createDate     = article.getCreateDate();
        this.modifiedDate   = article.getModifiedDate();
    }
}
