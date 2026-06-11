package com.example.blog_app;


import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class BlogRepository {

     private final JdbcClient jdbcClient;

    public BlogRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }


    
    public List<Blog> home() {
        return jdbcClient.sql("SELECT id,title,text,auther FROM Blogs.blog")
                .query(Blog.class)
                .list();
    }


    // 2. コントローラーから呼び出される全件取得メソッド（findAll）
    public List<Blog> findAll() {
        return jdbcClient.sql("SELECT id, title, text, auther FROM Blogs.blog")
                .query(Blog.class)
                .list();
    }


    // 3. 記事詳細表示用（searchById）
    public Optional<Blog> searchById(int id) {
       return jdbcClient.sql("SELECT id,title,text,auther FROM Blogs.blog WHERE id = :id")
                .param("id", id)
                .query(Blog.class)
                .optional();
    }

     



    public void save(Blog blog) {
    jdbcClient.sql(
            
            "INSERT INTO Blogs.blog (title, text, auther) VALUES (:title, :text, :auther)")
            
            .param("title", blog.getTitle())
            .param("text", blog.getText())
            .param("auther", blog.getAuther())
            .update();
   }

    


    // BlogRepository.java の中（クラスの内側の一番下など）に追加してください

 public boolean existsByTitle(String title) {
    // 同じタイトルの記事が何件あるか数えるSQL
    Integer count = jdbcClient.sql("SELECT COUNT(*) FROM Blogs.blog WHERE title = :title")
            .param("title", title)
            .query(Integer.class)
            .single(); // 1つの数字（件数）として結果を受け取る
            
    // 0件より多ければ true（すでに存在する）、0件なら false（存在しない）を返す
    return count > 0;
}







      
}
