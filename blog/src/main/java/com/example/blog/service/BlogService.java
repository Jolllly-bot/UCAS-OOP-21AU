package com.example.blog.service;

import com.example.blog.repository.BlogRepository;
import com.example.blog.handler.NotFoundException;
import com.example.blog.pojo.Blog;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogService implements BlogInterface{

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Blog getBlog(Long id) {
        return blogRepository.findById(id).orElseThrow(
                () -> new NotFoundException("博客不存在"));
    }

    @Override
    public Blog createBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public Blog updateBlog(Blog blog, Long id) {
        Blog b = blogRepository.findById(id).orElseThrow(
                () -> new NotFoundException("博客不存在"));
        BeanUtils.copyProperties(blog,b);
        return blogRepository.save(b);
    }

    @Override
    public void deleteBlog(Long id) {
        blogRepository.deleteById(id);
    }
}
