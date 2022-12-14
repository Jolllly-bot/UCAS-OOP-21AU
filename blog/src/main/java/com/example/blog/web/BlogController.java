package com.example.blog.web;

import com.example.blog.pojo.Blog;
import com.example.blog.pojo.Type;
import com.example.blog.service.BlogService;
import com.example.blog.service.TypeService;
import com.example.blog.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class BlogController {
    private final static String INPUT = "admin/blogs-input";
    private final static String LIST = "admin/blogs";
    private final static String RELIST = "redirect:admin/blogs";

    @Autowired
    private BlogService blogService;
    @Autowired
    private TypeService typeService;

    @GetMapping("/blogs")
    public String blogs(
            @PageableDefault(size = 2, sort = {"editTime"}, direction = Sort.Direction.DESC) Pageable pageable,
            BlogQuery blog,
            Model model) {
        model.addAttribute("types", typeService.listType());
        model.addAttribute("page", blogService.listBlog(pageable, blog));
        return INPUT;
    }

    @PostMapping("/blogs/search")
    public String search(
            @PageableDefault(size = 2, sort = {"editTime"}, direction = Sort.Direction.DESC) Pageable pageable,
            BlogQuery blog,
            Model model) {
        model.addAttribute("page", blogService.listBlog(pageable, blog));
        return "admin/blogs :: blogList";
        }

//    @GetMapping("/blogs/input")
//    public String input(Model model) {
//        //model.addAttribute("blog", new Blog());
//        return INPUT;
//    }
}
