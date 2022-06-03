package com.celine_amireux.CelineBE.services;

import com.celine_amireux.CelineBE.model.Comment;

import java.util.List;

public interface CommentService {
    void insert(Comment comment);

    void edit(Comment comment);

    void delete(int id);

    Comment get(int id);

    List<Comment> getAll();
}
