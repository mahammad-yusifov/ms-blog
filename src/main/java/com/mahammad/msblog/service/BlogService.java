package com.mahammad.msblog.service;

import java.awt.print.Pageable;
import java.util.List;

import com.mahammad.msblog.model.request.AddCommentRequest;
import com.mahammad.msblog.model.request.PostBlogRequest;
import com.mahammad.msblog.model.response.BlogResponse;
import com.mahammad.msblog.repository.blog.BlogCommentDao;
import com.mahammad.msblog.repository.blog.BlogDao;
import org.springframework.data.jpa.domain.Specification;

public interface BlogService {

    BlogDao postBlog(PostBlogRequest postBlogRequest, String header);

    BlogDao getBlog(Long blogId);

    BlogCommentDao addComment(AddCommentRequest addCommentRequest, String header);

    List<BlogDao> filterBlogs(Specification<BlogDao> specification, Pageable pageable);
}
