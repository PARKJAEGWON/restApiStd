package com.example.demo.article.controller;

import com.example.demo.article.dto.ArticleDto;
import com.example.demo.article.dto.request.ArticleCreateRequest;
import com.example.demo.article.dto.request.ArticleModifyRequest;
import com.example.demo.article.dto.respose.ArticleResponse;
import com.example.demo.article.dto.respose.ArticlesResponse;
import com.example.demo.article.entity.Article;
import com.example.demo.article.service.ArticleService;
import com.example.demo.global.Rsdata.RsData;
import jakarta.validation.Valid;
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
    public RsData<ArticlesResponse> list() {
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

        ArticlesResponse articleResponse = new ArticlesResponse(articleList);

        return RsData.of("200","메세지 목록 조회 성공",articleResponse);
    }

    @GetMapping("/{id}")
    public RsData<ArticleResponse> getArticle(@PathVariable("id") Long id) {

        System.out.println(id);
        Article article = new Article("제목이야","내용이야");

        ArticleDto articleDto = new ArticleDto(article);

        return RsData.of("200","게시글 단건 조회 성공", new ArticleResponse(articleDto));
    }

    @PostMapping
    public String create(@Valid @RequestBody ArticleCreateRequest articleCreateRequest) {
        System.out.println(articleCreateRequest.getContent());
        System.out.println(articleCreateRequest.getSubject());
        return "생성";
    }

    @PatchMapping("{id}")
    public String modify(@PathVariable("id")Long id, @Valid @RequestBody ArticleModifyRequest articleModifyRequest) {
        System.out.println(id);
        System.out.println(articleModifyRequest.getSubject());
        System.out.println(articleModifyRequest.getContent());
        return "수정";
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable("id")Long id) {
        System.out.println(id);

        return "삭제";
    }
}
