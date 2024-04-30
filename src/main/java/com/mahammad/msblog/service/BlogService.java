package com.mahammad.msblog.service;

import java.util.List;
import com.mahammad.msblog.model.request.AddCommentRequest;
import com.mahammad.msblog.model.request.PostBlogRequest;
import com.mahammad.msblog.model.response.BlogResponse;

public interface BlogService {

    BlogResponse postBlog(PostBlogRequest postBlogRequest);

    BlogResponse getBlog(Long blogId);

    BlogResponse addComment(AddCommentRequest addCommentRequest);

    List<BlogResponse> filterBlogs();
}
