package com.hari.movie_service.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MovieRequest {
    private String title;
    private String description;
    private String releaseDate;
    private String language;
    private String status;
    private Long genreId;
}
