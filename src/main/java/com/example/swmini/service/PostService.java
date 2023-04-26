package com.example.swmini.service;

import com.example.swmini.domain.Post;
import com.example.swmini.dto.PostReadCondition;
import com.example.swmini.dto.PostRequestDto;
import com.example.swmini.dto.PostResponseDto;
import com.example.swmini.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public void create(PostRequestDto req) {
        postRepository.save(PostRequestDto.toEntity(req));
    }

    public List<PostResponseDto> readAll() {
        return postRepository.findAll().stream().map(PostResponseDto::toDto).collect(Collectors.toList());
    }

    public List<PostResponseDto> readAllByCondition(PostReadCondition condition) {
        List<Post> posts;

        if (condition.getCategory().equals("강의명")) {
            posts = postRepository.findAllByLectureNameContaining(condition.getSearchValue());
        }else{
            posts = postRepository.findAllByMentorContaining(condition.getSearchValue());
        }

        return posts.stream().map(PostResponseDto::toDto).collect(Collectors.toList());
    }
}
