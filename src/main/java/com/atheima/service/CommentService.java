package com.atheima.service;

import com.atheima.mapper.CommentMapper;
import com.atheima.pojo.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentService {
    @Resource
    CommentMapper commentMapper;
    public void add(Comment comment){
        commentMapper.save(comment);
    }
    public void remove(String id){
        commentMapper.deleteById(id);
    }
    public void find(){
        List<Comment> all = commentMapper.findAll();
        all.forEach(System.out::println);
    }
    public void update(Comment comment){
        commentMapper.save(comment);
    }
    public void page(String pid,int size,int limit){
        Page<Comment> commentPage = commentMapper.findByParentid(pid, PageRequest.of(size - 1, limit));
        commentPage.getContent().forEach(System.out::println);
    }
    @Resource
    MongoTemplate mongoTemplate;
    public void updateThumbup(String id){
        Update update = new Update();
        update.inc("likenum");
        mongoTemplate.updateFirst(new Query(Criteria.where("_id").is(id)),update,"comment");
    }
}
