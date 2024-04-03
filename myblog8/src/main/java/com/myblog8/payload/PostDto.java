package com.myblog8.payload;

import lombok.*;

@Data // It lombok annotation generate getters and setters and reduce the code.
@AllArgsConstructor //Generates Constructor with One Parameter for every field in the Class.
@NoArgsConstructor  //Generates Constructor with No Parameters.
public class PostDto {

    private Long id;
    private String title;
    private String description;
    private String content;

}
