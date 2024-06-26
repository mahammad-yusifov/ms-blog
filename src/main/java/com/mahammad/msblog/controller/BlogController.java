package com.mahammad.msblog.controller;

import java.util.List;

import com.mahammad.msblog.model.request.AddCommentRequest;
import com.mahammad.msblog.model.request.PostBlogRequest;
import com.mahammad.msblog.repository.blog.BlogCommentDao;
import com.mahammad.msblog.repository.blog.BlogDao;
import com.mahammad.msblog.service.BlogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/blog/v1")
@RequiredArgsConstructor
@Slf4j
public class BlogController {

    private final BlogService blogService;

    @PostMapping()
    public ResponseEntity<BlogDao> postBlog(@RequestBody PostBlogRequest postBlogRequest,
                                            @RequestHeader("Authorization") String authorizationHeader) {
        BlogDao postBlogResponse = blogService.postBlog(postBlogRequest, authorizationHeader);
        return ResponseEntity.ok(postBlogResponse);
    }

    @GetMapping("/{blogId}")
    public ResponseEntity<BlogDao> getBlog(@PathVariable Long blogId) {
        BlogDao getBlogDao = blogService.getBlog(blogId);
        return ResponseEntity.ok(getBlogDao);
    }

    @GetMapping(value = "/filter")
    public List<BlogDao> filter(@RequestParam(value = "searchQuery") String searchQuery) {
        return blogService.filterBlogs(searchQuery);
    }

    @PostMapping("/comment")
    public ResponseEntity<BlogCommentDao> addComment(@RequestBody AddCommentRequest addCommentRequest,
                                                     @RequestHeader("Authorization") String authorizationHeader) {
        BlogCommentDao addCommentResponse = blogService.addComment(addCommentRequest, authorizationHeader);
        return ResponseEntity.ok(addCommentResponse);
    }

}
