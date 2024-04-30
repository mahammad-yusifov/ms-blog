package com.mahammad.msblog.repository.blog;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogCommentRepository extends JpaRepository<BlogCommentDao, Long> {

}
