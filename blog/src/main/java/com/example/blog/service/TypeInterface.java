package com.example.blog.service;

import com.example.blog.pojo.Type;

import java.util.List;

public interface TypeInterface {
    Type getType(Long id);
    Type createType(Type type);
    Type updateType(Type type, Long id);
    void deleteType(Long id);
    List<Type> listType();
}
