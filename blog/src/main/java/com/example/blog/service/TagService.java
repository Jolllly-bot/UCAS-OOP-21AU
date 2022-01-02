package com.example.blog.service;

import com.example.blog.dao.TagRepository;
import com.example.blog.handler.NotFoundException;
import com.example.blog.pojo.Tag;
import com.example.blog.pojo.Type;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService implements TagInterface{

    @Autowired
    private TagRepository tagRepository;
    
    @Override
    public Tag getTag(Long id) {
        return tagRepository.findById(id).orElseThrow(
                () -> new NotFoundException("类型不存在"));
    }

    @Override
    public Tag createTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public Tag updateTag(Tag Tag, Long id) {
        Tag t = tagRepository.findById(id).orElseThrow(
                () -> new NotFoundException("标签不存在"));
        BeanUtils.copyProperties(Tag, t);
        return tagRepository.save(t);
    }

    @Override
    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }

    @Override
    public List<Tag> listTag() {
        return tagRepository.findAll();
    }
}
