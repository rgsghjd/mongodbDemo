package com.atheima.mapper;

import com.atheima.pojo.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//第一个范型是指实体类对象，第二个是指主键的类型
@Repository
public interface CommentMapper extends MongoRepository<Comment,String> {
    Page<Comment> findByParentid(String parentid, Pageable pageable);
}
