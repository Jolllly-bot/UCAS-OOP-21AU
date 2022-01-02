package com.example.blog.service;

import com.example.blog.handler.NotFoundException;
import com.example.blog.pojo.Type;
import com.example.blog.dao.TypeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService implements TypeInterface{
    @Autowired
    private TypeRepository typeRepository;


    @Override
    public Type getType(Long id) {
        return typeRepository.findById(id).orElseThrow(
                () -> new NotFoundException("类型不存在"));
    }

    @Override
    public Type createType(Type type) {
        return typeRepository.save(type);
    }

    @Override
    public Type updateType(Type type, Long id) {
        Type t = typeRepository.findById(id).orElseThrow(
                () -> new NotFoundException("分类不存在"));
        BeanUtils.copyProperties(type, t);
        return typeRepository.save(t);
    }

    @Override
    public void deleteType(Long id) {
        typeRepository.deleteById(id);
    }

    @Override
    public List<Type> listType() {
        return typeRepository.findAll();
    }
}
