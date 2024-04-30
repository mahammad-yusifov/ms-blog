package com.mahammad.msblog.service.impl;

import java.util.List;
import com.mahammad.msblog.model.request.AddCommentRequest;
import com.mahammad.msblog.model.request.PostBlogRequest;
import com.mahammad.msblog.model.response.BlogResponse;
import com.mahammad.msblog.repository.blog.BlogRepository;
import com.mahammad.msblog.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;

    @Override
    public BlogResponse postBlog(PostBlogRequest postBlogRequest) {
        return null;
    }

    @Override
    public BlogResponse getBlog(GetBlogRequest getBlogRequest) {
        return null;
    }

    @Override
    public BlogResponse addComment(AddCommentRequest addCommentRequest) {
        return null;
    }

    @Override
    public List<BlogResponse> filterBlogs(Specification<BlogResponse> specification) {
        blogRepository.findAll(specification);
        return null;
    }
}
