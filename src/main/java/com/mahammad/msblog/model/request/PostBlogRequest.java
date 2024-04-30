package com.mahammad.msblog.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostBlogRequest {


    private String name;

    private String title;

    private String content;

    private String cover;

}
