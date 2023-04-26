package com.example.swmini.advice;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    POST_NOT_FOUND(-1001, "해당 게시글을 찾을 수 없습니다.");

    private final int code;
    private final String message;
}
