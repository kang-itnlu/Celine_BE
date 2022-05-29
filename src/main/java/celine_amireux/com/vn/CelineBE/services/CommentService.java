package celine_amireux.com.vn.CelineBE.services;

import celine_amireux.com.vn.CelineBE.model.Comment;

import java.util.List;

public interface CommentService {
    void insert(Comment comment);

    void edit(Comment comment);

    void delete(int id);

    Comment get(int id);

    List<Comment> getAll();
}
