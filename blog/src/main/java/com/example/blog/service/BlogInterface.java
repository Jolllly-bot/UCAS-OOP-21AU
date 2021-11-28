package com.example.blog.service;

import com.example.blog.pojo.Blog;

public interface BlogInterface {
    Blog getBlog(Long id);
    Blog createBlog(Blog blog);
    Blog updateBlog(Blog blog, Long id);
    void deleteBlog(Long id);
}
