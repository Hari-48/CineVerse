package com.hari.movie_service.repository;

import com.hari.movie_service.DTO.MovieResponse;
import com.hari.movie_service.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface MovieRepo extends JpaRepository<Movie,Long> {

//    @Query("SELECT DISTINCT m FROM Movie m LEFT JOIN FETCH m.genre LEFT JOIN FETCH m.casts")
//    List<Movie> findAllWithGenreAndCasts();





    @Query(value = "\n" +
            "select m.ID , m.`LANGUAGE` ,m.DESCRIPTION , m.TITLE ,g.NAME ,m.genre_id  , m.CREATED_AT , m.UPDATED_AT  , m.RELEASE_DATE  , m.DESCRIPTION  FROM MOVIE m LEFT JOIN GENRE g ON m.genre_id = g.ID\n" +
            "\n",nativeQuery = true)
    List<Map<String,Object>> findAllWithGenre();

    @Query(value = """
        SELECT 
            m.ID AS movie_id, 
            m.TITLE AS movie_title, 
            m.LANGUAGE,  
            m.DESCRIPTION,  
            m.RELEASE_DATE,
            
            g.NAME AS genre_name,
            
            st.SHOW_NAME,
            st.THEATRE_NAME,

            p.URL AS poster_url,
            p.IS_ACTIVE AS poster_active,

            c.ID AS cast_id,
            c.NAME AS cast_name

        FROM MOVIE m
        LEFT JOIN GENRE g ON m.genre_id = g.ID
        LEFT JOIN SHOW_TIME st ON m.ID = st.MOVIE_ID
        LEFT JOIN POSTER p ON m.ID = p.MOVIE_ID
        LEFT JOIN movies_cast mc ON m.ID = mc.movie_id
        LEFT JOIN `CAST` c ON c.ID = mc.cast_id
    """, nativeQuery = true)
    List<Map<String, Object>> findMovies();
}
