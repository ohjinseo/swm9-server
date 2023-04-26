package com.example.swmini.controller;


import com.example.swmini.dto.PostReadCondition;
import com.example.swmini.dto.PostRequestDto;
import com.example.swmini.dto.PostResponseDto;
import com.example.swmini.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/posts")
@RestController
public class PostController {
    private final PostService postService;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody PostRequestDto req) {
        postService.create(req);
        return ResponseEntity.ok("정상");
    }

    @GetMapping
    public ResponseEntity<List<PostResponseDto>> readAll() {
        return ResponseEntity.ok(postService.readAll());
    }

    @PostMapping("/condition")
    public ResponseEntity<List<PostResponseDto>> readAllByCondition(
            @RequestBody PostReadCondition condition
    ) {
        return ResponseEntity.ok(postService.readAllByCondition(condition));
    }

}