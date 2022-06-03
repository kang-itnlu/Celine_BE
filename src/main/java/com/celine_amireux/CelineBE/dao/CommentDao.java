package com.celine_amireux.CelineBE.dao;

import com.celine_amireux.CelineBE.model.Comment;

import java.util.List;

public interface CommentDao {
    void insert(Comment comment);

    void edit(Comment oldComment);

    void delete(int id);

    Comment get(int id);

    List<Comment> getAll();
}
