package com.celine_amireux.CelineBE.services.impl;

import com.celine_amireux.CelineBE.dao.BlogDao;
import com.celine_amireux.CelineBE.dao.impl.BlogDaoImpl;
import com.celine_amireux.CelineBE.model.Blog;
import com.celine_amireux.CelineBE.services.BlogService;

import java.io.File;
import java.util.List;

public class BlogServiceImpl implements BlogService {
    BlogDao dao = new BlogDaoImpl();

    @Override
    public void insert(Blog blog) {
        dao.insert(blog);
    }

    @Override
    public void edit(Blog newBlog) {
        Blog oldBlog = dao.get(newBlog.getId());

        oldBlog.setName(newBlog.getName());
        oldBlog.setBlog_category(newBlog.getBlog_category());
        oldBlog.setDate(newBlog.getDate());
        oldBlog.setDes(newBlog.getDes());
        if (newBlog.getImage() != null) {
            // XOA ANH CU DI
            String fileName = oldBlog.getImage();
            final String dir = "F:\\upload";
            File file = new File(dir + "/" + fileName);
            if (file.exists()) {
                file.delete();
            }

            oldBlog.setImage(newBlog.getImage());
        }

        dao.edit(oldBlog);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public Blog get(int id) {
        return dao.get(id);
    }

    @Override
    public List<Blog> getAll() {
        return dao.getAll();
    }

    @Override
    public int numOfBlogs() {
        return dao.getNumOfBlogs();
    }

    @Override
    public List<Blog> getBlogByPage(int currentPage, int blogsPerPage) {
        return dao.getBlogByPage(currentPage, blogsPerPage);
    }

}
