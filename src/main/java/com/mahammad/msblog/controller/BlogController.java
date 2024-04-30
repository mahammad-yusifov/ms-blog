package com.mahammad.msblog.controller;

import java.util.List;
import com.mahammad.msblog.model.request.PostBlogRequest;
import com.mahammad.msblog.model.response.AuthenticationResponse;
import com.mahammad.msblog.model.response.BlogResponse;
import com.mahammad.msblog.service.BlogService;
import com.turkraft.springfilter.boot.Filter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/blog/v1")
@RequiredArgsConstructor
@Slf4j
public class BlogController {

    private final BlogService blogService;

    @PostMapping()
    public ResponseEntity<BlogResponse> postBlog(@RequestBody PostBlogRequest postBlogRequest,
                                                 @RequestHeader("Authorization") String authorizationHeader) {
        log.debug("post blog for {} start", userId);
        AuthenticationResponse postBlogResponse = blogService.postBlog(postBlogRequest, authorizationHeader);
        log.debug("post blog for {} end", userId);
        return ResponseEntity.ok(postBlogResponse);
    }

    @GetMapping()
    public ResponseEntity<BlogResponse> getBlog(@PathVariable Long blogId,
                                                 @RequestHeader("Authorization") String authorizationHeader) {
        log.debug("get full blog for {} start", userId);
        AuthenticationResponse postBlogResponse = blogService.getBlog(blogId, authorizationHeader);
        log.debug("get full blog for {} end", userId);
        return ResponseEntity.ok(postBlogResponse);
    }

    @GetMapping(value = "/all")
    public List<BlogResponse> search(@Filter Specification<BlogResponse> specification) {
        return blogService.filterBlogs(specification);
    }

}
