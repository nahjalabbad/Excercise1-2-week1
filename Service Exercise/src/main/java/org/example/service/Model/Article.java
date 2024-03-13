package org.example.service.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Article {
    @NotNull(message = "ID cannot be null")
    private int id;

    @NotNull(message = "Title cannot be null")
    @Size(max = 100,message = "Title limit is 100 characters")
    private String title;


    @NotNull(message = "Author cannot be null")
    @Size(min = 4,max = 20,message = "Author name must be between 4 characters and 20 ")
    private String author;

    @NotNull(message = "Content cannot be null")
    @Size(max = 200,message = "content cant exceed 200 characters")
    private String content;

    @NotNull(message = "Category cannot be null")
    @Pattern(regexp = "^(politics|sports|technology)$")
    private String category;

    @NotNull(message = "URL cannot be null")
    private String imageURL;

    private boolean isPublished=false;

    private LocalDate publishDate;

}
