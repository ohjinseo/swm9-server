package com.example.swmini.dto;


import com.example.swmini.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PostResponseDto {
    private Long number;
    private String title;
    private String lectureName;
    private Integer rating;
    private String mentor;
    private String date;
    private String pros;
    private String cons;

    public static PostResponseDto toDto(Post post) {
        return new PostResponseDto(post.getNumber(), post.getTitle(), post.getLectureName(), post.getRating(), post.getMentor()
                , post.getDate(), post.getPros(), post.getCons());
    }
}

