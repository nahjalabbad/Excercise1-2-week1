package org.example.service.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.service.API.ApiResponse;
import org.example.service.Model.Article;
import org.example.service.Service.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/article")
public class ArticleController {

    private final ArticleService articleService;


    @GetMapping()
    public ResponseEntity getArticle(){
        return ResponseEntity.ok(articleService.getArticles());
    }

    @PostMapping("/add")
    public ResponseEntity addArticle(@RequestBody @Valid Article article, Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        articleService.addArticle(article);
        return ResponseEntity.status(200).body(new ApiResponse("Article Added"));
    }

    @PutMapping("/update/{id}")
    private ResponseEntity updateArticle(@PathVariable int id, @RequestBody @Valid Article article, Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated= articleService.updateArticle(id,article);
        if (isUpdated){
            return ResponseEntity.status(200).body(new ApiResponse("Article has been updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Article not found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteArticle(@PathVariable int id){
        boolean isDeleted=articleService.deleteArticle(id);
        if (isDeleted){
            return ResponseEntity.status(200).body(new ApiResponse("Article has been deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Article not found"));
    }

    @PutMapping("/publish/{id}")
    public ResponseEntity publish(@PathVariable int id){
        boolean isPublished=articleService.publish(id);
        if (isPublished){
            return ResponseEntity.status(200).body(new ApiResponse("The Article now has been published "));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Article not found"));
    }

    @GetMapping("/ispublished/{isPublished}")
    public ResponseEntity publishedArticles(@PathVariable boolean isPublished){
        ArrayList<Article> published=articleService.isPublished(isPublished);
        if (published==null){
            return ResponseEntity.status(400).body(new ApiResponse("no article has been published yet"));
        }
        return ResponseEntity.status(200).body(published);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity getByCategory(@PathVariable String category){
        ArrayList<Article>byCate=articleService.getByCategory(category);
        if (byCate==null){
            return ResponseEntity.status(400).body(new ApiResponse("no article with this category is found"));
        }
        return ResponseEntity.status(200).body(byCate);
    }

}
