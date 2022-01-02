package com.example.blog.web;

import com.example.blog.handler.NotFoundException;
import com.example.blog.service.BlogService;
import com.example.blog.service.TagService;
import com.example.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class IndexController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    @GetMapping("/index")
    public String index(@PageableDefault(size = 1, sort = {"editTime"}, direction = Sort.Direction.DESC)Pageable pageable, Model model) {

        return "index";
    }
}
