package com.example.blog.service;

import com.example.blog.pojo.Tag;

import java.util.List;

public interface TagInterface {
    Tag getTag(Long id);
    Tag createTag(Tag Tag);
    Tag updateTag(Tag Tag, Long id);
    void deleteTag(Long id);
    List<Tag> listTag();
}
