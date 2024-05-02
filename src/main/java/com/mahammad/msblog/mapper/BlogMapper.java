package com.mahammad.msblog.mapper;

import com.mahammad.msblog.model.request.AddCommentRequest;
import com.mahammad.msblog.model.request.PostBlogRequest;
import com.mahammad.msblog.model.request.UserRegisterRequest;
import com.mahammad.msblog.repository.blog.BlogCommentDao;
import com.mahammad.msblog.repository.blog.BlogDao;
import com.mahammad.msblog.repository.user.UserDao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface BlogMapper {

    @Mapping(target = "name", source = "user.name")
    BlogDao toBlogDao(PostBlogRequest postBlogRequest, UserDao user);

    BlogCommentDao toBlogCommentDao(AddCommentRequest addCommentRequest, UserDao user);
}
