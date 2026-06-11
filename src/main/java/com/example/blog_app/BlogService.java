package com.example.blog_app;

import java.util.Optional;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BlogService {
  private final BlogRepository blogRepository;

  public BlogService(BlogRepository blogRepository) {
    this.blogRepository = blogRepository;
  }

  public List<Blog> findAll() {
    return blogRepository.findAll();
  }

    public void saveBlog(Blog blog) {
        if (blog.getId() == 0) {

        }
        blogRepository.save(blog);
    }

    public Optional<Blog> findById(int id) {
        return blogRepository.searchById(id);
    }
    
}

