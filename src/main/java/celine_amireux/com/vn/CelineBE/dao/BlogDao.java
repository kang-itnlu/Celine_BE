package celine_amireux.com.vn.CelineBE.dao;

import celine_amireux.com.vn.CelineBE.model.Blog;
import celine_amireux.com.vn.CelineBE.model.Product;

import java.util.List;

public interface BlogDao {
    void insert(Blog blog);

    void edit(Blog blog);

    void delete(int id);

    Blog get(int id);

    List<Blog> getAll();

    List<Blog> getBlogByPage(int currentPage, int blogsPerPage);

    int getNumOfBlogs();
}
