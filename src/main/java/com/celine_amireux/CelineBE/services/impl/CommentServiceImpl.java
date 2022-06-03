package com.celine_amireux.CelineBE.services.impl;

import com.celine_amireux.CelineBE.dao.CommentDao;
import com.celine_amireux.CelineBE.dao.impl.CommentDaoImpl;
import com.celine_amireux.CelineBE.model.Comment;
import com.celine_amireux.CelineBE.services.CommentService;

import java.util.List;

public class CommentServiceImpl implements CommentService {
    CommentDao commentDao = (CommentDao) new CommentDaoImpl();

    @Override
    public void insert(Comment comment) {
        commentDao.insert(comment);
    }

    @Override
    public void edit(Comment comment) {
        Comment oldComment = commentDao.get(comment.getId());
        oldComment.setContent(comment.getContent());
        oldComment.setRating(comment.getRating());
        oldComment.setTime(comment.getTime());


        commentDao.edit(oldComment);
    }

    @Override
    public void delete(int id) {
        commentDao.delete(id);
    }

    @Override
    public Comment get(int id) {
        return commentDao.get(id);
    }

    @Override
    public List<Comment> getAll() {
        return commentDao.getAll();
    }
}
