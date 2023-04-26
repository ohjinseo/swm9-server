package com.example.swmini.repository;

import com.example.swmini.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByLectureNameContaining(String lectureName);
    List<Post> findAllByMentorContaining(String mentor);
}
