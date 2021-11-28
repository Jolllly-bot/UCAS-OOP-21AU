package com.example.blog.web;

import com.example.blog.handler.NotFoundException;
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

    @GetMapping("/")
    public String index(@PageableDefault(size = 0, sort = {"editTime"}, direction = Sort.Direction.DESC)Pageable pageable, Model model) {
        //int i = 9/0;
        String article = null;
        //System.out.println(article);
        if(article == null)
            throw new NotFoundException("article not found");
        return "index";
    }
}
