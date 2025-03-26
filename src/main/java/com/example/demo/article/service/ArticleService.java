package com.example.demo.article.service;

import com.example.demo.article.dto.ArticleDto;
import com.example.demo.article.entity.Article;
import com.example.demo.article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;
    //스트림형식
//    public List<ArticleDto> articleList(){
//        List<Article> articleList = this.articleRepository.findAll();
//        List<ArticleDto> articleDtoList = articleList.stream().map(article -> new ArticleDto(article)).collect(Collectors.toList());
//        return articleDtoList;
//    }
    public List<ArticleDto> articleList(){
        // Article 객체 리스트를 불러오기
        List<Article> articleList = this.articleRepository.findAll();
        // 새로운 빈 배열 생성 Article을 담을 리스트 만들기
        List<ArticleDto> articleDtoList = new ArrayList<>();
        //향상된 for문으로 불러온 articleList 리스트를 마지막까지 반복
        for(Article article: articleList){
            //Article객체를 ArticleDto에 담아서 articleDtoList에 추가 시킴
            articleDtoList.add(new ArticleDto(article));
        }
        return articleDtoList;
    }
    public Article articleView(Long id){
        Optional<Article> article = articleRepository.findById(id);
        if(article.isPresent()){
            return article.get();
        }else {
            return null;
        }
    }

    public Article write (String subject, String content){
        Article article = new Article();

        article.setSubject(subject);
        article.setContent(content);

        this.articleRepository.save(article);
        return article;
    }

    public Article update(Article article, String subject, String content) {
        article.setSubject(subject);
        article.setContent(content);

        this.articleRepository.save(article);

        return article;
    }

    public void delete(Article article) {
        this.articleRepository.delete(article);
    }
}
