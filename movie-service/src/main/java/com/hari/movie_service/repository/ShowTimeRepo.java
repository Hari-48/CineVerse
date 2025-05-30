package com.hari.movie_service.repository;

import com.hari.movie_service.entity.ShowTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowTimeRepo extends JpaRepository<ShowTime,Long> {
}
