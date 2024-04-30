package com.mahammad.msblog.model.response;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogResponse {

    private Long id;

    private String name;

    private String title;

    private String content;

    private String cover;

    private Long viewedCount;

    private Boolean published;

    private Date publishedDate;

    private Date createdAt;

    private Date updatedAt;

    private Boolean status;

    private Long createdBy;

    private Long updatedBy;
}
