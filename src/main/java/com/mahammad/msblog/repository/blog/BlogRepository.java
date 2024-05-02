package com.mahammad.msblog.repository.blog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BlogRepository extends JpaRepository<BlogDao, Long>, JpaSpecificationExecutor<BlogDao> {

}
