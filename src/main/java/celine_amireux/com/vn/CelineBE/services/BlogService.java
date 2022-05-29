package celine_amireux.com.vn.CelineBE.services;

import celine_amireux.com.vn.CelineBE.model.Blog;
import celine_amireux.com.vn.CelineBE.model.Product;

import java.util.List;

public interface BlogService {
    void insert(Blog blog);

    void edit(Blog blog);

    void delete(int id);

    Blog get(int id);

    List<Blog> getAll();

    int numOfBlogs();

    List<Blog> getBlogByPage(int currentPage, int blogsPerPage);
}
