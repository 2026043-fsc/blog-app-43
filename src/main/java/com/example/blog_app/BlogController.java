package com.example.blog_app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }




   @GetMapping("/") // 一覧画面
    public String home(Model model) {
        model.addAttribute("blogs", blogService.findAll());
        return "home";
    }

    







    

    @GetMapping("/blog/{id}")  // 詳細画面
    public String detail(@PathVariable int id, Model model) {
        Optional<Blog> blogOpt = blogService.findById(id); 
        
        if (blogOpt.isEmpty()) {
            return "redirect:/"; 
        }
        
        model.addAttribute("blog", blogOpt.get());
        return "Blogs/more";
    }





    
    @GetMapping("/post")
    public String postForm() {
        return "Blogs/post";
    }

    

@PostMapping("/post")
public String createBlog(
        @RequestParam("title") String title,
        @RequestParam("text") String text,
        @RequestParam("auther") String auther,
        RedirectAttributes redirectAttributes) {
    
    
    Blog blog = new Blog(0, title, text, auther);
    
    // 2. サービスを経由
    blogService.saveBlog(blog);
    
    
    
    // 4. 一覧画面へ自動リダイレクト
    return "redirect:/"; 
}
 
}

