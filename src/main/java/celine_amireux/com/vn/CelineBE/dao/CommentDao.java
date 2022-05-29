package celine_amireux.com.vn.CelineBE.dao;

import celine_amireux.com.vn.CelineBE.model.Comment;

import java.util.List;

public interface CommentDao {
    void insert(Comment comment);

    void edit(Comment oldComment);

    void delete(int id);

    Comment get(int id);

    List<Comment> getAll();
}
