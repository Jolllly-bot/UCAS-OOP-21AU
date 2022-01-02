package com.example.blog.service;

import com.example.blog.pojo.Blog;
import com.example.blog.vo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogInterface {
    Blog getBlog(Long id);
    Blog createBlog(Blog blog);
    Blog updateBlog(Blog blog, Long id);
    void deleteBlog(Long id);
    public Page<Blog> listBlog(Pageable pageable, BlogQuery blog);
}
