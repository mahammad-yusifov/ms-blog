package com.mahammad.msblog.service.impl;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import com.mahammad.msblog.mapper.BlogMapper;
import com.mahammad.msblog.model.request.AddCommentRequest;
import com.mahammad.msblog.model.request.PostBlogRequest;
import com.mahammad.msblog.model.response.BlogResponse;
import com.mahammad.msblog.repository.blog.BlogCommentDao;
import com.mahammad.msblog.repository.blog.BlogCommentRepository;
import com.mahammad.msblog.repository.blog.BlogDao;
import com.mahammad.msblog.repository.blog.BlogRepository;
import com.mahammad.msblog.repository.user.UserDao;
import com.mahammad.msblog.service.BlogService;
import com.mahammad.msblog.util.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;
    private final BlogCommentRepository blogCommentRepository;
    private final BlogMapper blogMapper;
    private final Util util;

    @Override
    public BlogDao postBlog(PostBlogRequest postBlogRequest, String header) {
        UserDao user = util.getUserFromAuthHeader(header);
        BlogDao blogDao = blogMapper.toBlogDao(postBlogRequest, user);
        return blogRepository.save(blogDao);
    }

    @Override
    public BlogDao getBlog(Long blogId) {
        Optional<BlogDao> blogDao = blogRepository.findById(blogId);
        return blogDao.get();
    }

    @Override
    public BlogCommentDao addComment(AddCommentRequest addCommentRequest, String header) {
        UserDao user = util.getUserFromAuthHeader(header);
        BlogCommentDao blogCommentDao = blogMapper.toBlogCommentDao(addCommentRequest, user);
        return blogCommentRepository.save(blogCommentDao);
    }

    @Override
    public List<BlogDao> filterBlogs(Specification<BlogDao> specification, Pageable pageable) {
//        return blogRepository.findAll(specification, pageable);
        return null;
    }
}
