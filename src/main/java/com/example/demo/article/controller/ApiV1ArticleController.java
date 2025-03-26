package com.example.demo.article.controller;

import com.example.demo.article.dto.ArticleDto;
import com.example.demo.article.dto.request.ArticleCreateRequest;
import com.example.demo.article.dto.request.ArticleModifyRequest;
import com.example.demo.article.dto.respose.ArticleCreateResponse;
import com.example.demo.article.dto.respose.ArticleModifyResponse;
import com.example.demo.article.dto.respose.ArticleResponse;
import com.example.demo.article.dto.respose.ArticlesResponse;
import com.example.demo.article.entity.Article;
import com.example.demo.article.service.ArticleService;
import com.example.demo.global.Rsdata.RsData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/articles",produces = APPLICATION_JSON_VALUE,consumes = APPLICATION_JSON_VALUE)
@Tag(name = "ApiV1ArticleController", description = "게시글 CRUD API")
public class ApiV1ArticleController {

    private final ArticleService articleService;

    @GetMapping
    @Operation(summary = "게시글 목록 조회")
    public RsData<ArticlesResponse> list() {
        List<ArticleDto> articleList = articleService.articleList();

        ArticlesResponse articleResponse = new ArticlesResponse(articleList);

        return RsData.of("200","메세지 목록 조회 성공",articleResponse);
        //한번에 해결
        //return RsData.of("200","메세지 목록 조회 성공",new ArticlesResponse(articleList));
    }

    @GetMapping("/{id}")
    @Operation(summary = "게시글 단건 조회")
    public RsData<ArticleResponse> getArticle(@PathVariable("id") Long id) {
        Article article = articleService.articleView(id);

        ArticleDto articleDto = new ArticleDto(article);

        return RsData.of("200","게시글 단건 조회 성공", new ArticleResponse(articleDto));
    }

    @PostMapping
    @Operation(summary = "게시글 등록")
    public RsData<ArticleCreateResponse> create(@Valid @RequestBody ArticleCreateRequest articleCreateRequest) {
        Article article = this.articleService.write(articleCreateRequest.getSubject(),articleCreateRequest.getContent());

        return RsData.of("200","등록 성공",new ArticleCreateResponse(article));
    }

    @PatchMapping("{id}")
    @Operation(summary = "게시글 수정")
    public RsData<ArticleModifyResponse> modify(@PathVariable("id")Long id, @Valid @RequestBody ArticleModifyRequest articleModifyRequest) {
        Article article = this.articleService.articleView(id);

        if (article == null)RsData.of(
            "500",
            "게시물이 존재하지 않습니다.".formatted(id),
                null
        );

        Article updateArticle = this.articleService.update(article,articleModifyRequest.getSubject(),articleModifyRequest.getContent());

        return RsData.of("200", "수정 성공", new ArticleModifyResponse(updateArticle));
    }

    @DeleteMapping("{id}")
    @Operation(summary = "게시글 삭제")
    public RsData<ArticleResponse> delete(@PathVariable("id")Long id) {
        Article article = this.articleService.articleView(id);
        if (article == null)RsData.of(
                "500",
                "게시물이 존재하지 않습니다.".formatted(id),
                null
        );
         this.articleService.delete(article);

        return RsData.of("200", "삭제 성공",new ArticleResponse(new ArticleDto(article)));
    }
}
